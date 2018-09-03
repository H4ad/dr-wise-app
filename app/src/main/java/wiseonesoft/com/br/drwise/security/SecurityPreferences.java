package wiseonesoft.com.br.drwise.security;

import android.content.Context;
import android.content.SharedPreferences;

import wiseonesoft.com.br.drwise.R;
import wiseonesoft.com.br.drwise.utils.ApplicationConstants;

public class SecurityPreferences {

    private final SharedPreferences mSharedPreferences;

    public SecurityPreferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(context.getString(R.string.shared_preferences_name), Context.MODE_PRIVATE);
    }

    /**
     * Armazena uma String por sua key
     * @param key Chave para salvar o valor
     * @param value Valor a ser armazenado
     */
    public void storeString(String key, String value){
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    /**
     * Obtém uma String armazenada pela sua key
     * @param key Chave do valor armazenado
     * @return Valor armazenado
     */
    public String getString(String key)
    {
        return this.mSharedPreferences.getString(key, ApplicationConstants.EMPTY_STRING);
    }
}
