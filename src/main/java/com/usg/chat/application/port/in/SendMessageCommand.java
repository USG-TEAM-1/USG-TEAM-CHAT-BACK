package com.usg.chat.application.port.in;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class SendMessageCommand {

    private String message;
    private String senderId;
    private String receiverId;

    @Builder
    public SendMessageCommand(String message, String senderId, String receiverId){
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

}
