package ck.itheima.com.mvpdemo.presenter;

import android.os.Handler;

import ck.itheima.com.mvpdemo.model.OnUserLoginListener;
import ck.itheima.com.mvpdemo.model.User;
import ck.itheima.com.mvpdemo.model.UserLogin;
import ck.itheima.com.mvpdemo.view.IUserLoginView;

/**
 * 类名:    UserLoginPresenter
 * 创建者:  ckqu
 * 创建时间:2017/3/25 0025 下午 11:06
 * 包名:    ck.itheima.com.mvpdemo.presenter
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class UserLoginPresenter implements OnUserLoginListener {

    private  UserLogin userLogin;
    private IUserLoginView userLoginView;

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLogin = new UserLogin();
        this.userLoginView = userLoginView;
    }


    /**
     * p层沟通、链接model和view的方法
     */
    public void login(){
        //1.显示滚动条
        userLoginView.showProgressBar();
        //2.调用登录业务逻辑,下面一行代码集中体现presenter起到桥梁的作用
        userLogin.login(userLoginView.getUsername(), userLoginView.getPassword(),this);
    }

    @Override
    public void loginSuccess(final User user) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //1.隐藏滚动条
                userLoginView.hideProgressBar();
                //2.跳转主页
                userLoginView.jump2Main(user);
            }
        });
    }

    @Override
    public void loginFailed() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //1.隐藏滚动条
                userLoginView.hideProgressBar();
                //2.提示用户
                userLoginView.showLoginFailed();
            }
        });
    }
    private Handler mHandler = new Handler();
}
