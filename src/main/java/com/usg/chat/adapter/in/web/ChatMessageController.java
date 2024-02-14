package com.usg.chat.adapter.in.web;

import com.usg.chat.adapter.in.web.dto.MessageDTO;
import com.usg.chat.adapter.in.web.dto.Result;
import com.usg.chat.application.port.in.Message.SaveChatCommand;
import com.usg.chat.application.port.in.Message.SaveChatUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate messagingTemplate;
    private final SaveChatUseCase saveChatUseCase;

    @MessageMapping("/chat")
    public ResponseEntity<Result> sendChat(@Payload MessageDTO message) {
        message.setTimestamp(LocalDateTime.now());  //메시지 전송 시간 설정

        messagingTemplate.convertAndSendToUser(
                message.getReceiverId().toString(),
                "/queue/messages",
                message);

        SaveChatCommand command = SaveChatCommand.builder()
                .message(message.getMessage())
                .senderId(message.getSenderId())
                .receiverId(message.getReceiverId())
                .timestamp(message.getTimestamp())
                .build();

        Long savedChatId = saveChatUseCase.saveMessage(command);

        log.info("메시지 전송 완료: {}",message);
        log.info("메시지 저장 완료: {}", savedChatId);
        return ResponseEntity.ok(new Result(message,"메시지 전송 완료"));
    }
}
