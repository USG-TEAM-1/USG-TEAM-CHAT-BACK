package com.usg.chat.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom {

    private String senderAndReceiver;

    @Builder
    public ChatRoom(String senderAndReceiver){
        this.senderAndReceiver = senderAndReceiver;
    }

}
