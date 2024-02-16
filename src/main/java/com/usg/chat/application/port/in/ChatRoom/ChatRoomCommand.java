package com.usg.chat.application.port.in.ChatRoom;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomCommand {
    private Long senderId;
    private Long receiverId;

    @Builder
    public ChatRoomCommand(Long senderId, Long receiverId){
        this.senderId = senderId;
        this.receiverId = receiverId;
    }
}
