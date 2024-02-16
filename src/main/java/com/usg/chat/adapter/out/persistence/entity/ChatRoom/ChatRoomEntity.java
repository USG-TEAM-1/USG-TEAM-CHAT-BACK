package com.usg.chat.adapter.out.persistence.entity.ChatRoom;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ChatRoomEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChatRoom_id")
    private Long id;
    private String senderAndReceiver;

    @Builder
    public ChatRoomEntity(String senderAndReceiver){
        this.senderAndReceiver = senderAndReceiver;
    }
}