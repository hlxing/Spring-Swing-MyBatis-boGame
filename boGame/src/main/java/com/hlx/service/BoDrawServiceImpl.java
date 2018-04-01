package com.hlx.service;

import com.hlx.dao.BoDrawDao;
import com.hlx.model.BoDraw;
import com.hlx.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The service can draw and save the record
 * @author hlx
 * @version 1.0 2018-3-16
 */
@Service
public class BoDrawServiceImpl implements BoDrawService {

    private BoDrawDao boDrawDao;

    @Autowired
    public BoDrawServiceImpl(BoDrawDao boDrawDao) {
        this.boDrawDao = boDrawDao;
    }

    /**
     *
     * @return the result of luck draw
     */
    public String draw() {
        return RandomUtil.buildRandomStr(6);
    }

    public void save(BoDraw boDraw) {
        boDrawDao.save(boDraw);
    }

    public List<BoDraw> get() {
        return boDrawDao.get();
    }

    public void delete() {
        boDrawDao.delete();
    }
}
