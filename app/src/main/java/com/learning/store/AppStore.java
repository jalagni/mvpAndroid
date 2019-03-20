package com.learning.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toolbar;

import timber.log.Timber;

public class AppStore {

    private static final String PREFS_NAME = "com.learn.test";
    private static final String TOKEN = "apptoken";

    private static AppStore aStore;

    public static void createInstance(Context context) {

        if(aStore != null){
            Timber.e("Store Already Registered");
            return;
        }

        aStore = new AppStore(context);
    }


    public static AppStore getInstance() {

        if (aStore == null) {
            throw new RuntimeException("AppStore not initialized");
        }

        return aStore;
    }

    private Context appContext;

    private AppStore(Context context) {
        this.appContext = context;
    }

    public void setToken(String token) {
        setValue(TOKEN,token);
    }

    public String getToken() {
        return getPreference().getString(TOKEN,null);
    }


    private SharedPreferences getPreference(){
        SharedPreferences sPref = appContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sPref;
    }

    private void setValue(String sKey, String sValue){

        SharedPreferences sPref = appContext.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sPref.edit();

        editor.putString(sKey, sValue);
        editor.apply();

    }

}
