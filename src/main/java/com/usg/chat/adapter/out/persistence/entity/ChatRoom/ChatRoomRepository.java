package com.usg.chat.adapter.out.persistence.entity.ChatRoom;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {

    @Query(value = "select cr from ChatRoomEntity cr" +
            " where cr.senderAndReceiver = :senderAndReceiver")
    ChatRoomEntity findSenderAndReceiver(@Param("senderAndReceiver") String senderAndReceiver);
}
