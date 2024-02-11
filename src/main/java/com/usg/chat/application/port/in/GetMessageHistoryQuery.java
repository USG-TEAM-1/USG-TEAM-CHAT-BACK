package com.usg.chat.application.port.in;

import com.usg.chat.application.port.out.ChatPersistencePort;
import com.usg.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMessageHistoryQuery implements GetMessageHistoryUseCase{
    private final ChatPersistencePort chatPersistencePort;

    @Override
    public List<Chat> getMessageHistory(String senderId, String receiverId){
        return chatPersistencePort.getMessageHistory(senderId,receiverId);
    }
}
