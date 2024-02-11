package com.usg.chat.adapter.in.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageResponse {

    private Long chatroomId;

    @Builder
    public MessageResponse(Long chatroomId){
        this.chatroomId = chatroomId;
    }
}
