package com.usg.chat.adapter.out.persistence;

import com.usg.chat.adapter.out.persistence.entity.Chat.ChatEntity;
import com.usg.chat.adapter.out.persistence.entity.Chat.ChatRepository;
import com.usg.chat.application.port.out.ChatPersistencePort;
import com.usg.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChatPersistenceAdapter implements ChatPersistencePort {

    private final ChatRepository chatRepository;

    @Override
    public Long saveMessage(Chat chat){
        ChatEntity chatEntity = ChatEntity
                .builder()
                .message(chat.getMessage())
                .senderId(chat.getSenderId())
                .receiverId(chat.getReceiverId())
                //.chatroom()
                .timestamp(chat.getTimestamp())
                .build();

        ChatEntity savedChatEntity = chatRepository.save(chatEntity);

        return savedChatEntity.getId();
    }

    @Override
    public List<Chat> getMessages(String senderId, String receiverId) {
        List<ChatEntity> chatEntities = chatRepository.getMessages(senderId,receiverId);
        return chatEntities.stream().map(entity -> Chat.builder()
                .message(entity.getMessage())
                .senderId(entity.getSenderId())
                .receiverId(entity.getReceiverId())
                .timestamp(entity.getTimestamp())
                .build()).collect(Collectors.toList());
    }
}
