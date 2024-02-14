package com.usg.chat.adapter.in.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MessageDTO {

    private String message;
    private String senderId;
    private String receiverId;
    private LocalDateTime timestamp;

    @Builder
    public MessageDTO (String message, String senderId, String receiverId, LocalDateTime timestamp){
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.timestamp = timestamp;
    }
}
