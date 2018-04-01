package com.hlx;

import com.hlx.config.ApplicationConfig;
import com.hlx.controller.ApplicationController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * A j2se program model that integrates spring and mybatis framework
 * @author hlx
 * @version 1.0 2018-3-15
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ApplicationController controller = ctx.getBean(ApplicationController.class);
        controller.init();
    }
}
