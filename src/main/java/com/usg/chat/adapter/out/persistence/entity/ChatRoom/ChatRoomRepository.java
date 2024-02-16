package com.usg.chat.adapter.out.persistence.entity.ChatRoom;

import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {
}
