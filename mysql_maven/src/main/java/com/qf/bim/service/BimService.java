package com.qf.bim.service;

import com.qf.bim.bean.BimBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */
public interface BimService {
    public List<BimBean> queryAllBim();
    public boolean addBim(BimBean bim);
    public boolean deleteById(int id);
}
