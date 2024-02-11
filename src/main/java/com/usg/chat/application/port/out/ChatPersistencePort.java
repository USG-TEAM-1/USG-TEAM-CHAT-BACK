package com.usg.chat.application.port.out;

import com.usg.chat.domain.Chat;

public interface ChatPersistencePort {
    void saveChat(Chat chat);
}
