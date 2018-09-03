package wiseonesoft.com.br.drwise.interactors.payloads;

public class RegisterPayload {

    String name;

    String email;

    String password;

    String password_confirmation;

    public RegisterPayload(String name, String email, String password, String password_confirmation) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }
}
