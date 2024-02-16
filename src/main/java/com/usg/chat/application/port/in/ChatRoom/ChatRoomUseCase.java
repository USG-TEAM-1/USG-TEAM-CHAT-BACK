package com.usg.chat.application.port.in.ChatRoom;

import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import com.usg.chat.domain.ChatRoom;

public interface ChatRoomUseCase {
    Long createChatRoom(ChatRoomCommand command);

    ChatRoomEntity findBySenderAndReceiver(Long senderId, Long receiverId);
}
