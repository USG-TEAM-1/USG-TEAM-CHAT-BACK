package com.usg.chat.application.port.in;

import com.usg.chat.domain.Chat;

public interface SendMessageUseCase {
    void sendMessage(Chat chat);
}