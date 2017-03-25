package ck.itheima.com.mvpdemo.view;

import ck.itheima.com.mvpdemo.model.User;

/**MVP中的View层
 * 如何写View层代码？
 * 1.有什么操作：获取用户名、获取密码
 * 2.有什么用户交互（为了提高用户体验）：显示滚动框、隐藏滚动框
 * 3.结果是什么：成功跳转主页、失败提示用户
 */
public interface IUserLoginView {
    /**获取用户名*/
    String getUsername();
    /**获取密码*/
    String getPassword();

    /**显示滚动框*/
    void showProgressBar();
    /**隐藏滚动框*/
    void hideProgressBar();

    /**登录成功跳转主页*/
    void jump2Main(User user);
    /**登录失败提示用户*/
    void showLoginFailed();
}
