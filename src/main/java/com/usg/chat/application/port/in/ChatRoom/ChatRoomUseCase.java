package com.usg.chat.application.port.in.ChatRoom;

import com.usg.chat.domain.ChatRoom;

import java.util.List;

public interface ChatRoomUseCase {
    void createChatRoom(String senderAndReceiver);

    boolean existsBySenderAndReceiver(String senderAndReceiver);
    Long getIdBySenderAndReceiver(String senderAndReceiver);

}

