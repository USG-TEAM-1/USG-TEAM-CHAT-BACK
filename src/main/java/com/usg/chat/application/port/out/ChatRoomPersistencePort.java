package com.usg.chat.application.port.out;

import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomPersistencePort {
    // 채팅방 생성
    void createChatRoom(Long senderId, Long receiverId);
    // 중복제거
    boolean existsBySenderAndReceiver(String senderAndReceiver);
    // 채팅방 조회
    Long getIdBySenderAndReceiver(String senderAndReceiver);
}

