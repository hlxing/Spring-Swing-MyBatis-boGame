package com.hlx.view.common;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * The util can keep the component in the middle of other component
 * @author hlx
 * @version 1.0 2017-?-?
 *
 */
public class PositionUtil {

	public static void setCenter(JComponent component,JComponent component2){
		if(component2.getLayout()!=null)
			component2.setLayout(null);
		int x = (component2.getWidth()-component.getWidth())/2;
		int y = (component2.getHeight()-component.getHeight())/2;
		int w = component.getWidth();
		int h = component.getHeight();
		component.setBounds(x, y, w,h);
		component2.add(component);
	}

	public static void setCenter(JComponent component,JFrame frame){
		if(frame.getLayout()!=null)
			frame.setLayout(null);
		int x = (frame.getWidth()-component.getWidth())/2;
		int y = (frame.getHeight()-28-component.getHeight())/2;
		int w = component.getWidth();
		int h = component.getHeight();
		component.setBounds(x, y, w,h);
		frame.add(component);
	}

	public static void setMiddle(JComponent component,JComponent component2) {
		if(component2.getLayout()!=null)
			component2.setLayout(null);
		int x = (component2.getWidth()-component.getWidth())/2;
		int y = component.getY();
		int w = component.getWidth();
		int h = component.getHeight();
		component.setBounds(x, y, w,h);
		component2.add(component);
	}
	

}
