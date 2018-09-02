package wiseonesoft.com.br.drwise.presenters;

import wiseonesoft.com.br.drwise.interfaces.LoginMVP;

public class LoginPresenter implements LoginMVP.Presenter {

    LoginMVP.View view;

    public LoginPresenter(LoginMVP.View view) {
        this.view = view;
    }

    @Override
    public void makeLogin() {

    }
}
