package com.usg.chat.application.port.out;

import com.usg.chat.domain.Chat;

import java.util.List;

public interface ChatPersistencePort {
    void sendMessage(Chat chat);
    List<Chat> getMessageHistory(String senderId, String receiverId);
}
