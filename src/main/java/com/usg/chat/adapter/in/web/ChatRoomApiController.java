package com.usg.chat.adapter.in.web;

import com.usg.chat.adapter.in.web.dto.ChatRoomReq;
import com.usg.chat.adapter.in.web.dto.ChatRoomRes;
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
//채팅방 생성 API
    @PostMapping("/chat-rooms")
    public ResponseEntity<String> createChatRoom(@RequestBody ChatRoomCommand command) {
        Long senderId = command.getSenderId();
        Long receiverId = command.getReceiverId();
        // 작은 숫자부터 앞으로 오게함
        String senderAndReceiver = (senderId < receiverId) ? senderId + "_" + receiverId : receiverId + "_" + senderId;

        if(chatRoomUseCase.existsBySenderAndReceiver(senderAndReceiver)){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        chatRoomUseCase.createChatRoom(senderAndReceiver);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //채팅방 조회 API
    @GetMapping("/chat-rooms/id/{senderAndReceiver}")
    public ResponseEntity<ChatRoomRes> getChatRoomId(@PathVariable("senderAndReceiver") String senderAndReceiver) {
        Long chatRoomId = chatRoomUseCase.getIdBySenderAndReceiver(senderAndReceiver);
        if (chatRoomId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ChatRoomRes chatRoomRes = new ChatRoomRes();
        chatRoomRes.setRoomId(chatRoomId);
        return ResponseEntity.ok(chatRoomRes);
    }


}

