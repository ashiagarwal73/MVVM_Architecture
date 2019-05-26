package com.minor.mvvm_demo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.minor.mvvm_demo.model.UserModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<UserModel>> users=new MutableLiveData<>();
    public LiveData<List<UserModel>> getUsers() {
        return users;
    }
    public void addUsers(UserModel userModel){
        List<UserModel> userModels=users.getValue();
        if(userModels==null) {
            userModels=new ArrayList<>();
            userModels.add(userModel);
        }
        else {
            userModels.add(userModel);
        }
        users.setValue(userModels);
    }
}
