package wiseonesoft.com.br.drwise.interfaces;

import android.content.Context;

public interface LaunchMVP {

    interface View {

        /**
         * Retorna o contexto da View
         */
        Context getContext();

        /**
         * Retorna uma String do arquivo strings.xml
         */
        String getString(int id);

        /**
         * Exibe a Activity de Login
         */
        void showLoginActivity();


        /**
         * Exibe a Activity principal
         */
        void showMainActivity();
    }

    interface Presenter {

        /**
         * Define um comportamento quando terminar a Splash Screen
         */
        void onSplashComplete();

        /**
         * Verifica se o usuário está logado
         */
        boolean hasLogged();

    }
}
