package com.hlx.service;

import com.hlx.model.BoDraw;

import java.util.List;

public interface BoDrawService {

    String draw();

    void save(BoDraw boDraw);

    List<BoDraw> get();

    void delete();

}
