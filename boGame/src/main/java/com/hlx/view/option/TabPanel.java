package com.hlx.view.option;

import com.hlx.config.SoundEnum;
import com.hlx.service.SoundService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.swing.SwingConstants.CENTER;

/**
 * A abstract panel that be used for building beautiful option view quickly
 * @author hlx
 * @version 1.0 2018-3-17
 */
public class TabPanel extends JPanel {

    private JLabel numLabel;

    private List<JLabel> controlLabel;

    private Integer number;

    private Timer plusTimer;

    private Timer minusTimer;

    private Integer minNum;

    private SoundService soundService;

    public TabPanel(Integer number, Integer minNum, SoundService soundService) {
        super();
        this.setLayout(null);
        this.setSize(150,40);
        this.number = number;
        this.minNum = minNum;
        this.soundService = soundService;
        initNumLabel();
        initControlLabel();
        initTimer();
    }

    private void initTimer() {
        ActionListener plusAction = e -> {
            number = number + 1;
            numLabel.setText("" + number);
        };
        plusTimer = new Timer(250, plusAction);
        ActionListener minusAction = e -> {
            if (number > minNum)
                number = number - 1;
            numLabel.setText("" + number);
        };
        minusTimer = new Timer(250, minusAction);

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
        numLabel.setText(""+number);
    }

    private void initControlLabel() {
        controlLabel = new ArrayList<>(Arrays.asList(
                new JLabel("-", CENTER),
                new JLabel("+", CENTER)
        ));
        for (JLabel label : controlLabel) {
            label.setSize(50, 40);
            label.setOpaque(true);
            label.setFont(new Font("sans-serif", Font.PLAIN, 25));
            label.setBackground(new Color(240, 175, 211));
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    JLabel label = (JLabel) e.getSource();
                    label.setBackground(new Color(240, 161, 202));

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    JLabel label = (JLabel) e.getSource();
                    label.setBackground(new Color(240, 175, 211));
                }
            });
        }
        final JLabel minusLabel = controlLabel.get(0);
        minusLabel.setLocation(0,0);
        minusLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(number>minNum){
                    number = number - 1;
                    soundService.play(SoundEnum.CHANGE);
                }

                numLabel.setText(""+number);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                minusTimer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                minusTimer.stop();
            }
        });
        this.add(minusLabel);
        final JLabel plusLabel = controlLabel.get(1);
        plusLabel.setLocation(100,0);
        plusLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                number = number + 1;
                soundService.play(SoundEnum.CHANGE);
                numLabel.setText(""+number);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                plusTimer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                plusTimer.stop();
            }
        });
        this.add(plusLabel);
    }

    private void initNumLabel() {
        numLabel = new JLabel(""+number,CENTER);
        numLabel.setFont(new Font("sans-serif",Font.PLAIN,25));
        numLabel.setBounds(50, 0, 50, 40);
        numLabel.setOpaque(true);
        numLabel.setBackground(new Color(240, 157, 204));
        this.add(numLabel);
    }


}
