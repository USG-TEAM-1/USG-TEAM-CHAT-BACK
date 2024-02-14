package com.usg.chat.application.port.in.Message;

public interface SaveChatUseCase {
    Long saveMessage(SaveChatCommand command);
}
