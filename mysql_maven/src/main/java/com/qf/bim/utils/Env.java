package com.qf.bim.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**以单例模式加载数据库参数文件
 * Created by Administrator on 2019/5/14.
 */
public class Env extends Properties {
    static Env singleTon = null;
    //构造器私有
    private Env(){
        makedb();
    }
    private void makedb() {
        InputStream stream = this.getClass().getResourceAsStream("/db.properties");
        try {
            super.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //对外提供公共的访问途径
    public synchronized static Env newInstance(){
        if (singleTon==null){
            singleTon=new Env();
        }
        return singleTon;
    }
}
