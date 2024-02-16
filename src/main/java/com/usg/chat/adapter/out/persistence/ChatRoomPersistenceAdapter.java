package com.usg.chat.adapter.out.persistence;

import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import com.usg.chat.domain.ChatRoom;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomRepository;
import org.springframework.stereotype.Component;

@Component
public class ChatRoomPersistenceAdapter implements ChatRoomUseCase {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomPersistenceAdapter(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public void createChatRoom(String senderAndReceiver) {

    }

    @Override
    public void createChatRoom(int senderId, int receiverId) {
        String senderAndReceiver;
        if(senderId < receiverId) {
            senderAndReceiver = senderId + "_" + receiverId;
        } else {
            senderAndReceiver = receiverId + "_" + senderId;
        }

        ChatRoom chatRoom = new ChatRoom(senderAndReceiver);
        ChatRoomEntity chatRoomEntity = new ChatRoomEntity();
        chatRoomEntity.setSenderAndReceiver(chatRoom.getSenderAndReceiver());
        chatRoomRepository.save(chatRoomEntity);
    }
}
