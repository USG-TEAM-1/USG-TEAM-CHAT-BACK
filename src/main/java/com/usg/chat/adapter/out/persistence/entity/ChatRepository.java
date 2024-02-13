package com.usg.chat.adapter.out.persistence.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatEntity, Long> {
    @Query("SELECT c FROM ChatEntity c WHERE " +
            "(c.senderId = :senderId AND c.receiverId = :receiverId) OR " +
            "(c.senderId = :receiverId AND c.receiverId = :senderId) ")     //시간 비교 추가해야함. ORDER BY c.createdAt DES
    List<ChatEntity> getMessageHistory(@Param("senderId") String senderId, @Param("receiverId") String receiverId);


}
