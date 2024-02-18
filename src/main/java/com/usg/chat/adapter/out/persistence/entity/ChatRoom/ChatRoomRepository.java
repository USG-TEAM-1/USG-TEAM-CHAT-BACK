package com.usg.chat.adapter.out.persistence.entity.ChatRoom;

import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ChatRoomEntity c WHERE c.senderAndReceiver = :senderAndReceiver")
    boolean existsBySenderAndReceiver(@Param("senderAndReceiver") String senderAndReceiver);

    @Query("SELECT c.Id FROM ChatRoomEntity c WHERE c.senderAndReceiver = :senderAndReceiver")
    Long getIdBySenderAndReceiver(@Param("senderAndReceiver") String senderAndReceiver);

    @Query("SELECT c FROM ChatRoomEntity c WHERE c.senderAndReceiver = :senderAndReceiver")
    ChatRoomEntity findBySenderAndReceiver(@Param("senderAndReceiver") String senderAndReceiver);
}
