package com.usg.chat.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "chat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Column(name = "sender_id")
    private String senderId;          //보내는 사람 아이디 ManyToOne 되야함.

    @Column(name = "receiver_id")
    private String receiverId;        //받는사람 아이디 ManyToOne 되야함.
    //날짜 관련 변수값 추가해야함.

    @Builder
    public ChatEntity(String message, String senderId, String receiverId){
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }
}
