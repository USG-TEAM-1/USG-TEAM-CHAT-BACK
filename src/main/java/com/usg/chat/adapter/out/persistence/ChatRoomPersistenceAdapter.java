package com.usg.chat.adapter.out.persistence;

import com.usg.chat.adapter.out.api.util.SortedStringEditor;
import com.usg.chat.adapter.out.persistence.entity.Chat.ChatEntity;
import com.usg.chat.adapter.out.persistence.entity.Chat.ChatRepository;
import com.usg.chat.adapter.out.persistence.entity.Chat.MemberEntity;
import com.usg.chat.adapter.out.persistence.entity.Chat.MemberRepository;
import com.usg.chat.application.port.in.ChatRoom.ChatRoomUseCase;
import com.usg.chat.application.port.out.ChatRoomPersistencePort;
import com.usg.chat.domain.ChatRoom;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatRoomPersistenceAdapter implements ChatRoomPersistencePort {
    private final ChatRoomRepository chatRoomRepository;
    private final MemberRepository memberRepository;

    @Override
    public Long createChatRoom(ChatRoom chatRoom){
        ChatRoomEntity chatRoomEntity = ChatRoomEntity
                .builder()
                .build();

        ChatRoomEntity savedChatRoomEntity = chatRoomRepository.save(chatRoomEntity);
        return savedChatRoomEntity.getId();
    }

    @Override
    public ChatRoomEntity findBySenderAndReceiver(Long senderId, Long receiverId){
        MemberEntity findSender = memberRepository.findById(senderId).orElseThrow(
                () -> new IllegalArgumentException("사람을 찾을 수 없습니다.")
        );

        MemberEntity findReceiver = memberRepository.findById(receiverId).orElseThrow(
                () -> new IllegalArgumentException("사람을 찾을 수 없습니다.")
        );

        String senderAndReceiver = SortedStringEditor.createSortedString(findSender.getId(),findReceiver.getId());

        ChatRoomEntity findChatRoom = chatRoomRepository.findSenderAndReceiver(senderAndReceiver);

        return findChatRoom;
    }
}
