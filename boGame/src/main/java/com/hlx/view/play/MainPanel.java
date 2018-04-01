package com.hlx.view.play;

import com.hlx.config.SoundEnum;
import com.hlx.service.BoDrawService;
import com.hlx.service.RouteService;
import com.hlx.service.SoundService;
import com.hlx.view.common.BackgroundLabel;
import com.hlx.view.common.GeneralButton;
import com.hlx.view.common.TipLabel;
import com.hlx.view.common.TranslucentPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The main view of mainPanel
 * It includes the current user,six dices,notice,the button to start
 * @author hlx
 * @version 1.0 2018-3-19
 */
public class MainPanel extends TranslucentPanel implements Observer{

    private String result;

    private static final String PREFIX = "当前选手: ";

    private TipLabel userLabel;

    private List<BackgroundLabel> diceList;

    private TipLabel tipLabel;

    private GeneralButton playButton;

    private Timer changeTimer;

    private BoDrawService boDrawService;

    private DataService dataService;

    private RouteService routeService;

    private SoundService soundService;

    //private Integer id = 0;

    public MainPanel(float transparency, BoDrawService boDrawService, DataService dataService,
                     RouteService routeService,SoundService soundService) {
        super();
        this.setSize(635, 375);
        this.setTransparency(transparency);
        this.boDrawService = boDrawService;
        this.dataService = dataService;
        this.routeService = routeService;
        this.soundService = soundService;
        dataService.attach(this);
        initUserLabel();
        initExitLabel();
        initDiceLabel();
        initTipLabel();
        initPlayButton();
        initTimer();
    }



    private void initTimer() {
        ActionListener changeAction = e -> {
            result = boDrawService.draw();
            for(int i=0;i<result.length();i++) {
                String number = ""+result.charAt(i);
                diceList.get(i).setImage(ImageFactory.getInstance(number));
            }
        };
        changeTimer = new Timer(100, changeAction);
    }

    private void initPlayButton() {
        playButton = new GeneralButton("Go", 18);
        playButton.setBounds(560, 250, 60, 60);
        playButton.setBackground(new Color(139, 231, 128));
        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                playButton.setBackground(new Color(152, 252, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                playButton.setBackground(new Color(139, 231, 128));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
//                The following code is specially used for testing
//                id = id + 1;
//                if (id == 1) {
//                    dataService.setDate("444413");
//                } else if (id == 2) {
//                    dataService.setDate("444423");
//                } else if(id==3){
//                    dataService.setDate("444411");
//                } else if (id == 4) {
//                    dataService.setDate("123456");
//                } else if (id == 5) {
//                    dataService.setDate("444444");
//                }
                if(changeTimer.isRunning()){
                    changeTimer.stop();
                    dataService.setDate(result);
                    soundService.stop(SoundEnum.BEGIN);
                    soundService.play(SoundEnum.END);
                }else{
                    changeTimer.start();
                    soundService.stop(SoundEnum.END);
                    soundService.play(SoundEnum.BEGIN);
                }
            }
        });
        this.add(playButton);
    }

    private void initTipLabel() {
        String tip = "Tip: " + "抵制不良游戏,拒绝盗版游戏.注意自我保护,谨防受骗上当.";
        tipLabel = new TipLabel(tip, 20);
        tipLabel.setBounds(50, 330, 550, 20);
        this.add(tipLabel);
    }

    private void initDiceLabel() {
        diceList = new ArrayList<>(Arrays.asList(
                new BackgroundLabel("view/image/number/6.png"),
                new BackgroundLabel("view/image/number/6.png"),
                new BackgroundLabel("view/image/number/6.png"),
                new BackgroundLabel("view/image/number/6.png"),
                new BackgroundLabel("view/image/number/6.png"),
                new BackgroundLabel("view/image/number/6.png")
        ));
        for(int i=0,x=50;i<3;i++) {
            BackgroundLabel diceLabel = diceList.get(i);
            diceLabel.setLocation(x, 70);
            this.add(diceLabel);
            x = x + 150 ;
        }
        for(int i=3,x=50;i<6;i++) {
            BackgroundLabel diceLabel = diceList.get(i);
            diceLabel.setLocation(x, 200);
            this.add(diceLabel);
            x = x + 150 ;
        }
    }

    private void initExitLabel() {
        tipLabel = new TipLabel("EXIT", 28);
        tipLabel.setBounds(560,20, 150, 20);
        tipLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                routeService.redirect("/entry");
            }
        });
        this.add(tipLabel);
    }

    private void initUserLabel() {
        String user = PREFIX + "1";
        userLabel = new TipLabel(user, 20);
        userLabel.setBounds(50, 20, 150, 20);
        this.add(userLabel);
    }

    public void clear() {
        userLabel.setText(PREFIX+"1");
    }


    public void update() {
        Integer currentUser = dataService.getCurrentUser();
        String user = PREFIX + currentUser;
        userLabel.setText(user);
    }
}
