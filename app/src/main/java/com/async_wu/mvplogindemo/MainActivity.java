package com.async_wu.mvplogindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements IMainView{
    Unbinder unbinder;
    @BindView(R.id.ed_user)
    EditText userEditText;
    @BindView(R.id.ed_pwd)
    EditText pwdEditText;
    @BindView(R.id.btn_login)
    Button loginButton;
    private LoginPresenterImpl loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder =  ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_login)
    public void btnOnclick(){
        String user = userEditText.getText().toString();
        String pwd = pwdEditText.getText().toString();
        Log.e("msg",user+"    "+pwd);
        if(user==null||"".equals(user)){
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if(pwd==null||"".equals(pwd)){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        loginPresenter.login(user,pwd);
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess(Object object) {
        String json = (String) object;
        Toast.makeText(this,json,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
        finish();
    }
}
