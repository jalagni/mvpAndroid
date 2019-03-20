package com.learning.network;


import com.learning.dataModel.ResponseModel;
import com.learning.dataModel.TestModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public class ApiService {
    private HttpService httpService;
    private ApiStructure apiStructure;

    public ApiService(HttpService hService) {
        this.httpService = hService;
        apiStructure = httpService.getRetrofit().create(ApiStructure.class);
    }

    public Observable getUserList() {
        Call callRequest = apiStructure.loginUserToken();
        return createRequest(callRequest, HttpConst.Request.TEST_REQUEST);
    }


    private Observable<ResponseModel> createRequest(Call<ResponseModel> call, HttpConst.Request rType) {

        RxSubscriber rxSubscriber = new RxSubscriber(call, rType);
        Observable observable = Observable.create(rxSubscriber)
                .doOnError(throwable -> onRequestFinish())
                .doOnComplete(() -> onRequestFinish())
                .doOnSubscribe(disposable -> onRequestStart());

        return observable;

    }


    private void onRequestStart() {

    }


    private void onRequestFinish() {

    }

    interface ApiStructure {
        @GET("5c8b5b95360000930e8f8021")
        Call<TestModel> loginUserToken();

    }
}
