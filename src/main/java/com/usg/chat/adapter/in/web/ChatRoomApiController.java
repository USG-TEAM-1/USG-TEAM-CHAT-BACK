package com.usg.chat.adapter.in.web;

import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomApiController {
    private final ChatRoomUseCase chatRoomUseCase;

    public ChatRoomApiController(ChatRoomUseCase chatRoomUseCase) {
        this.chatRoomUseCase = chatRoomUseCase;
    }

    @PostMapping("/chat-rooms")
    public ResponseEntity<String> createChatRoom(@RequestBody ChatRoomCommand command) {
        int senderId = command.getSenderId();
        int receiverId = command.getReceiverId();
        String senderAndReceiver = (senderId < receiverId) ? senderId + "_" + receiverId : receiverId + "_" + senderId;

        chatRoomUseCase.createChatRoom(senderAndReceiver);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
