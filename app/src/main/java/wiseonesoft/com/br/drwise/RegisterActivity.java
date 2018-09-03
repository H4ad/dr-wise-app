package wiseonesoft.com.br.drwise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import wiseonesoft.com.br.drwise.interfaces.RegisterMVP;

public class RegisterActivity extends AppCompatActivity implements RegisterMVP.View {

    @BindView(R.id.edit_register_name)
    AppCompatEditText editRegisterName;

    @BindView(R.id.edit_register_email)
    AppCompatEditText editRegisterEmail;

    @BindView(R.id.edit_register_password)
    AppCompatEditText editRegisterPassword;

    @BindView(R.id.edit_register_password_confirmation)
    AppCompatEditText editRegisterPasswordConfirmation;

    @BindView(R.id.card_register)
    CardView cardRegister;

    @BindView(R.id.text_register_view)
    AppCompatTextView textRegisterView;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick(R.id.card_register)
    public void onViewClicked() {

    }

    @Override
    public String getName() {
        return editRegisterName.getText().toString();
    }

    @Override
    public String getEmail() {
        return editRegisterEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return editRegisterPassword.getText().toString();
    }

    @Override
    public String getPasswordConfirmation() {
        return editRegisterPasswordConfirmation.getText().toString();
    }

    @Override
    public void showErrorMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void disableBtnRegister() {
        cardRegister.setEnabled(false);
        textRegisterView.setText(R.string.registering);
    }

    @Override
    public void enableBtnRegister() {
        cardRegister.setEnabled(true);
        textRegisterView.setText(R.string.register);
    }

    @Override
    public void showLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
