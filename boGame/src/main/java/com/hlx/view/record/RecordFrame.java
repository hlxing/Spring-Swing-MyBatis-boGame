package com.hlx.view.record;

import com.hlx.config.SoundEnum;
import com.hlx.model.BoDraw;
import com.hlx.service.BoDrawService;
import com.hlx.service.RouteService;
import com.hlx.service.SoundService;
import com.hlx.view.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * The record frame of bo game
 * @author hlx
 * @version 1.0 2018-3-18
 */
@Component
public class RecordFrame extends RenewableFrame{

    private BackgroundLabel backgroundLabel;

    private TranslucentPanel mainPanel;

    private WordsLabel titleLabel;

    private List<RecordPanel> recordPanelList;

    private List<GeneralButton> selButtonList;

    private List<BoDraw> boDrawList;

    private static final float mainPanelTransparency = (float) 0.08;

    private RouteService routeService;

    private BoDrawService boDrawService;

    private SoundService soundService;

    private Integer page;

    private Integer maxPage;

    @Autowired
    public RecordFrame(RouteService routeService,BoDrawService boDrawService,SoundService soundService) {
        super(true);
        this.routeService = routeService;
        this.boDrawService = boDrawService;
        this.soundService = soundService;
        routeService.addUrl("/record",this);
        initBackground();
        initMainPanel();
    }

    public void refresh() {
        page = 0;
        boDrawList = boDrawService.get();
        System.out.println(boDrawList.size());
        maxPage = boDrawList.size()%4==0 ? boDrawList.size()/4-1: boDrawList.size()/4;
        System.out.println(maxPage);
        updateRecord();
    }

    private void updateRecord() {
        Integer begin = (page-1)*4 + 4;
        hiddenRecord();
        Integer end = boDrawList.size()<begin+4 ? boDrawList.size() : begin+4;
        List<BoDraw> partialBoDraw = boDrawList.subList(begin, end);
        int i = 0;
        for (BoDraw boDraw : partialBoDraw) {
            recordPanelList.get(i).setBoDraw(boDraw);
            recordPanelList.get(i).setVisible(true);
            i = i + 1;
        }
    }

    /**
     * It is used to temporarily hide the record
     * that will be show if it have info
     */
    private void hiddenRecord() {
        for (RecordPanel recordPanel : recordPanelList) {
            recordPanel.setVisible(false);
        }
    }


    private void initMainPanel() {
        //init the mainPanel
        mainPanel =new TranslucentPanel();
        mainPanel.setSize(600, 500);
        mainPanel.setTransparency(mainPanelTransparency);
        PositionUtil.setCenter(mainPanel,backgroundLabel);
        //init the title
        titleLabel = new WordsLabel("RECORD",30,false);
        titleLabel.setForeground(new Color(31, 89,240));
        titleLabel.setSize(180,30);
        titleLabel.setLocation(0,0);
        mainPanel.add(titleLabel);
        //init the record
        BoDraw boDraw = new BoDraw("null","null",-1, (long) -1);
        recordPanelList = new ArrayList<>(Arrays.asList(
                new RecordPanel(boDraw),
                new RecordPanel(boDraw),
                new RecordPanel(boDraw),
                new RecordPanel(boDraw)
        ));
        int initY = 50;
        for (RecordPanel recordPanel : recordPanelList) {
            recordPanel.setLocation(-1, initY);
            PositionUtil.setMiddle(recordPanel, mainPanel);
            initY = initY + 90;
        }
        //init the button
        selButtonList = new ArrayList<>(Arrays.asList(
                new GeneralButton("上页", 22),
                new GeneralButton("下页", 22),
                new GeneralButton("返回", 22)
        ));
        int initX = 125;
        for (GeneralButton selButton :selButtonList) {
            selButton.setBackground(new Color(146, 150, 240));
            selButton.setBounds(initX, 420, 80, 60);
            mainPanel.add(selButton);
            initX = initX + 120;
        }
        GeneralButton up = selButtonList.get(0);
        up.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (page != 0) {
                    page = page - 1;
                    soundService.play(SoundEnum.PAGE);
                    updateRecord();
                }
            }
        });
        GeneralButton down = selButtonList.get(1);
        down.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(page<maxPage){
                    page = page + 1;
                    soundService.play(SoundEnum.PAGE);
                    updateRecord();
                }
            }
        });
        GeneralButton home = selButtonList.get(2);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                routeService.redirect("/entry");
            }
        });
    }


    private void initBackground() {
        backgroundLabel = new BackgroundLabel("view/image/background/back3.jpg");
        this.add(backgroundLabel);
    }

}
