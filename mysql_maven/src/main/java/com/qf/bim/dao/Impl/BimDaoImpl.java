package com.qf.bim.dao.Impl;

import com.qf.bim.bean.BimBean;
import com.qf.bim.dao.BimDao;
import com.qf.bim.utils.BaseDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */
public class BimDaoImpl extends BaseDao implements BimDao{
    @Override
    public List<BimBean> findAll() {
        List<BimBean> list=new ArrayList<>();
        try {
            super.getConnect();
            String sql="select * from bmi";
            pstmt = super.conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BimBean bimBean = new BimBean();
                bimBean.setBmi(rs.getString("bmi"));
                bimBean.setId(rs.getInt("id"));
                bimBean.setDate(rs.getString("date"));
                bimBean.setHeight(rs.getString("height"));
                bimBean.setWeight(rs.getString("weight"));
                bimBean.setSign(rs.getString("sign"));
                bimBean.setUserName(rs.getString("userName"));
                list.add(bimBean);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll();
        }
        return list;
    }

    @Override
    public boolean addBim(BimBean bim) {
        boolean isAdd=false;
        try {
            super.getConnect();
            String sql="insert bmi (date,height,weight,bmi,sign,userName) values(?,?,?,?,?,?)";
            pstmt = super.conn.prepareStatement(sql);
            pstmt.setString(1,bim.getDate());
            pstmt.setString(2,bim.getHeight());
            pstmt.setString(3,bim.getWeight());
            pstmt.setString(4,bim.getBmi());
            pstmt.setString(5,bim.getSign());
            pstmt.setString(6,bim.getUserName());
            int i = pstmt.executeUpdate();
            if(i==1){
                isAdd=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdd;
    }

    @Override
    public boolean deleteById(int id) {
        boolean isDelete=false;
        try {
            super.getConnect();
            String sql="delete from bmi where id="+id;
            pstmt = super.conn.prepareStatement(sql);
            int i = pstmt.executeUpdate();
            if (i==1){
                isDelete=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }
}
