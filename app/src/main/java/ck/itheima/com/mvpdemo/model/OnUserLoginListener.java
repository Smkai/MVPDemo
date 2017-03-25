package ck.itheima.com.mvpdemo.model;

/**登录回调接口
 * Created by youliang.ji on 2016/8/19.
 */
public interface OnUserLoginListener {
    /**登录成功回调*/
    void loginSuccess(User user);

    /**登录失败回调*/
    void loginFailed();
}
