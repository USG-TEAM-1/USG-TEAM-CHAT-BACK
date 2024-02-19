package com.usg.chat.application.port.out;

import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.domain.ChatRoom;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomPersistencePort {
    // 채팅방 생성
    Long createChatRoom(ChatRoom chatRoom);

    ChatRoomEntity findBySenderAndReceiver(Long senderId, Long receiverId);
    // 채팅방 조회
    Long getIdBySenderAndReceiver(String senderAndReceiver);
}

