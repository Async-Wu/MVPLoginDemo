package com.async_wu.mvplogindemo;

/**
 * Created by Administrator on 2019/2/20.
 */

public interface ILoginPresenter {
    void login(String user,String pwd);
    void onFailed(String msg);
    void onSuccess(Object object);
}
