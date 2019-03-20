package com.learning.network;

import com.learning.dataModel.ResponseModel;

import io.reactivex.Emitter;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RxSubscriber implements ObservableOnSubscribe, Callback<ResponseModel> {

    private HttpConst.Request rType;
    private Call<ResponseModel> callRequest;
    private Emitter emitter;

    public RxSubscriber(Call call, HttpConst.Request rType) {
        this.callRequest = call;
        this.rType = rType;
    }


    @Override
    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
        ResponseModel rModel = response.body();
        rModel.reqType = rType;

        emitter.onNext(rModel);
        emitter.onComplete();
    }

    @Override
    public void onFailure(Call<ResponseModel> call, Throwable t) {
        emitter.onError(t);
    }

    @Override
    public void subscribe(ObservableEmitter emitter) throws Exception {
        this.emitter = emitter;
        callRequest.enqueue(this);
    }
}
