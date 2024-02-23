package com.usg.chat.application.service;

import com.usg.chat.application.port.in.Chat.GetMessageHistoryUseCase;
import com.usg.chat.application.port.out.ChatPersistencePort;
import com.usg.chat.application.port.out.MemberPersistencePort;
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
    private final MemberPersistencePort memberPersistencePort;
    @Override
    @Transactional
    public List<Chat> getMessages(String senderEmail, String receiverEmail){
        Long senderId = memberPersistencePort.getIdByEmail(senderEmail);
        Long receiverId = memberPersistencePort.getIdByEmail(receiverEmail);
        return chatPersistencePort.getMessages(senderId, receiverId);
    }
}
