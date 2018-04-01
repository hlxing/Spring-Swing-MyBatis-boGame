package com.hlx.controller;


import com.hlx.service.SoundService;
import com.hlx.view.common.FontUtil;
import com.hlx.view.entry.EntryFrame;
import com.hlx.view.settlement.SettlementFrame;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.awt.*;

@Controller
public class ApplicationController {

	private static final Logger logger = Logger.getLogger(ApplicationController.class);

	private EntryFrame frame;

	@Autowired
	public ApplicationController(EntryFrame frame) {
		this.frame = frame;
	}

	/**
	 * The begin of the bo game
	 */
	public void init() {
		FontUtil.initGlobalFont(new Font("sans-serif",Font.PLAIN,18));
		frame.refresh();
		frame.setVisible(true);

	}

}
