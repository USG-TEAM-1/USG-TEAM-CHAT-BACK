package com.usg.chat.adapter.in.web;

import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomCommand;
import com.usg.chat.domain.ChatRoom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatRoomApiController {
    private final ChatRoomUseCase chatRoomUseCase;

    public ChatRoomApiController(ChatRoomUseCase chatRoomUseCase) {
        this.chatRoomUseCase = chatRoomUseCase;
    }

    @PostMapping("/chat-rooms")
    public ResponseEntity<String> createChatRoom(@RequestBody ChatRoomCommand command) {
        Long senderId = command.getSenderId();
        Long receiverId = command.getReceiverId();
        String senderAndReceiver = (senderId < receiverId) ? senderId + "_" + receiverId : receiverId + "_" + senderId;

        if(chatRoomUseCase.existsBySenderAndReceiver(senderAndReceiver)){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        chatRoomUseCase.createChatRoom(senderAndReceiver);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/chat-rooms/{senderAndReceiver}/id")
    public ResponseEntity<Long> getChatRoomId(@PathVariable String senderAndReceiver) {
        Long chatRoomId = chatRoomUseCase.getIdBySenderAndReceiver(senderAndReceiver);
        return ResponseEntity.ok(chatRoomId);
    }

}

