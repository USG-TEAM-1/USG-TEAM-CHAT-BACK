package com.usg.chat.adapter.in.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatRoomRes {

    private Long id;

    @Builder
    public ChatRoomRes(Long id){
        this.id = id;
    }
}
