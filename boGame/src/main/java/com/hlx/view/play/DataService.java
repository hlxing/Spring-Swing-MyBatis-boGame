package com.hlx.view.play;

import com.hlx.config.PrizeEnum;
import com.hlx.model.Score;
import com.hlx.model.Setting;
import com.hlx.model.User;

import java.util.List;
import java.util.Map;

public interface DataService {

    void setDate(String result);

    Integer getCurrentUser();

    PrizeEnum getCurrentPrize();

    Setting getSetting();

    List<Score> getScoreList();

    Map<Integer, User> getUserMap();

    void initData(Setting setting);

    void attach(Observer observer);

    void remind();
}
