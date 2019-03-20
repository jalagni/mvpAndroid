package com.learning.homeActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.learning.R;
import com.learning.appCore.BaseActivity;
import com.learning.appSupport.AppDialog;
import com.learning.appSupport.NavMngr;
import com.learning.databinding.ActivityMainBinding;

import androidx.databinding.DataBindingUtil;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding aBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        aBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        aBinding.btnAction.setOnClickListener((View view) -> {
            takeAction();
        });

        new Handler().post(() -> {
            NavMngr.getInstance().pushFragment(HomeFragment.newInstance());
        });

    }


    @Override
    public void onBackPressed() {
        if (!NavMngr.getInstance().isLastFragment()) {
            NavMngr.getInstance().popFragment();
            return;
        }

        AppDialog.getInstance().showConfirmDialog(this
                , R.string.app_name, R.string.confirmMessage,
                new AppDialog.DCallback() {
                    @Override
                    public void dialogCallback(int dStatus, int dType, Object object) {
                        MainActivity.this.finish();
                    }
                });

    }

    private void takeAction() {
        Timber.e("Click Action....");
        NavMngr.getInstance().pushFragment(HomeFragment.newInstance());

    }


}
