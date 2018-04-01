package com.hlx.service;

import com.hlx.view.common.RenewableFrame;


public interface RouteService {

    void addUrl(String url, RenewableFrame frame);

    void redirect(String url);

    void deleteUrl(String url);

}
