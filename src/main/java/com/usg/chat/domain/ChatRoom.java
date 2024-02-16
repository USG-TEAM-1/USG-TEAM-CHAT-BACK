package com.usg.chat.domain;

import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoom{
    private String senderAndReceiver;

    @Builder
    public ChatRoom(String senderAndReceiver) {
        this.senderAndReceiver = senderAndReceiver;
    }

}
