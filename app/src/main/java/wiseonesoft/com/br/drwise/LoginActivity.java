package wiseonesoft.com.br.drwise;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import wiseonesoft.com.br.drwise.interfaces.LoginMVP;
import wiseonesoft.com.br.drwise.presenters.LoginPresenter;
import wiseonesoft.com.br.drwise.security.SecurityPreferences;

public class LoginActivity extends Activity implements LoginMVP.View {

    @BindView(R.id.edit_email)
    AppCompatEditText editEmail;

    @BindView(R.id.edit_password)
    AppCompatEditText editPassword;

    LoginMVP.Presenter presenter;
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        unbinder = ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public String getEmail() {
        return editEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return editPassword.getText().toString();
    }

    @Override
    public String getApiKey() {
        return getString(R.string.api_token_key);
    }

    @Override
    public SecurityPreferences getSecurityPreferences() {
        return new SecurityPreferences(this);
    }

    @Override
    public void showErrorMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    @OnClick(R.id.text_register)
    public void showRegisterActivity() {}

    @Override
    public void showMainActivity() {}

    @Override
    @OnClick(R.id.btn_enter)
    public void doLogin() {
        if(getEmail().isEmpty()) {
            showErrorMessage(getString(R.string.error_email_required));
            return;
        }

        if(getPassword().isEmpty())
        {
            showErrorMessage(getString(R.string.error_password_required));
            return;
        }

        presenter.doLogin();
    }
}
