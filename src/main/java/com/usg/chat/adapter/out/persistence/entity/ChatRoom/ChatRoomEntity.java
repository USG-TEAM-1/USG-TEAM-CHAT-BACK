package com.usg.chat.adapter.out.persistence.entity.ChatRoom;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "chatroom")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomEntity {

    @Id @GeneratedValue
    @Column(name = "chat_room_id")
    private Long id;
    private String SenderAndReceiver;

    @Builder
    public ChatRoomEntity(String SenderAndReceiver) {
        this.SenderAndReceiver = SenderAndReceiver;
    }
}
