package ck.itheima.com.mvpdemo.model;

import android.os.SystemClock;

/**
 * Created by youliang.ji on 2016/8/19.
 */
public class UserLogin implements IUserLogin {
    @Override
    public void login(final String username, final String password, final OnUserLoginListener listener) {
        //登录业务具体实现
        //模拟网络耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                //耗时操作
                SystemClock.sleep(2000);
                //判断用户名和密码
                if("heima25".equals(username) && "123456".equals(password)){//登录成功
                    User user = new User(username, password);
                    listener.loginSuccess(user);
                }else{
                    listener.loginFailed();
                }
            }
        }).start();
    }
}
