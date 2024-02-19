package com.usg.chat.adapter.in.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatRoomRes {
    private Long chatRoomId;

    @Builder
    public ChatRoomRes(Long chatRoomId){
     this.chatRoomId= chatRoomId;
    }
}
