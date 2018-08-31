package wiseonesoft.com.br.drwise;

import android.app.Activity;
import android.os.Bundle;

import wiseonesoft.com.br.drwise.interfaces.LaunchMVP;
import wiseonesoft.com.br.drwise.presenters.LaunchPresenter;

public class LaunchActivity extends Activity  implements LaunchMVP.View{

    LaunchMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launch);

        presenter = new LaunchPresenter(this);
    }
}
