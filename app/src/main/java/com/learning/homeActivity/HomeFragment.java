package com.learning.homeActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.learning.R;
import com.learning.appCore.BaseFragment;
import com.learning.dataModel.TestModel;
import com.learning.databinding.FragmentHomeBinding;
import com.learning.store.AppStore;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import timber.log.Timber;

public class HomeFragment extends BaseFragment
        implements HomePresenterImpl.HomePresenter {


    private FragmentHomeBinding layoutHomeBinding;

    @Inject
    HomePresenterImpl hPresenter;


    public static HomeFragment newInstance() {
        HomeFragment hFragment = new HomeFragment();
        return hFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getMainApp().getAppComponent().setHomeComponent().inject(this);

        AppStore.getInstance().setToken("12345");

        hPresenter.attachView(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, null);
        layoutHomeBinding = DataBindingUtil.bind(view);
        return layoutHomeBinding.getRoot();

    }

    @Override
    public void showLoader(boolean canShow) {
        if (canShow) {
            aLoader.showLoader();
            return;
        }


        aLoader.hideLoader();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(bActivity, msg, Toast.LENGTH_SHORT);
    }

    @Override
    protected void onViewInitialized() {
        layoutHomeBinding.btnAction.setOnClickListener((view) -> {

            String sValue =  AppStore.getInstance().getToken();
            Timber.e("Value: "+sValue);
            hPresenter.getUserList();
        });
    }

    @Override
    public void loadHomeContent(TestModel tModel) {
        layoutHomeBinding.iText.setText(tModel.getUser());
        layoutHomeBinding.iText.setVisibility(View.VISIBLE);
        showMessage("Loaded");
    }
}
