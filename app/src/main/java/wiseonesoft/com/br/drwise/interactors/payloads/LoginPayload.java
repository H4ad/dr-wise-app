package wiseonesoft.com.br.drwise.interactors.payloads;

public class LoginPayload {

    String email;
    String password;

    public LoginPayload(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
