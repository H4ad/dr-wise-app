package wiseonesoft.com.br.drwise.interactors;

import android.annotation.SuppressLint;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;

import wiseonesoft.com.br.drwise.interactors.payloads.LoginPayload;
import wiseonesoft.com.br.drwise.interactors.proxys.TokenProxy;
import wiseonesoft.com.br.drwise.interfaces.LoginMVP;
import wiseonesoft.com.br.drwise.repositorys.AuthRepository;
import wiseonesoft.com.br.drwise.utils.ApplicationConstants;
import wiseonesoft.com.br.drwise.utils.InteractorBase;

public class LoginInteractor extends InteractorBase implements LoginMVP.Interactor {

    AuthRepository authRepository;

    public LoginInteractor() {
        authRepository = getRetrofit().create(AuthRepository.class);
    }

    @SuppressLint("CheckResult")
    @Override
    public void getToken(LoginPayload loginPayload, Observer<TokenProxy> observable) {
        authRepository.getToken(loginPayload)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(observable);
    }

    @Override
    public String getAuthenticationToken() {
        return ApplicationConstants.EMPTY_STRING;
    }

    @Override
    public String getApiUrl() {
        return ApplicationConstants.API_URL;
    }
}
