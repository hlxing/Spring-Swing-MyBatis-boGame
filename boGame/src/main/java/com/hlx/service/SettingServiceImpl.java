package com.hlx.service;

import com.hlx.dao.SettingDao;
import com.hlx.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service can save and get the option of bo game
 * @author hlx
 * @version 1.0 2018-3-18
 */
@Service
public class SettingServiceImpl implements SettingService {

    private SettingDao optionDao;

    @Autowired
    public SettingServiceImpl(SettingDao optionDao) {
        this.optionDao = optionDao;
    }

    public void save(Setting option) {
        optionDao.save(option);
    }

    public Setting get() {
        return optionDao.get();
    }
}
