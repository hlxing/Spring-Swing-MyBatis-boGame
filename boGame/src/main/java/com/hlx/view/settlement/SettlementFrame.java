package com.hlx.view.settlement;

import com.hlx.model.User;
import com.hlx.service.RouteService;
import com.hlx.view.common.*;
import com.hlx.view.play.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * The settlement page of bo game
 * @author hlx
 * @version 1.0 2018-3-24
 */
@Component
public class SettlementFrame extends RenewableFrame{


    private BackgroundLabel backgroundLabel;

    private TranslucentPanel mainPanel;

    private List<GeneralButton> buttonList;

    private List<RecordPanel> recordPanelList;

    private RouteService routeService;

    private DataService dataService;

    private List<User> userList;

    private int page;

    @Autowired
    public SettlementFrame(RouteService routeService,DataService dataService) {
        super(true);
        this.routeService = routeService;
        this.dataService = dataService;
        routeService.addUrl("/settlement",this);
        this.setSize(970, 530);
        initBackground();
        initMainPanel();
    }

    private void initMainPanel() {
        mainPanel = new TranslucentPanel();
        mainPanel.setTransparency((float) 0.4);
        mainPanel.setSize(910,475);
        PositionUtil.setCenter(mainPanel,backgroundLabel);

        TipLabel titleLabel = new TipLabel("游戏结算", 20);
        titleLabel.setBounds(15, 15, 85, 25);
        mainPanel.add(titleLabel);

        NavigationPanel navigationPanel = new NavigationPanel();
        navigationPanel.setLocation(35, 70);
        mainPanel.add(navigationPanel);

        recordPanelList = new ArrayList<>(Arrays.asList(
                new RecordPanel(),
                new RecordPanel(),
                new RecordPanel(),
                new RecordPanel(),
                new RecordPanel()
        ));
        int y = 130;
        for (RecordPanel recordPanel : recordPanelList) {
            recordPanel.setLocation(35, y);
            mainPanel.add(recordPanel);
            y = y + 50;

        }

        buttonList = new ArrayList<>(Arrays.asList(
                new GeneralButton("上一页",13),
                new GeneralButton("下一页",13),
                new GeneralButton("关闭",13)
        ));
        int x = 200;
        for (GeneralButton button : buttonList) {
            button.setBounds(x,415,110,35);
            button.setBackground(new Color(77, 230, 35));
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    setBackground(new Color(85, 255, 39));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    setBackground(new Color(77, 230, 35));
                }
            });
            mainPanel.add(button);
            x = x + 175;
        }

        buttonList.get(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (page != 0) {
                    page = page - 1;
                    updateRecord();
                }
            }
        });

        buttonList.get(1).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                page = page + 1;
                updateRecord();
            }
        });

        buttonList.get(2).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                routeService.redirect("/entry");
            }
        });
    }

    private void initBackground() {
        backgroundLabel = new BackgroundLabel("view/image/background/back4.jpg");
        this.add(backgroundLabel);
    }

    @Override
    public void refresh() {
        Map<Integer,User> userMap = dataService.getUserMap();
        userList = new ArrayList<>();
        for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
            userList.add(entry.getValue());
        }
        userList.sort(Comparator.comparing(User::getScore));
        Collections.reverse(userList);
        page = 0;
        updateRecord();
    }

    private void updateRecord() {
        int begin = page*5;
        //The situation of null info
        if (userList.size() == 0) {
            page = page + 1;
            return;
        } else if (userList.size()-1 < begin) {
            page = page - 1;
            return;
        }
        hiddenRecord();
        System.out.println(userList);
        for(int i=begin,n=0;i<begin+5&&i<userList.size();i++,n++) {
            User user = userList.get(i);
            recordPanelList.get(n).update(user);
            recordPanelList.get(n).setVisible(true);
        }
    }

    private void hiddenRecord() {
        for (RecordPanel recordPanel : recordPanelList) {
            recordPanel.setVisible(false);
        }
    }
}
