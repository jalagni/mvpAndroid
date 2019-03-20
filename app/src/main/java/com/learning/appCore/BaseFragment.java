package com.learning.appCore;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.learning.appSupport.AppLoader;
import com.learning.mainApp.MainApp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class BaseFragment extends Fragment implements ViewContract {

    protected BaseActivity bActivity;
    protected AppLoader aLoader;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        bActivity = (BaseActivity) getActivity();

        aLoader = new AppLoader(bActivity);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewInitialized();
    }

    public MainApp getMainApp() {
        return (MainApp) bActivity.getApplication();
    }

    protected void onViewInitialized() {
    }

    protected boolean isBackHandled() {
        return false;
    }


    @Override
    public void showLoader(boolean canShow) {

    }

    @Override
    public void showMessage(String msg) {

    }


}
