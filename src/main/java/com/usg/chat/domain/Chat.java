package com.usg.chat.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    private String message;     //메시지 내용
    private String senderId;   //보내는 자 아이디
    private String receiverId; //받는 자 아이디

    @Builder
    public Chat(String message, String senderId, String receiverId){
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

}
