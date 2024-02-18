package com.usg.chat.adapter.out.persistence;

import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomRepository;
import com.usg.chat.domain.ChatRoom;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.application.port.out.ChatRoomPersistencePort;
import org.springframework.stereotype.Component;

@Component
public class ChatRoomPersistenceAdapter implements ChatRoomPersistencePort {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomPersistenceAdapter(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }
// 채팅방 생성 후 DB저장
    @Override
    public void createChatRoom(Long senderId, Long receiverId) {
        String senderAndReceiver = (senderId < receiverId) ? senderId + "_" + receiverId : receiverId + "_" + senderId;

        if(chatRoomRepository.existsBySenderAndReceiver(senderAndReceiver)) {
            return;
        }

        ChatRoom chatRoom = new ChatRoom(senderAndReceiver);
        ChatRoomEntity chatRoomEntity = new ChatRoomEntity();
        chatRoomEntity.setSenderAndReceiver(chatRoom.getSenderAndReceiver());
        chatRoomRepository.save(chatRoomEntity);
    }

    // 중복제거 메서드
    @Override
    public boolean existsBySenderAndReceiver(String senderAndReceiver) {
        return chatRoomRepository.existsBySenderAndReceiver(senderAndReceiver);
    }
// 채팅방 조회 메서드
    @Override
    public Long getIdBySenderAndReceiver(String senderAndReceiver) {
        ChatRoomEntity chatRoomEntity = chatRoomRepository.findBySenderAndReceiver(senderAndReceiver);
        if (chatRoomEntity == null) {
            return null;
        }
        return chatRoomEntity.getRoomId();
    }
}
