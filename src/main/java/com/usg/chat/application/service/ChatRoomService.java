package com.usg.chat.application.service;

import com.usg.chat.application.port.in.ChatRoom.ChatRoomCommand;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import com.usg.chat.application.port.in.ChatRoom.GetChatRoomsRes;
import com.usg.chat.application.port.in.ChatRoom.GetChatRoomsUseCase;
import com.usg.chat.application.port.out.ChatRoomPersistencePort;
import com.usg.chat.domain.ChatRoom;
import com.usg.chat.util.SortedStringEditor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class ChatRoomService implements ChatRoomUseCase , GetChatRoomsUseCase {
    private ChatRoomPersistencePort chatRoomPersistencePort;

    // 채팅방 생성 서비스
    @Override
    @Transactional
    public Long createChatRoom(ChatRoomCommand command) {
        ChatRoom chat = commandToChatRoom(command);
        Long savedChatRoomId = chatRoomPersistencePort.createChatRoom(chat);

        return savedChatRoomId;
    }
    private ChatRoom commandToChatRoom(ChatRoomCommand command){
        return ChatRoom.builder()
                .senderAndReceiver(SortedStringEditor.createSortedString(command.getSenderId(), command.getReceiverId()))
                .build();
    }

    @Override
    public List<GetChatRoomsRes> findChatRooms(Long memberId){
        List<ChatRoom> chatRooms = chatRoomPersistencePort.findChatRooms(memberId);
        return chatRooms.stream()
                .map(chatRoom -> GetChatRoomsRes.builder()
                        .chatRoomId(chatRoom.getChatRoomId()) // ChatRoom 객체에서 ID만 가져와서 설정
                        .build())
                .collect(Collectors.toList());
    }

}
