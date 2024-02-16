package com.usg.chat.application.service;

import com.usg.chat.adapter.out.persistence.entity.Chat.ChatEntity;
import com.usg.chat.application.port.in.Message.SaveChatCommand;
import com.usg.chat.application.port.in.Message.SaveChatUseCase;
import com.usg.chat.application.port.out.ChatPersistencePort;
import com.usg.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ChatService implements SaveChatUseCase {

    private final ChatPersistencePort chatPersistencePort;

    @Override
    @Transactional
    public Long saveMessage(SaveChatCommand command){
        ChatEntity chat = commandToChat(command);
        Long savedChatId = chatPersistencePort.saveMessage(chat);

        return savedChatId;
    }

    private ChatEntity commandToChat(SaveChatCommand command){
        return ChatEntity
                .builder()
                .message(command.getMessage())
                .receiverId(command.getReceiverId())
                .senderId(command.getSenderId())
                .timestamp(command.getTimestamp())
                .build();
    }
}
