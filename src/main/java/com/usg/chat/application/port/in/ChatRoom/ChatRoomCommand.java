package com.usg.chat.application.port.in.ChatRoom;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomCommand {
    private int senderId;
    private int receiverId;

    public ChatRoomCommand(int senderId, int receiverId) {
        this.senderId = senderId;
        this.receiverId = receiverId;
    }
}
