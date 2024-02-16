package com.usg.chat.application.port.out;

import com.usg.chat.domain.Chat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRoomPersistencePort {
    List<Chat> getAllChats();
    Chat getChatById(String chatId);
    void saveChat(Chat chat);
    void deleteChat(String chatId);
}
