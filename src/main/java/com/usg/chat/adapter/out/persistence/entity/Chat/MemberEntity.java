package com.usg.chat.adapter.out.persistence.entity.Chat;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="Member")
@Getter
@NoArgsConstructor
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member-id")
    private Long id;

    private String email;

    @Builder
    public MemberEntity(String email){
        this.email = email;
    }
}
