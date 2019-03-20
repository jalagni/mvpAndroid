package com.learning;


import com.learning.homeActivity.HomePresenterImpl;
import com.learning.utils.AppUtils;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class HomePresenterTest {

    @Mock
    private HomePresenterImpl.HomePresenter hPresenter;

    @Test
    public void presenterContent() {

        HomePresenterImpl hImpl = new HomePresenterImpl();
        hImpl.attachView(hPresenter);

        hImpl.testUser();
        Mockito.verify(hPresenter).loadHomeContent();

    }

    @Test
    public void validateUtils() {

        boolean state = AppUtils.isValidString(" ddd");
        Assert.assertTrue(state);


    }


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


}
