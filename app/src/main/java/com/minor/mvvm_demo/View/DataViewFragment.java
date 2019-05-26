package com.minor.mvvm_demo.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minor.mvvm_demo.Adapter.UsersRecyclerViewAdapter;
import com.minor.mvvm_demo.R;
import com.minor.mvvm_demo.model.UserModel;
import com.minor.mvvm_demo.viewmodel.MainActivityViewModel;
import java.util.List;
import java.util.Objects;

public class DataViewFragment extends Fragment {
    UsersRecyclerViewAdapter usersRecyclerViewAdapter;
    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;
    public DataViewFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_data_view, container, false);
        recyclerView=view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mainActivityViewModel= ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MainActivityViewModel.class);
        mainActivityViewModel.getUsers().observe(getActivity(), new Observer<List<UserModel>>() {
            @Override
            public void onChanged(@Nullable List<UserModel> userModels) {
                if(usersRecyclerViewAdapter==null){
                usersRecyclerViewAdapter=new UsersRecyclerViewAdapter(userModels);
                recyclerView.setAdapter(usersRecyclerViewAdapter);
                }
                usersRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}
