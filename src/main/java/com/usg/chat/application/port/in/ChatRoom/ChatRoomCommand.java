package com.usg.chat.application.port.in.ChatRoom;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomCommand {
    private long senderId;
    private long receiverId;

    public ChatRoomCommand(Long senderId, Long receiverId) {
        this.senderId = senderId;
        this.receiverId = receiverId;
    }
}
