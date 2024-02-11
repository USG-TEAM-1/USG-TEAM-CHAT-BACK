package com.usg.chat.application.port.in;

import com.usg.chat.domain.Chat;

import java.util.List;

public interface GetMessageHistoryUseCase {
    List<Chat> getMessageHistory(String senderId, String receiverId);
}
