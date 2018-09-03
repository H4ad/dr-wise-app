package wiseonesoft.com.br.drwise.interfaces;

import wiseonesoft.com.br.drwise.interactors.payloads.RegisterPayload;
import wiseonesoft.com.br.drwise.interactors.proxys.ErrorProxy;
import wiseonesoft.com.br.drwise.utils.ObserverBase;

public interface RegisterMVP {

    interface View {

        /**
         * Retorna o nome digitado
         */
        String getName();

        /**
         * Retorna o email digitado
         */
        String getEmail();

        /**
         * Retorna a senha digitada
         */
        String getPassword();

        /**
         * Retorna a senha de confirmação digitada
         */
        String getPasswordConfirmation();

        /**
         * Exibe uma mensagem de erro
         */
        void showMessage(String error);

        /**
         * Desativa o botão de registrar
         */
        void disableBtnRegister();

        /**
         * Ativa o botão de registrar
         */
        void enableBtnRegister();

        /**
         * Exibe a activity de login
         */
        void showLoginActivity();
    }

    interface Presenter {


    }

    interface Interactor {

        /**
         * Registra um usuário
         */
        void doRegister(RegisterPayload registerPayload, ObserverBase<ErrorProxy> observerBase);

    }
}
