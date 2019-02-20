package com.async_wu.mvplogindemo;

/**
 * Created by Administrator on 2019/2/20.
 */

public class LoginModelImpl implements ILoginModel {
    @Override
    public void login(String user, String pwd, ILoginPresenter iLoginPresenter) {
        if(user.equals("user")&&pwd.equals("123456")){
            iLoginPresenter.onSuccess("登录成功！");
        }else {
            iLoginPresenter.onFailed("用户名或者密码错误！");
        }
    }
}
