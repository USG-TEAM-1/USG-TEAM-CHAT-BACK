package com.usg.chat.adapter.in.web;

import com.usg.chat.adapter.in.web.dto.MessageRequest;
import com.usg.chat.adapter.in.web.dto.Result;
import com.usg.chat.application.port.in.SendMessageUseCase;
import com.usg.chat.domain.Chat;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatApiController {
    private final SendMessageUseCase sendMessageUseCase;

    @Operation(summary = "메시지 전송 *")
    @PostMapping("api/send")
    public ResponseEntity<Result> sendMessage(@RequestBody MessageRequest request){
        Chat chat = Chat.builder()
                .message(request.getMessage())
                .senderId(request.getSenderId())
                .receiverId(request.getReceiverId())
                .build();
        sendMessageUseCase.sendMessage(chat);
        return ResponseEntity.ok(new Result(request.getMessage() , "메시지 전송 완료"));
    }
}
