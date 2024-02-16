package com.usg.chat.application.port.out;

import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.domain.ChatRoom;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomPersistencePort {
    Long createChatRoom(ChatRoom chatRoom);
    ChatRoomEntity findBySenderAndReceiver(Long senderId, Long receiverId);
}
