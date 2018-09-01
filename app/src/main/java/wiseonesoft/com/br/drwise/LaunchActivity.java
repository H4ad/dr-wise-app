package wiseonesoft.com.br.drwise;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import butterknife.BindString;
import wiseonesoft.com.br.drwise.interfaces.LaunchMVP;
import wiseonesoft.com.br.drwise.presenters.LaunchPresenter;

public class LaunchActivity extends Activity  implements LaunchMVP.View {

    LaunchMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launch);

        presenter = new LaunchPresenter(this);

        new Handler().postDelayed(presenter::onSplashComplete, 1000);
    }

    @Override
    public Context getContext() {
        return this.getBaseContext();
    }

    @Override
    public String getTokenKey() {
        return getString(R.string.api_token_key);
    }

    @Override
    public void showLoginActivity() {

    }

    @Override
    public void showMainActivity() {

    }
}
