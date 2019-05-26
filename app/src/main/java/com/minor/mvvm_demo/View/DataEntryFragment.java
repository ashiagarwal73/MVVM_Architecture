package com.minor.mvvm_demo.View;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.minor.mvvm_demo.R;
import com.minor.mvvm_demo.model.UserModel;
import com.minor.mvvm_demo.viewmodel.MainActivityViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataEntryFragment extends Fragment {

    MainActivityViewModel mainActivityViewModel;
    public DataEntryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_data_entry, container, false);
        final EditText nameEditText,emailEditText,phoneEditText;
        Button postButton;
        nameEditText=view.findViewById(R.id.name_edit_text);
        emailEditText=view.findViewById(R.id.email_edit_text);
        phoneEditText=view.findViewById(R.id.phoneNumber_edit_text);
        postButton=view.findViewById(R.id.post_button);
        mainActivityViewModel= ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel user=new UserModel();
                user.setName(nameEditText.getText().toString());
                user.setEmail(emailEditText.getText().toString());
                user.setPhoneNumber(phoneEditText.getText().toString());
                mainActivityViewModel.addUsers(user);
            }
        });
        return view;
    }

}
