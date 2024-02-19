package com.usg.chat;

import com.usg.chat.adapter.out.persistence.entity.Chat.MemberEntity;
import com.usg.chat.adapter.out.persistence.entity.Chat.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB {

    @Bean
    CommandLineRunner initDatabase(MemberRepository memberRepository) {
        return args -> {
            memberRepository.save(new MemberEntity("전송자"));
            memberRepository.save(new MemberEntity("수신자."));
        };
    }
}

