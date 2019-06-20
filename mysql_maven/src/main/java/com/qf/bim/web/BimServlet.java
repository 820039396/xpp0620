package com.qf.bim.web;

import com.google.gson.Gson;
import com.qf.bim.bean.BimBean;
import com.qf.bim.dao.Impl.BimDaoImpl;
import com.qf.bim.service.BimService;
import com.qf.bim.service.impl.BimServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */
public class BimServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acation=req.getParameter("action");
        if ("list".equals(acation)){
            list(req,resp);
        }else if ("delete".equals(acation)){
            delete(req,resp);
        }else if ("add".equals(acation)){
            add(req,resp);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        String height = req.getParameter("h") == null ? "0" : req.getParameter("h");
        String weight = req.getParameter("w") == null ? "0" : req.getParameter("w");
        String bmi = req.getParameter("bmi") == null ? "0" : req.getParameter("bmi");
        String sign = req.getParameter("sign") == null ? "0" : req.getParameter("sign");
        String date = req.getParameter("date") == null ? "0" : req.getParameter("date");
        //思路：如果数据库添加成功，则调用下面的selectBmi方法，返回一个Json值给Js
        BimBean bim=new BimBean(1,date,height,weight,bmi,sign,"xp");
        BimService bimService = new BimServiceImpl(new BimDaoImpl());
        boolean isAdd = bimService.addBim(bim);
        String json=null;
        if(isAdd){
            List<BimBean> all = bimService.queryAllBim();
            json = new Gson().toJson(all);
        }
        try {
            PrintWriter out = resp.getWriter();
            out.write(json);//这里就应该返回Json;
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id") == null ? "0" : req.getParameter("id"));
        System.out.println(id);
        BimService bimService = new BimServiceImpl(new BimDaoImpl());
        boolean b = bimService.deleteById(id);
        if(b){
            try {
                PrintWriter out = resp.getWriter();
                out.write("success");
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = selectBmi();
        //获取Http协议的打印流（响应流）
        PrintWriter writer = resp.getWriter();
        writer.write(json);
        writer.flush();//清空缓存
        writer.close();
    }
    protected String selectBmi(){
        BimService bimService = new BimServiceImpl();
        List<BimBean> all = bimService.queryAllBim();
        String json = new Gson().toJson(all);
        return json;
    }
}
