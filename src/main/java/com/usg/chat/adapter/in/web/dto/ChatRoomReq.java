package com.usg.chat.adapter.in.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatRoomReq {
    private Long senderId;
    private Long ReceiverId;

}
