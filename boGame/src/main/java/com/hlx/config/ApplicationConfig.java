package com.hlx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = {"dataConfig.xml", "sessionConfig.xml"})
@ComponentScan(basePackages={"com.hlx.service","com.hlx.controller","com.hlx.view"})
public class ApplicationConfig{ }
