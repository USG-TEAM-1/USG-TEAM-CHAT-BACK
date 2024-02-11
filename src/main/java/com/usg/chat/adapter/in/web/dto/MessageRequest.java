package com.usg.chat.adapter.in.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageRequest {

    private String message;
    private String senderId;
    private String receiverId;

    @Builder
    public MessageRequest(String message, String senderId, String receiverId){
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

}
