package com.usg.chat.application.port.in.ChatRoom;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetChatRoomsRes {
    private Long chatRoomId;

    @Builder
    public GetChatRoomsRes(Long chatRoomId){
        this.chatRoomId = chatRoomId;
    }
}
