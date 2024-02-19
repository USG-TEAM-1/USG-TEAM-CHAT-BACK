package com.usg.chat.adapter.out.persistence.entity.ChatRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {

    @Query("SELECT c FROM ChatRoomEntity c WHERE c.senderAndReceiver = :senderAndReceiver")
    ChatRoomEntity findBySenderAndReceiver(@Param("senderAndReceiver") String senderAndReceiver);

    //List<ChatRoomEntity> findChatRoomsByMemberId(Long memberId);
}
