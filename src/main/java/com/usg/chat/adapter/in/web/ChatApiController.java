package com.usg.chat.adapter.in.web;

import com.usg.chat.adapter.in.web.dto.MessageRequest;
import com.usg.chat.adapter.in.web.dto.Result;
import com.usg.chat.application.port.in.GetMessageHistoryUseCase;
import com.usg.chat.application.port.in.SendMessageUseCase;
import com.usg.chat.domain.Chat;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatApiController {
    private final SendMessageUseCase sendMessageUseCase;
    private final GetMessageHistoryUseCase getMessageHistoryUseCase;

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

    @Operation(summary = "메시지 조회 *")
    @GetMapping("api/history")
    public ResponseEntity<Result<List<Chat>>> getMessageHistory(@RequestParam String senderId,
                                                        @RequestParam String receiverId){
        List<Chat> Messages = getMessageHistoryUseCase.getMessageHistory(senderId,receiverId);
        return ResponseEntity.ok(new Result(Messages));
    }
}
