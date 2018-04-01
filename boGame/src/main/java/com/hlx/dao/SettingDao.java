package com.hlx.dao;

import com.hlx.model.Setting;

public interface SettingDao {

    void save(Setting option);

    Setting get();
}
