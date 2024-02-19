package com.usg.chat.application.service;

import com.usg.chat.application.port.in.ChatRoom.ChatRoomCommand;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomRepository;
import com.usg.chat.application.port.out.ChatRoomPersistencePort;
import com.usg.chat.domain.ChatRoom;
import com.usg.chat.util.SortedStringEditor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class ChatRoomService implements ChatRoomUseCase {
    private ChatRoomPersistencePort chatRoomPersistencePort;
    private ChatRoomRepository chatRoomRepository;
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

    // 채팅방 조회 서비스
    @Override
    public Long getIdBySenderAndReceiver(String senderAndReceiver) {
        return chatRoomRepository.getIdBySenderAndReceiver(senderAndReceiver);
    }

}
