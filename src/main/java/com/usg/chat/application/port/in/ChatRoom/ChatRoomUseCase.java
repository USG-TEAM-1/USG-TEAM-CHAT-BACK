package com.usg.chat.application.port.in.ChatRoom;

public interface ChatRoomUseCase {
    void createChatRoom(String senderAndReceiver);

    void createChatRoom(int senderId, int receiverId);

}
