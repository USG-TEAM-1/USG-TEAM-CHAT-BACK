package com.usg.chat.adapter.out.persistence;

import com.usg.chat.application.port.out.MemberPersistencePort;
import com.usg.chat.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements MemberPersistencePort {
    private final RedisTemplate<String, String> redisTemplate;
    private final String RedisKeyPrefix = "member : ";

    @Override
    public void saveMember(Member member) {
        redisTemplate.opsForValue().set(RedisKeyPrefix + member.getEmail(), member.getNickname());
    }

    @Override
    public String getNicknameByEmail(String email) {
        return redisTemplate.opsForValue().get(RedisKeyPrefix + email);
    }
}
