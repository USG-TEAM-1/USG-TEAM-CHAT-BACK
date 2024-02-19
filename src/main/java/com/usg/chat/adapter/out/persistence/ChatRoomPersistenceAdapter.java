package com.usg.chat.adapter.out.persistence;

import com.usg.chat.adapter.in.web.dto.ChatRoomRes;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomRepository;
import com.usg.chat.application.port.in.ChatRoom.GetChatRoomsRes;
import com.usg.chat.domain.Chat;
import com.usg.chat.domain.ChatRoom;
import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.application.port.out.ChatRoomPersistencePort;
import com.usg.chat.util.SortedStringEditor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ChatRoomPersistenceAdapter implements ChatRoomPersistencePort {
    private final ChatRoomRepository chatRoomRepository;

    // 채팅방 생성 후 DB저장
    @Override
    public Long createChatRoom(ChatRoom chatRoom) {
        ChatRoomEntity chatRoomEntity = ChatRoomEntity.builder()
                .senderAndReceiver(chatRoom.getSenderAndReceiver())
                .build();

        ChatRoomEntity savedChatRoomId = chatRoomRepository.save(chatRoomEntity);
        return savedChatRoomId.getRoomId();
    }

    @Override
    public ChatRoomEntity findBySenderAndReceiver(Long senderId, Long receiverId){
        //멤버 찾는게 필요할듯?
        String senderAndReceiver = SortedStringEditor.createSortedString(senderId,receiverId);
        ChatRoomEntity findChatRoom = chatRoomRepository.findBySenderAndReceiver(senderAndReceiver);
        return findChatRoom;
    }

    // 채팅방 조회 메서드
    @Override
    public List<ChatRoomEntity> findChatRooms(Long memberId){
        return null;//chatRoomRepository.findChatRoomsByMemberId(memberId);
    }

    @Override
    public ChatRoomEntity findById(Long chatRoomId){
        return chatRoomRepository.findById(chatRoomId).orElseThrow(
                () -> new IllegalAccessError("채팅방을 찾을 수 없습니다.")
        );
    }
}
