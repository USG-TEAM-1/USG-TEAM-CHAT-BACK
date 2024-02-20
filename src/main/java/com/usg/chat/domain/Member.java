package com.usg.chat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Member {

    private String email;
    private String nickname;

    @Builder
    public Member(String email, String nickname){
        this.email = email;
        this.nickname = nickname;
    }
}
