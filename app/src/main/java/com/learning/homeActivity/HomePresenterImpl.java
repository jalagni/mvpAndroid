package com.learning.homeActivity;

import com.learning.appCore.BasePresenter;
import com.learning.appCore.ViewContract;
import com.learning.dataModel.ResponseModel;
import com.learning.dataModel.TestModel;
import com.learning.network.ApiService;
import com.learning.network.HttpConst;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class HomePresenterImpl extends BasePresenter<HomePresenterImpl.HomePresenter> {

    @Inject
    ApiService apiService;

    @Inject
    public HomePresenterImpl() {
    }


    public void getUserList() {
        Timber.e("Get User List");

        apiService.getUserList().subscribe(this);

    }

    @Override
    public void onNext(ResponseModel rModel) {
        Timber.e("++++++++++++++++++++++++++++++");

        if(rModel.reqType == HttpConst.Request.TEST_REQUEST) {
            getViewContract().loadHomeContent((TestModel) rModel);
        }
    }


    public interface HomePresenter extends ViewContract {
        void loadHomeContent(TestModel tModel);
    }

}


