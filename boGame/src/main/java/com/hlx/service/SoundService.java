package com.hlx.service;

import com.hlx.config.SoundEnum;

public interface SoundService {

    void play(SoundEnum sound);

    void stop(SoundEnum sound);

}
