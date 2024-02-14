package com.usg.chat.application.port.out;


import com.usg.chat.domain.Chat;

import java.util.List;

public interface ChatPersistencePort {
    Long saveMessage(Chat chat);
    List<Chat> getMessages(String senderId, String receiverId);
}
