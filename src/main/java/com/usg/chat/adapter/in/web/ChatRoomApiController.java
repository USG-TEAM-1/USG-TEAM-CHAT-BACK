package com.usg.chat.adapter.in.web;

import com.usg.chat.adapter.in.web.dto.ChatRoomReq;
import com.usg.chat.adapter.in.web.dto.ChatRoomRes;
import com.usg.chat.adapter.in.web.dto.Result;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomRepository;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomCommand;
import com.usg.chat.application.port.in.ChatRoom.GetChatRoomsRes;
import com.usg.chat.application.port.in.ChatRoom.GetChatRoomsUseCase;
import com.usg.chat.util.SortedStringEditor;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class ChatRoomApiController {
    private final ChatRoomUseCase chatRoomUseCase;
    private final ChatRoomRepository chatRoomRepository;
    private final GetChatRoomsUseCase getChatRoomsUseCase;

    //채팅방 생성 API
    @PostMapping("/chat-rooms")
    public ResponseEntity<Result> createChatRoom(@RequestBody ChatRoomReq request) {
        Long loginId = 1L;
        Long opponentId = request.getOpponentId();

        // 채팅방 인원 찾기
        String senderAndReceiver = SortedStringEditor.createSortedString(loginId, opponentId);
        ChatRoomEntity findChatRoom = chatRoomRepository.findBySenderAndReceiver(senderAndReceiver);

        // 채팅방이 없을 경우 생성
        if (findChatRoom == null) {
            ChatRoomCommand command = ChatRoomCommand.builder()
                    .senderId(loginId)
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
    @GetMapping("/api/chat-rooms/")
    @Operation(summary = "채팅방 목록 조회 *")
    public ResponseEntity<Result<List<ChatRoomEntity>>> getchatRooms(@RequestBody Long memberId) {
        List<GetChatRoomsRes> chatRooms = getChatRoomsUseCase.findChatRooms(memberId);
        //리스트 형식으로 뽑아와야 할것 같음.
        return ResponseEntity.ok(new Result(chatRooms,"채팅방 목록을 찾았습니다."));
    }
}

