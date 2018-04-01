package com.hlx.view.play;

import com.hlx.model.Setting;
import com.hlx.service.SettingService;
import com.hlx.view.common.PositionUtil;
import com.hlx.view.common.TipLabel;
import com.hlx.view.common.TranslucentPanel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The concrete prize view of play frame
 * @author hlx
 * @version 1.0 2018-3-20
 */
public class PrizePanel extends TranslucentPanel implements Observer{

    private DataService dataService;

    private SettingService settingService;

    private List<PrizeLabel> prizeLabelList;

    public PrizePanel(float transparency, SettingService settingService, DataService dataService) {
        super();
        this.setTransparency(transparency);
        this.setSize(260, 220);
        this.dataService = dataService;
        this.settingService = settingService;
        dataService.attach(this);
        initTitleLabel();
        initPrizeLabel();
    }

    private void initPrizeLabel() {
        Setting setting = settingService.get();
        prizeLabelList = new ArrayList<>(Arrays.asList(
                new PrizeLabel("一秀: ", setting.select(0), 20),
                new PrizeLabel("二举: ", setting.select(1), 20),
                new PrizeLabel("四进: ", setting.select(2), 20),
                new PrizeLabel("三红: ", setting.select(3), 20),
                new PrizeLabel("对堂: ", setting.select(4), 20),
                new PrizeLabel("状元: ", setting.select(5), 20)
        ));
        for(int i=0,y=70;i<3;i++) {
            PrizeLabel prizeLabel = prizeLabelList.get(i);
            prizeLabel.setBounds(40, y, 100, 25);
            this.add(prizeLabel);
            y = y + 40;
        }
        for(int i=3,y=70;i<6;i++) {
            PrizeLabel prizeLabel = prizeLabelList.get(i);
            prizeLabel.setBounds(145, y, 100, 25);
            this.add(prizeLabel);
            y = y + 40;
        }
    }

    private void initTitleLabel() {
        TipLabel titleLabel = new TipLabel("剩余数量", 20);
        titleLabel.setBounds(-1, 15, 85, 25);
        PositionUtil.setMiddle(titleLabel,this);
    }


    public void update() {
        Setting setting = dataService.getSetting();
        for(int i=0;i<6;i++) {
            PrizeLabel prizeLabel = prizeLabelList.get(i);
            prizeLabel.setNum(setting.select(i));
        }
    }
}
