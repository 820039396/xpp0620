package com.qf.bim.service.impl;

import com.qf.bim.bean.BimBean;
import com.qf.bim.dao.BimDao;
import com.qf.bim.dao.Impl.BimDaoImpl;
import com.qf.bim.service.BimService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */
public class BimServiceImpl implements BimService{
    BimDao bimDao;

    public BimServiceImpl() {
    }

    public BimServiceImpl(BimDao bimDao) {
        this.bimDao = bimDao;
    }

    @Override
    public List<BimBean> queryAllBim() {
        bimDao=new BimDaoImpl();
        List<BimBean> all = bimDao.findAll();
        return all;
    }

    @Override
    public boolean addBim(BimBean bim) {
        return bimDao.addBim(bim);
    }

    @Override
    public boolean deleteById(int id) {
        return bimDao.deleteById(id);
    }


}
