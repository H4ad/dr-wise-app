package wiseonesoft.com.br.drwise.presenters;

import io.reactivex.disposables.Disposable;

import wiseonesoft.com.br.drwise.interactors.RegisterInteractor;
import wiseonesoft.com.br.drwise.interactors.payloads.RegisterPayload;
import wiseonesoft.com.br.drwise.interactors.proxys.EmptyProxy;
import wiseonesoft.com.br.drwise.interactors.proxys.ErrorProxy;
import wiseonesoft.com.br.drwise.interfaces.RegisterMVP;
import wiseonesoft.com.br.drwise.utils.ObserverBase;

public class RegisterPresenter implements RegisterMVP.Presenter {

    private RegisterMVP.Interactor interactor;
    private RegisterMVP.View view;

    public RegisterPresenter(RegisterMVP.View view) {
        this.view = view;
        this.interactor = new RegisterInteractor();
    }

    @Override
    public void doRegister() {
        RegisterPayload registerPayload = new RegisterPayload(view.getName(), view.getEmail(), view.getPassword(), view.getPasswordConfirmation());
        interactor.doRegister(registerPayload, new ObserverBase<EmptyProxy>(){

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(EmptyProxy emptyProxy) {
                view.showSuccessfullMessage();
                view.enableBtnRegister();
                view.showLoginActivity();
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onCustomError(ErrorProxy errorProxy) {
                view.showMessage(errorProxy.getMessage());
            }
        });
    }
}
