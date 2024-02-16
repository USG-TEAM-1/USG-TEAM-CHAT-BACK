package com.usg.chat.adapter.in.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MessageDTO {

    private String message;
    private Long senderId;
    private Long receiverId;
    private LocalDateTime timestamp;

    @Builder
    public MessageDTO (String message, Long senderId, Long receiverId, LocalDateTime timestamp){
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.timestamp = timestamp;
    }
}
