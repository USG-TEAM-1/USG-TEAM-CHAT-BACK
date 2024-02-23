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
        String key = RedisKeyPrefix + member.getEmail();
        String value = member.getMemberId() + ":" + member.getNickname();
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String getNicknameByEmail(String email) {
        String key = RedisKeyPrefix + email;
        String value = redisTemplate.opsForValue().get(key);
        if (value != null) {
            return value.split(":")[1];
        }
        return null;
    }

    @Override
    public Long getIdByEmail(String email) {
        String key = RedisKeyPrefix + email;
        String value = redisTemplate.opsForValue().get(key);
        if (value != null) {
            return Long.parseLong(value.split(":")[0]);
        }
        return null;
    }

}
