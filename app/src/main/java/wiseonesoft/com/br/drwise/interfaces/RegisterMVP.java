package wiseonesoft.com.br.drwise.interfaces;

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
        void showErrorMessage(String error);

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

    }
}
