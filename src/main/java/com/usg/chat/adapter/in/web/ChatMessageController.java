package com.usg.chat.adapter.in.web;

import com.usg.chat.adapter.in.web.dto.MessageDTO;
import com.usg.chat.adapter.in.web.dto.Result;
import com.usg.chat.application.port.in.Message.SaveChatCommand;
import com.usg.chat.application.port.in.Message.SaveChatUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatMessageController {

    private final SaveChatUseCase saveChatUseCase;

    @MessageMapping("/chat/{chatRoomId}") // 채팅방 ID에 따라 주제 설정
    @SendTo("/topic/chat/{chatRoomId}") // 채팅방 ID에 따라 주제 설정
    public ResponseEntity<Result> sendChat(@Payload MessageDTO message, @DestinationVariable Long chatRoomId) {
        message.setTimestamp(LocalDateTime.now());  //메시지 전송 시간 설정

        SaveChatCommand command = SaveChatCommand.builder()
                .message(message.getMessage())
                .senderId(message.getSenderId())
                .receiverId(message.getReceiverId())
                .timestamp(message.getTimestamp())
                .chatRoomId(chatRoomId) // 채팅방 ID 설정
                .build();

        Long savedChatId = saveChatUseCase.saveMessage(command);

        log.info("메시지 저장 완료: {}", savedChatId);
        log.info("메시지 저장 완료: {}", savedChatId);
        return ResponseEntity.ok(new Result(message, "메시지 전송 및 저장 완료"));
    }

}