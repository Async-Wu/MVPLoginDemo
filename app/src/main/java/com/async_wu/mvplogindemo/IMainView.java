package com.async_wu.mvplogindemo;

/**
 * Created by Administrator on 2019/2/20.
 */

public interface IMainView {
    void onFailed(String msg);
    void onSuccess(Object object);
}
