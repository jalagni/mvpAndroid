package com.learning.network;

import retrofit2.Retrofit;

public class HttpService {

    private Retrofit retrofit;

    private HttpService() {
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static class Builder {

        private HttpService httpService;

        public Builder() {
            httpService = new HttpService();
        }

        public Builder setRetrofit(Retrofit retrofit) {
            httpService.retrofit = retrofit;
            return this;
        }


        public HttpService build() {
            return httpService;
        }

    }
}
