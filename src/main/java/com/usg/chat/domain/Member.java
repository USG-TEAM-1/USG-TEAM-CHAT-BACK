package com.usg.chat.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Member {
    private String email;

    @Builder
    public Member(String email){
        this.email = email;
    }
}
