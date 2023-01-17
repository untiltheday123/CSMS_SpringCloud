package com.goodsservice.controller;

//状态码
public class Code {

//    1结尾代表成功
    public static final Integer SAVE_OK = 20011;   //增
    public static final Integer DELETE_OK = 20021; //删
    public static final Integer UPDATE_OK = 20031; //改
    public static final Integer GET_OK = 20041;    //查

//    0结尾代表失败
    public static final Integer SAVE_ERR = 20010;  //增
    public static final Integer DELETE_ERR = 20020;//删
    public static final Integer UPDATE_ERR = 20030;//改
    public static final Integer GET_ERR = 20040;   //查
}
