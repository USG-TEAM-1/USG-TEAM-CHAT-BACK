package com.usg.chat.application.service;

import com.usg.chat.adapter.out.api.util.SortedStringEditor;
import com.usg.chat.adapter.out.persistence.entity.Chat.MemberEntity;
import com.usg.chat.adapter.out.persistence.entity.Chat.MemberRepository;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomCommand;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomRepository;
import com.usg.chat.application.port.in.Message.SaveChatCommand;
import com.usg.chat.application.port.out.ChatRoomPersistencePort;
import com.usg.chat.domain.Chat;
import com.usg.chat.domain.ChatRoom;
import com.usg.chat.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ChatRoomService implements ChatRoomUseCase {
    private final ChatRoomPersistencePort chatRoomPersistencePort;
    private final ChatRoomRepository chatRoomRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long createChatRoom(ChatRoomCommand command) {

        ChatRoom chatroom = commandToChatRoom(command);
        Long savedChatRoomId = chatRoomPersistencePort.createChatRoom(chatroom);

        return savedChatRoomId;
    }
    private ChatRoom commandToChatRoom(ChatRoomCommand command){
        //id 정렬하는것.
        String senderAndReceiver = SortedStringEditor.createSortedString(command.getSenderId(), command.getReceiverId());
        return ChatRoom
                .builder()
                .senderAndReceiver(senderAndReceiver)
                .build();
    }

    @Override
    @Transactional
    public ChatRoomEntity findBySenderAndReceiver(Long senderId, Long receiverId){

        ChatRoomEntity findChatRoom = chatRoomPersistencePort.findBySenderAndReceiver(senderId, receiverId);

        return findChatRoom;
    }


}
