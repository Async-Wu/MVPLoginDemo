package com.async_wu.mvplogindemo;

/**
 * Created by Administrator on 2019/2/20.
 */

public class LoginPresenterImpl implements ILoginPresenter {
    private IMainView iMainView;
    private LoginModelImpl loginModel;

    public LoginPresenterImpl(IMainView iMainView){
        this.iMainView = iMainView;
        loginModel = new LoginModelImpl();
    }

    @Override
    public void login(String user, String pwd) {
        loginModel.login(user,pwd,this);
    }

    @Override
    public void onFailed(String msg) {
        if(iMainView!=null){
            iMainView.onFailed(msg);
        }
    }

    @Override
    public void onSuccess(Object object) {
        if(iMainView!=null){
            //可在此做json解析 处理返回数据
            iMainView.onSuccess(object);
        }
    }
}
