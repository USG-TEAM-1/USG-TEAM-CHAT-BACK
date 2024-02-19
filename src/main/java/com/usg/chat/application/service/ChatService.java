package com.usg.chat.application.service;

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
public class ChatService implements SaveChatUseCase  {

    private final ChatPersistencePort chatPersistencePort;

    @Override
    @Transactional
    public Long saveMessage(SaveChatCommand command){
        Chat chat = commandToChat(command);
        Long savedChatId = chatPersistencePort.saveMessage(chat);

        return savedChatId;
    }

    private Chat commandToChat(SaveChatCommand command){
        return Chat
                .builder()
                .message(command.getMessage())
                .receiverId(command.getReceiverId())
                .senderId(command.getSenderId())
                .timestamp(command.getTimestamp())
                .chatRoomId(command.getChatRoomId())
                .build();
    }
}
