package com.usg.chat.application.port.in.Chat;

import com.usg.chat.domain.Chat;

import java.util.List;

public interface GetMessageHistoryUseCase {
    List<Chat> getMessages(String senderEmail, String receiverEmail);
}
