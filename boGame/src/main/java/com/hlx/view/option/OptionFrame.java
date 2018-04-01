package com.hlx.view.option;

import com.hlx.model.Setting;
import com.hlx.service.SettingService;
import com.hlx.service.RouteService;
import com.hlx.service.SoundService;
import com.hlx.view.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The option frame of bo game
 * @author hlx
 * @version 1.0 2018-3-17
 */
@Component
public class OptionFrame extends RenewableFrame{

    private BackgroundLabel backgroundLabel;

    private TranslucentPanel mainPanel;

    private WordsLabel titleLabel;

    private List<WordsLabel> attentionLabelList;

    private List<TabPanel> tabPanelList;

    private List<GeneralButton> selButtonList;

    private static final float mainPanelTransparency = (float) 0.4;

    private RouteService routeService;

    private SettingService settingService;

    private SoundService soundService;

    @Autowired
    public OptionFrame(RouteService routeService,SettingService optionService,SoundService soundService) {
        super(true);
        this.routeService = routeService;
        this.settingService = optionService;
        this.soundService = soundService;
        routeService.addUrl("/option",this);
        initBackground();
        initMainPanel();
    }


    public void refresh() {
        Setting option = settingService.get();
        tabPanelList.get(0).setNumber(option.getNum());
        tabPanelList.get(1).setNumber(option.getNum2());
        tabPanelList.get(2).setNumber(option.getNum3());
        tabPanelList.get(3).setNumber(option.getNum4());
        tabPanelList.get(4).setNumber(option.getNum5());
        tabPanelList.get(5).setNumber(option.getNum6());
        tabPanelList.get(6).setNumber(option.getNum7());
    }

    private void initMainPanel() {
        //init the mainPanel
        mainPanel =new TranslucentPanel();
        mainPanel.setSize(600, 500);
        mainPanel.setTransparency(mainPanelTransparency);
        PositionUtil.setCenter(mainPanel,backgroundLabel);
        //init the title
        titleLabel = new WordsLabel("OPTION",30,false);
        titleLabel.setForeground(new Color(31, 89,240));
        titleLabel.setSize(180,30);
        titleLabel.setLocation(0,0);
        mainPanel.add(titleLabel);
        //init the attention
        attentionLabelList = new ArrayList<>(Arrays.asList(
                new WordsLabel("一秀", 25, false, SwingConstants.CENTER),
                new WordsLabel("二举", 25, false, SwingConstants.CENTER),
                new WordsLabel("四进", 25, false, SwingConstants.CENTER),
                new WordsLabel("三红", 25, false, SwingConstants.CENTER),
                new WordsLabel("对堂", 25, false, SwingConstants.CENTER),
                new WordsLabel("状元", 25, false, SwingConstants.CENTER),
                new WordsLabel("玩家", 25, false, SwingConstants.CENTER)
        ));
        int initY = 80;
        for (WordsLabel attentionLabel : attentionLabelList) {
            attentionLabel.setForeground(new Color(100, 71,240));
            attentionLabel.setSize(100, 40);
            attentionLabel.setLocation(100,initY);


            attentionLabel.setBackground(new Color(240, 175, 211));
            attentionLabel.setOpaque(true);

            mainPanel.add(attentionLabel);
            initY = initY + 50;
        }
        //init the tab
        tabPanelList = new ArrayList<>(Arrays.asList(
                new TabPanel(-1,0,soundService),
                new TabPanel(-1,0,soundService),
                new TabPanel(-1,0,soundService),
                new TabPanel(-1,0,soundService),
                new TabPanel(-1,0,soundService),
                new TabPanel(-1,0,soundService),
                new TabPanel(-1,1,soundService)
        ));
        initY = 80;
        for (TabPanel tabPanel : tabPanelList) {
            tabPanel.setLocation(200,initY);
            mainPanel.add(tabPanel);
            initY = initY + 50;
        }
        //init the sel button
        selButtonList = new ArrayList<>(Arrays.asList(
                new GeneralButton("保存", 22),
                new GeneralButton("取消", 22),
                new GeneralButton("重置", 22)
        ));
        initY = 120;
        for (GeneralButton selButton :selButtonList) {
            selButton.setBackground(new Color(240, 175, 211));
            selButton.setBounds(450, initY, 80, 60);
            mainPanel.add(selButton);
            initY = initY + 100;
        }
        GeneralButton saveButton = selButtonList.get(0);
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Setting setting = new Setting(
                        tabPanelList.get(0).getNumber(),
                        tabPanelList.get(1).getNumber(),
                        tabPanelList.get(2).getNumber(),
                        tabPanelList.get(3).getNumber(),
                        tabPanelList.get(4).getNumber(),
                        tabPanelList.get(5).getNumber(),
                        tabPanelList.get(6).getNumber()
                );
                settingService.save(setting);
                routeService.redirect("/entry");
            }
        });
        GeneralButton cancelButton = selButtonList.get(1);
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                routeService.redirect("/entry");
            }
        });
        GeneralButton resetButton = selButtonList.get(2);
        resetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (TabPanel tabPanel : tabPanelList) {
                    tabPanel.setNumber(0);
                }
                tabPanelList.get(6).setNumber(1);
            }
        });

    }



    private void initBackground() {
        backgroundLabel = new BackgroundLabel("view/image/background/back2.jpg");
        this.add(backgroundLabel);
    }


}
