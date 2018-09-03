package wiseonesoft.com.br.drwise.repositorys;

import io.reactivex.Observable;

import retrofit2.http.Body;
import retrofit2.http.POST;

import wiseonesoft.com.br.drwise.interactors.payloads.LoginPayload;
import wiseonesoft.com.br.drwise.interactors.payloads.RegisterPayload;
import wiseonesoft.com.br.drwise.interactors.proxys.EmptyProxy;
import wiseonesoft.com.br.drwise.interactors.proxys.ErrorProxy;
import wiseonesoft.com.br.drwise.interactors.proxys.TokenProxy;

public interface AuthRepository {

    @POST("auth/login")
    Observable<TokenProxy> getToken(@Body LoginPayload loginPayload);

    @POST("auth/signup")
    Observable<EmptyProxy> doRegister(@Body RegisterPayload registerPayload);

}
