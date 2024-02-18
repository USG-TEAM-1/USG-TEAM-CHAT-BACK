package com.usg.chat.adapter.in.web;

import com.usg.chat.adapter.in.web.dto.Result;
import com.usg.chat.application.port.in.Message.GetMessageHistoryUseCase;
import com.usg.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class GetMessageApiController {
    private final GetMessageHistoryUseCase getMessageHistoryUseCase;

    @GetMapping("/messages")
    public ResponseEntity<Result<List<Chat>>> getMessages(@RequestParam String senderId,
                                                          @RequestParam String receiverId){
        List<Chat> Messages = getMessageHistoryUseCase.getMessages(senderId,receiverId);
        return ResponseEntity.ok(new Result(Messages));
    }
}