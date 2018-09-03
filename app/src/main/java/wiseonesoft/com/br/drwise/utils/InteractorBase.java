package wiseonesoft.com.br.drwise.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class InteractorBase {

    public Retrofit getRetrofit()
    {
        return new Retrofit.Builder()
                .baseUrl(getApiUrl())
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public OkHttpClient getOkHttpClient(){
        return new OkHttpClient.Builder().addInterceptor((chain) -> {
            Request.Builder request = chain.request()
                    .newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-Requested-With", "XMLHttpRequest");

            String token = getAuthenticationToken();
            if(!token.isEmpty())
                request.addHeader("Authorization", token);

            return chain.proceed(request.build());
        }).build();
    }

    public abstract String getAuthenticationToken();
    public abstract String getApiUrl();
}
