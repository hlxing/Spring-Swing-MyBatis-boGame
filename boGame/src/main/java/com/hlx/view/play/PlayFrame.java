package com.hlx.view.play;

import com.hlx.config.PrizeEnum;
import com.hlx.model.BoDraw;
import com.hlx.model.Setting;
import com.hlx.model.User;
import com.hlx.service.BoDrawService;
import com.hlx.service.RouteService;
import com.hlx.service.SettingService;
import com.hlx.service.SoundService;
import com.hlx.view.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * The play page of bo game 
 * @author hlx
 * @version 1.0 2018-3-19
 */
@Component
public class PlayFrame extends RenewableFrame implements Observer{


    private BackgroundLabel backgroundLabel;

    private MainPanel mainPanel;

    private BroadcastPanel broadcastPanel;

    private RankPanel rankPanel;

    private PrizePanel prizePanel;

    private BoDrawService boDrawService;

    private RouteService routeService;

    private static final float TRANSPARENCY = (float) 0.42;

    private Setting setting;

    private DataService dataService;

    private SettingService settingService;

    private SoundService soundService;

    @Autowired
    public PlayFrame(RouteService routeService,BoDrawService boDrawService
            ,SettingService settingService,DataService dataService,SoundService soundService) {
        super(true);
        this.routeService = routeService;
        this.boDrawService = boDrawService;
        this.settingService = settingService;
        this.dataService = dataService;
        this.soundService = soundService;
        this.setSize(970, 530);
        routeService.addUrl("/play", this);
        initBackground();
        initMainPanel();
        // This line of code must be in the end,don't ask why
        dataService.attach(this);
    }

    public void refresh() {
        setting = settingService.get();
        dataService.initData(setting);
        broadcastPanel.clear();
        mainPanel.clear();
        rankPanel.clear();
        prizePanel.update();
    }

    private void initMainPanel() {
        //init the mainPanel
        mainPanel = new MainPanel(TRANSPARENCY,boDrawService,dataService,routeService,soundService);
        mainPanel.setLocation(35, 30);
        backgroundLabel.add(mainPanel);

        broadcastPanel = new BroadcastPanel(TRANSPARENCY,dataService);
        broadcastPanel.setLocation(35, 410);
        backgroundLabel.add(broadcastPanel);

        rankPanel = new RankPanel(TRANSPARENCY,dataService);
        rankPanel.setLocation(680, 30);
        backgroundLabel.add(rankPanel);

        prizePanel = new PrizePanel(TRANSPARENCY,settingService,dataService);
        prizePanel.setLocation(680, 285);
        backgroundLabel.add(prizePanel);

    }


    private void initBackground() {
        backgroundLabel = new BackgroundLabel("view/image/background/back4.jpg");
        this.add(backgroundLabel);
    }

    @Override
    public void update() {
        Setting setting = dataService.getSetting();
        if (setting.getNum() == 0 && setting.getNum2() == 0 && setting.getNum3() == 0
                && setting.getNum4() == 0 && setting.getNum5() == 0 && setting.getNum6() == 0) {
            Map<Integer,User> userMap = dataService.getUserMap();
            Long timeStamp = System.currentTimeMillis()/1000;
            for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
                User user = entry.getValue();
                String name = "" + entry.getKey();
                Map<PrizeEnum, Integer> prizeMap = user.getPrizeMap();
                for(Map.Entry<PrizeEnum,Integer> entry2 : prizeMap.entrySet()){
                    if(entry2.getValue()==null||entry2.getValue()==0)   continue;
                    if(entry2.getKey()==PrizeEnum.BLANK)    continue;
                    BoDraw boDraw = new BoDraw(name, entry2.getKey().getDesc()
                            , entry2.getValue(), timeStamp);
                    boDrawService.save(boDraw);
                }
            }
            routeService.redirect("/settlement");
        }
    }
}
