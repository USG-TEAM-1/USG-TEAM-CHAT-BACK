package com.usg.chat.application.port.in.Message;

import com.usg.chat.domain.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SaveChatCommand {
    private Long senderId;
    private Long receiverId;
    private String message;
    private LocalDateTime timestamp;
    private ChatRoom chatroom;

    @Builder
    public SaveChatCommand(String message, Long senderId, Long receiverId, LocalDateTime timestamp, ChatRoom chatroom){
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.timestamp = timestamp;
        this.chatroom = chatroom;
    }

}
