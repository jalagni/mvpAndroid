package com.learning.homeActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learning.R;
import com.learning.databinding.LayoutHomeBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private ArrayList homeList = new ArrayList();

    public HomeAdapter() {

    }


    public void setContent(ArrayList arrayList) {
        this.homeList = arrayList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int vType) {

        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.layout_home, viewGroup);
        HomeViewHolder holder = new HomeViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int position) {
//        homeViewHolder.lHomeBinding

    }

    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public Object getItem(int position) {
        return homeList.get(position);
    }

}

class HomeViewHolder extends RecyclerView.ViewHolder {
    protected LayoutHomeBinding lHomeBinding;

    public HomeViewHolder(@NonNull View itemView) {

        super(itemView);
        lHomeBinding = DataBindingUtil.bind(itemView);
    }
}
