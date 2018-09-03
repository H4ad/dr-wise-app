package wiseonesoft.com.br.drwise.utils;

import com.google.gson.Gson;

import io.reactivex.Observer;

import retrofit2.HttpException;

import wiseonesoft.com.br.drwise.interactors.proxys.ErrorProxy;

public abstract class ObserverBase<T> implements Observer<T> {

    private static final String DEFAULT_ERROR_MESSAGE = "Ocorreu um erro imprevisto";

    private ErrorProxy getErrorProxy(HttpException httpException){
        try {
            return new Gson().fromJson(httpException.response().errorBody().string(), ErrorProxy.class);
        }catch (Throwable ex){
            return new ErrorProxy(DEFAULT_ERROR_MESSAGE);
        }
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof HttpException)
            onCustomError(getErrorProxy((HttpException) e));
    }

    public abstract void onCustomError(ErrorProxy errorProxy);
}
