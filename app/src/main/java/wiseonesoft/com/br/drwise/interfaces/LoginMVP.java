package wiseonesoft.com.br.drwise.interfaces;

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
         * Exibe uma mensagem de erro ao usuário
         */
        void showErrorMessage(String error);

        /**
         * Exibe a activity para se registrar
         */
        void showRegisterActivity();
    }

    interface Presenter {

        void makeLogin();

    }

    interface Interactor {

    }
}
