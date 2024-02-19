package com.usg.chat.adapter.in.web;

import com.usg.chat.adapter.in.web.dto.ChatRoomReq;
import com.usg.chat.adapter.in.web.dto.ChatRoomRes;
import com.usg.chat.adapter.in.web.dto.Result;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomRepository;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomCommand;
import com.usg.chat.util.SortedStringEditor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class ChatRoomApiController {
    private final ChatRoomUseCase chatRoomUseCase;
    private final ChatRoomRepository chatRoomRepository;

    //채팅방 생성 API
    @PostMapping("/chat-rooms")
    public ResponseEntity<Result> createChatRoom(@RequestBody ChatRoomReq request) {
        Long senderId = 1L;
        Long opponentId = request.getOpponentId();

        // 채팅방 인원 찾기
        String senderAndReceiver = SortedStringEditor.createSortedString(senderId, opponentId);
        ChatRoomEntity findChatRoom = chatRoomRepository.findBySenderAndReceiver(senderAndReceiver);

        // 채팅방이 없을 경우 생성
        if (findChatRoom == null) {
            ChatRoomCommand command = ChatRoomCommand.builder()
                    .senderId(senderId)
                    .receiverId(opponentId)
                    .build();
            chatRoomUseCase.createChatRoom(command);
            findChatRoom = chatRoomRepository.findBySenderAndReceiver(senderAndReceiver);
        }

        // 채팅방이 있을 경우 응답 생성
        ChatRoomRes response = ChatRoomRes.builder()
                .chatRoomId(findChatRoom.getRoomId())
                .build();

        return ResponseEntity.ok(new Result(response, "채팅방을 생성하였습니다."));
    }


    //채팅방 조회 API
    @GetMapping("/chat-rooms/id/{senderAndReceiver}")
    public ResponseEntity<ChatRoomRes> getChatRoomId(@PathVariable("senderAndReceiver") String senderAndReceiver) {
        Long chatRoomId = chatRoomUseCase.getIdBySenderAndReceiver(senderAndReceiver);
        if (chatRoomId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ChatRoomRes chatRoomRes = new ChatRoomRes();
        chatRoomRes.setChatRoomId(chatRoomId);
        return ResponseEntity.ok(chatRoomRes);
    }
}

