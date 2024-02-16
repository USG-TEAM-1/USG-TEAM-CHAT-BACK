package com.usg.chat.adapter.in.web;

import com.usg.chat.adapter.in.web.dto.ChatRoomReq;
import com.usg.chat.adapter.in.web.dto.ChatRoomRes;
import com.usg.chat.adapter.in.web.dto.Result;
import com.usg.chat.adapter.out.persistence.entity.Chat.MemberEntity;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomCommand;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ChatRoomApiController {

    private final ChatRoomUseCase chatRoomUseCase;
    //채팅방 생성.
    @PostMapping("/chat-rooms")
    @Operation(summary = "채팅방 생성 *")
    public ResponseEntity<Result> createChatRoom(@RequestBody ChatRoomReq req) {
        // JWT에서 이메일 가져오기
        //String email = memberEmailGetter.getMemberEmail(servletRequest.getHeader("Authorization"));

        // ChatRoomCommand 생성
        ChatRoomCommand chatRoomCommand = ChatRoomCommand.builder()
                .senderId(1L) // 고정된 senderId 사용
                .receiverId(req.getReceiverId())
                .build();

        // 채팅방 조회
        ChatRoomEntity findChatRoom = chatRoomUseCase.findBySenderAndReceiver(1L, req.getReceiverId());

        // 채팅방이 없으면 생성
        if (findChatRoom == null) {
            chatRoomUseCase.createChatRoom(chatRoomCommand);
            findChatRoom = chatRoomUseCase.findBySenderAndReceiver(1L, req.getReceiverId());
        }

        // 채팅방 응답 생성
        ChatRoomRes chatRoomRes = ChatRoomRes.builder()
                .id(findChatRoom.getId())
                .build();

        return ResponseEntity.ok(new Result(chatRoomRes));
    }

    //채팅방 목록 조회
    @GetMapping("/chat-rooms")
    public ResponseEntity<Result> GetChatRoom(){
        return ResponseEntity.status(HttpStatus.CREATED).build();   //임의로 설정.
    }
}
