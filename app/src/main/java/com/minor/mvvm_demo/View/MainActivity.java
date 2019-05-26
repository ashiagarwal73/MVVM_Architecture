package com.minor.mvvm_demo.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.minor.mvvm_demo.R;
import com.minor.mvvm_demo.model.UserModel;
import com.minor.mvvm_demo.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataEntryFragment dataEntryFragment=new DataEntryFragment();
        DataViewFragment dataViewFragment=new DataViewFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_data_entry,dataEntryFragment);
        fragmentTransaction.replace(R.id.fragment_data_view,dataViewFragment);
        fragmentTransaction.commit();
    }
}
