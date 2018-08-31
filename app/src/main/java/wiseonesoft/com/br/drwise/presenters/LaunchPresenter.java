package wiseonesoft.com.br.drwise.presenters;

import wiseonesoft.com.br.drwise.interfaces.LaunchMVP;

public class LaunchPresenter implements LaunchMVP.Presenter {

    private LaunchMVP.View view;

    public LaunchPresenter(LaunchMVP.View view) {
        this.view = view;
    }
}
