package com.usg.chat.application.service;

import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Primary
@Service
public class ChatRoomService implements ChatRoomUseCase {
    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public void createChatRoom(String senderAndReceiver) {
        ChatRoomEntity chatRoom = new ChatRoomEntity();
        chatRoom.setSenderAndReceiver(senderAndReceiver);
        chatRoomRepository.save(chatRoom);
    }


    @Override
    public boolean existsBySenderAndReceiver(String senderAndReceiver) {
        return chatRoomRepository.existsBySenderAndReceiver(senderAndReceiver);
    }

    @Override
    public Long getIdBySenderAndReceiver(String senderAndReceiver) {
        return chatRoomRepository.getIdBySenderAndReceiver(senderAndReceiver);
    }

}
