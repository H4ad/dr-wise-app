package wiseonesoft.com.br.drwise.repositorys;

import io.reactivex.Observable;

import retrofit2.http.Body;
import retrofit2.http.POST;

import wiseonesoft.com.br.drwise.interactors.payloads.LoginPayload;
import wiseonesoft.com.br.drwise.interactors.proxys.TokenProxy;

public interface AuthRepository {

    @POST("auth/login")
    Observable<TokenProxy> getToken(@Body LoginPayload loginPayload);

}
