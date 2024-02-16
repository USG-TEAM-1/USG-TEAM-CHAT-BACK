package com.usg.chat.adapter.out.persistence.entity.Chat;

import com.usg.chat.adapter.out.persistence.entity.ChatRoom.ChatRoomEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table (name = "chat")
@Getter
@NoArgsConstructor
public class ChatEntity {

    @Id @GeneratedValue
    @Column(name ="chat_id")
    private Long id;
    private String message;     //메시지 내용
    private String senderId;   //보내는 자 아이디
    private String receiverId; //받는 자 아이디
    private LocalDateTime timestamp; //시간

    @ManyToOne
    private ChatRoomEntity chatroom;

    @Builder
    public ChatEntity(String message, String senderId, String receiverId,
                      LocalDateTime timestamp/*, ChatRoomEntity chatroom*/){
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.timestamp = timestamp;
        //this.chatroom = chatroom;
    }

}
