package com.usg.chat.application.service;

import com.usg.chat.application.port.in.Message.GetMessageHistoryUseCase;
import com.usg.chat.application.port.out.ChatPersistencePort;
import com.usg.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class GetMessageService implements GetMessageHistoryUseCase {
    private final ChatPersistencePort chatPersistencePort;

    @Override
    @Transactional
    public List<Chat> getMessages(String senderId, String receiverId){

        return chatPersistencePort.getMessages(senderId, receiverId);
    }
}
