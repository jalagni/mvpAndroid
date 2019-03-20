package com.learning.dSupport;


import com.learning.mainApp.MainApp;
import com.learning.network.ApiService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppNetwork.class, AppContext.class})
public interface AppComponent {

    void inject(MainApp app);

    ApiService getApiService();

    HomeComponent setHomeComponent();

}
