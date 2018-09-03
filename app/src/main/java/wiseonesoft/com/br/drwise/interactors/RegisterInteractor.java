package wiseonesoft.com.br.drwise.interactors;

import android.annotation.SuppressLint;

import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Retrofit;
import wiseonesoft.com.br.drwise.interactors.payloads.RegisterPayload;
import wiseonesoft.com.br.drwise.interactors.proxys.EmptyProxy;
import wiseonesoft.com.br.drwise.interactors.proxys.ErrorProxy;
import wiseonesoft.com.br.drwise.repositorys.AuthRepository;
import wiseonesoft.com.br.drwise.utils.ApplicationConstants;
import wiseonesoft.com.br.drwise.utils.InteractorBase;
import wiseonesoft.com.br.drwise.interfaces.RegisterMVP;
import wiseonesoft.com.br.drwise.utils.ObserverBase;

public class RegisterInteractor extends InteractorBase implements RegisterMVP.Interactor {

    AuthRepository authRepository;

    public RegisterInteractor() {
        this.authRepository = getRetrofit().create(AuthRepository.class);
    }

    @SuppressLint("CheckResult")
    @Override
    public void doRegister(RegisterPayload registerPayload, ObserverBase<EmptyProxy> observerBase) {
        authRepository.doRegister(registerPayload)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observerBase);
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
