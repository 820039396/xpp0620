package com.qf.bim.dao;


import com.qf.bim.bean.BimBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */
public interface BimDao {
   public List<BimBean> findAll();
   public boolean addBim(BimBean bim);
   public boolean deleteById(int id);
}
