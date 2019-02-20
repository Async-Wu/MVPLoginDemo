package com.async_wu.mvplogindemo;

/**
 * Created by Administrator on 2019/2/20.
 */

public interface ILoginModel {
    void login(String user,String pwd,ILoginPresenter iLoginPresenter);
}

