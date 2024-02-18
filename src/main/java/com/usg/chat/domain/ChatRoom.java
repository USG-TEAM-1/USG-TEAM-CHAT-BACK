package com.usg.chat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoom {
    private String senderAndReceiver;

    public ChatRoom(String senderAndReceiver) {
        this.senderAndReceiver = senderAndReceiver;
    }
    // senderAndReceiver 필드값 설정
    public void setSenderAndReceiver(Long senderId, Long receiverId) {
        this.senderAndReceiver = senderId + "_" + receiverId;
    }

}

