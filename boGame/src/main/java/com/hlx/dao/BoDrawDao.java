package com.hlx.dao;

import com.hlx.model.BoDraw;
import java.util.List;

public interface BoDrawDao {

    void save(BoDraw boDraw);

    void delete();

    List<BoDraw> get();

}
