package com.qf.bim.bean;

/**
 * Created by Administrator on 2019/5/14.
 */
public class BimBean {
    private int id;
    private String date;
    private String height;
    private String weight;
    private String bmi;
    private String sign;
    private String userName;

    public BimBean() {
    }

    @Override
    public String toString() {
        return "BimBean{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", bmi='" + bmi + '\'' +
                ", sign='" + sign + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public BimBean(int id, String date, String height, String weight, String bmi, String sign, String userName) {
        this.id = id;
        this.date = date;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.sign = sign;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
