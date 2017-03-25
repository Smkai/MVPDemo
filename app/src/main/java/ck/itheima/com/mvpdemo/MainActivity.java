package ck.itheima.com.mvpdemo;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import ck.itheima.com.mvpdemo.model.User;
import ck.itheima.com.mvpdemo.presenter.UserLoginPresenter;
import ck.itheima.com.mvpdemo.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IUserLoginView {

    private EditText etUsername;
    private EditText etPassword;
    private ProgressBar progressBar;
    private Context context;
    private Button btnLogin;
    private UserLoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        context = this;
        initViews();
        btnLogin.setOnClickListener(this);
    }

    private void initViews() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        presenter = new UserLoginPresenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                presenter.login();
                break;
        }
    }


    @Override
    public String getUsername() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void jump2Main(User user) {
        Toast.makeText(this, "登录成功，跳转主页", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFailed() {
        Toast.makeText(this, "用户名或者密码错误，请重新登录", Toast.LENGTH_SHORT).show();
    }
}
