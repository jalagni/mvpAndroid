package com.learning.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learning.R;
import com.learning.appCore.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SettingFragment extends BaseFragment {

    public static SettingFragment newInstance() {

        SettingFragment sFragment = new SettingFragment();
        return sFragment;

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, null);
        return view;
    }
}
