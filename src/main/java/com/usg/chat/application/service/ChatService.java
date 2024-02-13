package com.usg.chat.application.service;

import com.usg.chat.application.port.in.SendMessageCommand;
import com.usg.chat.application.port.in.SendMessageUseCase;
import com.usg.chat.application.port.out.ChatPersistencePort;
import com.usg.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatService implements SendMessageUseCase{

    private final ChatPersistencePort chatPersistencePort;

    @Override
    @Transactional
    public void sendMessage(Chat chat){
        chatPersistencePort.sendMessage(chat);
        log.info("Message sent: {}", chat);
    }
}
