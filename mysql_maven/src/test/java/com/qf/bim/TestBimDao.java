package com.qf.bim;

import com.qf.bim.bean.BimBean;
import com.qf.bim.service.BimService;
import com.qf.bim.service.impl.BimServiceImpl;
import org.junit.Test;


import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */

public class TestBimDao {
    @Test
    public void bimdaotest(){
        BimService bimService = new BimServiceImpl();
        List<BimBean> all = bimService.queryAllBim();
        for (BimBean bim:all) {
            System.out.println(bim);
        }
    }
}
