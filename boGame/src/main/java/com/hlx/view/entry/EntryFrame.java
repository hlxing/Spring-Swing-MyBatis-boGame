package com.hlx.view.entry;

import com.hlx.config.SoundEnum;
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
 * The entry page of bo game
 * @author hlx
 * @version 1.0 2018-3-17
 */
@Component
public class EntryFrame extends RenewableFrame{

    private BackgroundLabel backgroundLabel;

    private TranslucentPanel mainPanel;

    private WordsLabel titleLabel;

    private List<WordsLabel> optionLabelList;

    private static final float mainPanelTransparency = (float) 0.2;

    private RouteService routeService;

    private SoundService soundService;

    @Autowired
    public EntryFrame(RouteService routeService,SoundService soundService) {
        super(true);
        this.routeService = routeService;
        this.soundService = soundService;
        routeService.addUrl("/entry",this);
        initBackground();
        initMainPanel();
    }

    public void refresh() {
        //null
    }

    private void initMainPanel() {
        //init the mainPanel
        mainPanel =new TranslucentPanel();
        mainPanel.setSize(600, 500);
        mainPanel.setTransparency(mainPanelTransparency);
        PositionUtil.setCenter(mainPanel,backgroundLabel);
        //init the title
        titleLabel = new WordsLabel("Bo      Game",30,false);
        titleLabel.setForeground(new Color(240, 49, 105));
        titleLabel.setSize(180,70);
        titleLabel.setLocation(-1,30);
        PositionUtil.setMiddle(titleLabel, mainPanel);
        //init the option
        optionLabelList = new ArrayList<>(Arrays.asList(
                new WordsLabel("PLAY", 30, true),
                new WordsLabel("OPTION", 30, true),
                new WordsLabel("RECORD", 30, true),
                new WordsLabel("EXIT", 30, true)
        ));
        int initY = 200;
        for (WordsLabel optionLabel : optionLabelList) {
            optionLabel.setForeground(new Color(248, 47, 60));
            optionLabel.setSize(150, 30);
            optionLabel.setLocation(-1,initY);
            PositionUtil.setMiddle(optionLabel,mainPanel);
            initY = initY + 50;
        }
        WordsLabel playLabel = optionLabelList.get(0);
        playLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                soundService.play(SoundEnum.DECISION);
                routeService.redirect("/play");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                soundService.play(SoundEnum.HOVER);
            }
        });
        WordsLabel optionLabel = optionLabelList.get(1);
        optionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                soundService.play(SoundEnum.DECISION);
                soundService.play(SoundEnum.HOVER);
                routeService.redirect("/option");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                soundService.play(SoundEnum.HOVER);
            }
        });
        WordsLabel recordLabel = optionLabelList.get(2);
        recordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                soundService.play(SoundEnum.DECISION);
                soundService.play(SoundEnum.HOVER);
                routeService.redirect("/record");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                soundService.play(SoundEnum.HOVER);
            }
        });
        WordsLabel exitLabel = optionLabelList.get(3);
        exitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                soundService.play(SoundEnum.DECISION);
                soundService.play(SoundEnum.HOVER);
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                soundService.play(SoundEnum.HOVER);
            }
        });
    }



    private void initBackground() {
        backgroundLabel = new BackgroundLabel("view/image/background/back.jpg");
        this.add(backgroundLabel);
    }





}
