package com.usg.chat.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    private String message;     //메시지 내용
    private String senderId;   //보내는 자 아이디
    private String receiverId; //받는 자 아이디
    private LocalDateTime timestamp; //시간

    //private Long chatroom;  //채팅방

    @Builder
    public Chat(String message, String senderId, String receiverId, LocalDateTime timestamp/*채팅방 넣는거 추가*/){
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.timestamp = timestamp;
        //this.chatroom = chatroom;
    }
}
