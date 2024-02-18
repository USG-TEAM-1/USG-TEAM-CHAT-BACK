package com.usg.chat.application.port.out;

import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomPersistencePort {

    void createChatRoom(Long senderId, Long receiverId);
    boolean existsBySenderAndReceiver(String senderAndReceiver);
    Long getIdBySenderAndReceiver(String senderAndReceiver);
}

