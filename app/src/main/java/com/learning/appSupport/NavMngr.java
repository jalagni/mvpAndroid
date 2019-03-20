package com.learning.appSupport;


import com.learning.R;
import com.learning.appCore.BaseActivity;
import com.learning.appCore.BaseFragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import timber.log.Timber;

public class NavMngr {

    private static NavMngr navMngr;

    public static NavMngr getInstance() {
        if (navMngr == null) {
            navMngr = new NavMngr();
        }

        return navMngr;
    }

    private NavMngr() {
    }

    private BaseActivity baseActivity;

    public void registerActivity(BaseActivity activity) {
        this.baseActivity = activity;
    }

    public void pushFragment(BaseFragment bFragment) {

        if (baseActivity == null) {
            throw new RuntimeException("No Activity registerd");
        }


        FragmentTransaction ft = baseActivity.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.mainContainer, bFragment, bFragment.getClass().toString());
        ft.addToBackStack(bFragment.getClass().toString());

        ft.commit();

    }

    public boolean isLastFragment() {
        FragmentManager fManager = baseActivity.getSupportFragmentManager();


        Timber.e("Count :" + fManager.getBackStackEntryCount());
        return fManager.getBackStackEntryCount() == 1;

    }


    public void popFragment() {
        FragmentManager fManager = baseActivity.getSupportFragmentManager();
        fManager.popBackStack();
    }

}
