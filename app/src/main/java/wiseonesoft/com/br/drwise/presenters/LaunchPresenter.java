package wiseonesoft.com.br.drwise.presenters;

import wiseonesoft.com.br.drwise.interfaces.LaunchMVP;
import wiseonesoft.com.br.drwise.security.SecurityPreferences;

public class LaunchPresenter implements LaunchMVP.Presenter {

    private SecurityPreferences securityPreferences;
    private LaunchMVP.View view;

    public LaunchPresenter(LaunchMVP.View view) {
        this.view = view;
        this.securityPreferences = new SecurityPreferences(view.getContext());
    }

    @Override
    public void onSplashComplete() {
        if(hasLogged())
            view.showMainActivity();
        else
            view.showLoginActivity();

    }

    @Override
    public boolean hasLogged() {
        return !securityPreferences.getString(view.getTokenKey()).isEmpty();
    }
}
