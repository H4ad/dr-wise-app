package wiseonesoft.com.br.drwise.presenters;

import io.reactivex.disposables.Disposable;

import wiseonesoft.com.br.drwise.interactors.LoginInteractor;
import wiseonesoft.com.br.drwise.interactors.payloads.LoginPayload;
import wiseonesoft.com.br.drwise.interactors.proxys.ErrorProxy;
import wiseonesoft.com.br.drwise.interactors.proxys.TokenProxy;
import wiseonesoft.com.br.drwise.interfaces.LoginMVP;
import wiseonesoft.com.br.drwise.security.SecurityPreferences;
import wiseonesoft.com.br.drwise.utils.ObserverBase;

public class LoginPresenter implements LoginMVP.Presenter {

    LoginMVP.View view;
    LoginMVP.Interactor interactor;
    SecurityPreferences securityPreferences;


    public LoginPresenter(LoginMVP.View view) {
        this.view = view;
        this.interactor = new LoginInteractor();
        this.securityPreferences = view.getSecurityPreferences();
    }

    @Override
    public void doLogin() {
        LoginPayload loginPayload = new LoginPayload(view.getEmail(), view.getPassword());
        interactor.getToken(loginPayload, new ObserverBase<TokenProxy>() {

            @Override
            public void onCustomError(ErrorProxy errorProxy) {
                view.showErrorMessage(errorProxy.getMessage());
            }

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TokenProxy tokenProxy) {
                securityPreferences.storeString(view.getApiKey(), tokenProxy.getToken());
                view.showMainActivity();
            }

            @Override
            public void onComplete() {

            }
        });
        view.enableBtnEnter();
    }
}
