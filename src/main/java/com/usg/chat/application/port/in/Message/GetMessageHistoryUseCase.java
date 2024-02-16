package com.usg.chat.application.port.in.Message;

import com.usg.chat.domain.Chat;

import java.util.List;

public interface GetMessageHistoryUseCase {
    List<Chat> getMessages(Long senderId, Long receiverId);
}
