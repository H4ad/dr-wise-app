package wiseonesoft.com.br.drwise.interactors.proxys;

import java.util.ArrayList;
import java.util.Map;

public class ErrorProxy {

    String message;
    Map<String, ArrayList<String>> errors;

    public ErrorProxy(String message) {
        this.message = message;
    }

    public Map<String, ArrayList<String>> getErrors() {
        return errors;
    }
    public String getMessage() {
        return message;
    }

}
