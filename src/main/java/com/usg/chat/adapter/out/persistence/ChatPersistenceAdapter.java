package com.usg.chat.adapter.out.persistence;

import com.usg.chat.adapter.in.web.dto.Result;
import com.usg.chat.adapter.out.persistence.entity.ChatEntity;
import com.usg.chat.adapter.out.persistence.entity.ChatRepository;
import com.usg.chat.application.port.out.ChatPersistencePort;
import com.usg.chat.domain.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChatPersistenceAdapter implements ChatPersistencePort{

    private final ChatRepository chatRepository;
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public void sendMessage(Chat chat){
        ChatEntity chatEntity = ChatEntity
                .builder()
                .message(chat.getMessage())
                .receiverId(chat.getReceiverId())
                .senderId(chat.getSenderId())
                .build();

        chatRepository.save(chatEntity);
        //웹 소켓을 통한 실시간으로 메시지 전송
        messagingTemplate.convertAndSendToUser(
                chat.getReceiverId(),
                "/queue/messages",
                new Result(chat.getMessage(), "메시지 전송 완료.")
        );
    }

    @Override
    public List<Chat> getMessageHistory(String senderId, String receiverId) {
        List<ChatEntity> chatEntities = chatRepository.getMessageHistory(senderId, receiverId);
        return chatEntities.stream().map(entity -> Chat.builder()
                .message(entity.getMessage())
                .senderId(entity.getSenderId())
                .receiverId(entity.getReceiverId())
                .build()).collect(Collectors.toList());
    }
}
