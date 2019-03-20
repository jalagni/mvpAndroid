package com.learning.mainApp;

import android.app.Application;

import com.learning.BuildConfig;
import com.learning.dSupport.AppComponent;
import com.learning.dSupport.AppContext;
import com.learning.dSupport.DaggerAppComponent;
import com.learning.network.HttpService;
import com.learning.store.AppStore;

import javax.inject.Inject;

import retrofit2.Retrofit;
import timber.log.Timber;

public class MainApp extends Application {

    private AppComponent appComponent;

    @Inject
    HttpService httpService;

    @Inject
    Retrofit rService;

    @Override
    public void onCreate() {

        super.onCreate();
        initApplication();
    }

    private void initApplication() {

        AppStore.createInstance(getApplicationContext());

        if (!BuildConfig.DEBUG)
            return;

        Timber.plant(new Timber.DebugTree());


    }


    public AppComponent getAppComponent() {

        if (appComponent != null)
            return appComponent;


        appComponent = DaggerAppComponent.builder()
                .appContext(new AppContext(getApplicationContext()))
                .build();

        appComponent.inject(MainApp.this);

        Timber.e("H Service: " + httpService);
        return appComponent;

    }

}
