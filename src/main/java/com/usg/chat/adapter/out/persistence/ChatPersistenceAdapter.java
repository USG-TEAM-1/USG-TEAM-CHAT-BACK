package com.usg.chat.adapter.out.persistence;

import com.usg.chat.adapter.out.persistence.entity.ChatEntity;
import com.usg.chat.adapter.out.persistence.entity.ChatRepository;
import com.usg.chat.application.port.out.ChatPersistencePort;
import com.usg.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatPersistenceAdapter implements ChatPersistencePort{

    private final ChatRepository chatRepository;

    @Override
    public void saveChat(Chat chat){
        ChatEntity chatEntity = ChatEntity
                .builder()
                .message(chat.getMessage())
                .receiverId(chat.getReceiverId())
                .senderId(chat.getSenderId())
                .build();

        chatRepository.save(chatEntity);
    }

}
