package com.learning.dSupport;


import com.learning.homeActivity.HomeFragment;
import com.learning.homeActivity.HomePresenterImpl;

import dagger.Subcomponent;

@Subcomponent
public interface HomeComponent {
    void inject(HomeFragment hFragment);

    HomePresenterImpl getHomePresenter();

}
