package wiseonesoft.com.br.drwise.interfaces;

import io.reactivex.Observer;

import wiseonesoft.com.br.drwise.interactors.payloads.LoginPayload;
import wiseonesoft.com.br.drwise.interactors.proxys.TokenProxy;
import wiseonesoft.com.br.drwise.security.SecurityPreferences;

public interface LoginMVP {

    interface View {

        /**
         * Retorna o valor digitado para o email
         */
        String getEmail();

        /**
         * Retorna o valor digitado para a senha
         */
        String getPassword();

        /**
         * Retorna a key da API
         */
        String getApiKey();

        /**
         * Pega o security preferences da view
         */
        SecurityPreferences getSecurityPreferences();

        /**
         * Exibe uma mensagem de erro ao usuário
         */
        void showErrorMessage(String error);

        /**
         * Exibe a activity para se registrar
         */
        void showRegisterActivity();

        /**
         * Exibe a activity principal
         */
        void showMainActivity();

        /**
         * Faz o login do usuário
         */
        void doLogin();

        /**
         * Desativa o botão de entrar
         */
        void disableBtnEnter();

        /**
         * Ativa o botão de entrar
         */
        void enableBtnEnter();
    }

    interface Presenter {

        /**
         * Faz o login do usuário
         */
        void doLogin();

    }

    interface Interactor {

        /**
         * Faz a requisição na api pelo token
         */
        void getToken(LoginPayload loginPayload, Observer<TokenProxy> observable);

    }
}
