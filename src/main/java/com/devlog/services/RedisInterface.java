package com.devlog.services;

import com.devlog.models.Dev;

public interface RedisInterface {
    public void saveDev(Dev dev);

    public String getAccessToken(String devId);

    public void deleteDev(String devId);



}
