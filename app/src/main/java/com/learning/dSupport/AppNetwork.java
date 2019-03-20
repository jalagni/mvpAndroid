package com.learning.dSupport;


import com.learning.BuildConfig;
import com.learning.network.ApiService;
import com.learning.network.HttpConst;
import com.learning.network.HttpService;
import com.learning.network.RequestInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class AppNetwork {

    @Provides
    public Retrofit getRetrofit(OkHttpClient client) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConst.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }


    @Provides
    public OkHttpClient getHttpClient(RequestInterceptor rInterceptor) {
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        httpBuilder.addInterceptor(rInterceptor);

        if (BuildConfig.DEBUG) {
            Timber.e("Adding Looger...");
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpBuilder.addInterceptor(logging);
        }

        return httpBuilder.build();

    }

    @Singleton
    @Provides
    public HttpService getHttpService(Retrofit retrofit) {

        HttpService.Builder httpBuilder = new HttpService.Builder();
        httpBuilder.setRetrofit(retrofit);
        return httpBuilder.build();

    }

    @Provides
    public ApiService getApiService(HttpService hService) {
        ApiService aService = new ApiService(hService);
        return aService;
    }


    @Provides
    public RequestInterceptor getRequestIntercept() {
        return new RequestInterceptor();
    }

}
