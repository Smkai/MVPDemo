package ck.itheima.com.mvpdemo.model;

/**Model层业务逻辑：登录
 *
 * Created by youliang.ji on 2016/8/19.
 */
public interface IUserLogin {
    /**
     * 登录业务逻辑
     * @param username 用户名
     * @param password 密码
     * @param listener 回调接口
     */
    void login(String username, String password, OnUserLoginListener listener);
}
