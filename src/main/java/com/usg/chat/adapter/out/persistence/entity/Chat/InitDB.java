package com.usg.chat.adapter.out.persistence.entity.Chat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB {

    @Bean
    CommandLineRunner initDatabase(MemberRepository memberRepository) {
        return args -> {
            memberRepository.save(new MemberEntity("user1"));
            memberRepository.save(new MemberEntity("user2"));
        };
    }
}

