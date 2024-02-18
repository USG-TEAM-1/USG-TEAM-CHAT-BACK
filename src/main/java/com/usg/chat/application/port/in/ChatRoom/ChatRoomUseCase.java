package com.usg.chat.application.port.in.ChatRoom;

import com.usg.chat.domain.ChatRoom;

import java.util.List;

public interface ChatRoomUseCase {
    // 채팅방 생성
    void createChatRoom(String senderAndReceiver);
    // 중복제거
    boolean existsBySenderAndReceiver(String senderAndReceiver);
    // 채팅방 조회
    Long getIdBySenderAndReceiver(String senderAndReceiver);

}

