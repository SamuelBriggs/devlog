package com.devlog.services.Cache;

import com.devlog.models.Dev;
import com.devlog.services.RedisInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class RedisService implements RedisInterface {

    @Autowired
    private final RedisTemplate<String, Object> redisTemplate;
    @Override
    public void saveDev(Dev dev) {
        String key = dev.getGitId();
        Map<String, Object> map = new HashMap<>();
        map.put("access_token", dev.getAccessToken());
        map.put("refresh_token", dev.getRefreshToken());
       redisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public String getAccessToken(String devId) {
      return  (String) redisTemplate.opsForHash().get(devId, "fullName");
    }

    @Override
    public void deleteDev(String devId) {

    }
}
