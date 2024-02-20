package com.usg.chat.application.port.in.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberWriteCommand {

    private String email;
    private String nickname;

    @Builder
    public MemberWriteCommand(String email, String nickname){
        this.email = email;
        this.nickname = nickname;
    }
}
