package com.hlx.service;

import com.hlx.view.common.RenewableFrame;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * The route service manage the relation between diff view
 * @author hlx
 * @version 1.0 2018-3-17
 */
@Service
public class RouteServiceImpl implements RouteService {

    //The current page url
    private String index = "/entry";

    private Map<String, RenewableFrame> urlMap = new HashMap<>();

    public void addUrl(String url, RenewableFrame frame) {
        urlMap.put(url,frame);
    }

    public void redirect(String url) {
        RenewableFrame old = urlMap.get(index);
        old.setVisible(false);
        RenewableFrame frame = urlMap.get(url);
        frame.refresh();
        frame.setVisible(true);
        index = url;
    }

    public void deleteUrl(String url) {
        if(urlMap.get(url)!=null)
            urlMap.remove(url);
    }
}
