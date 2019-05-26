package com.minor.mvvm_demo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minor.mvvm_demo.R;
import com.minor.mvvm_demo.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UsersRecyclerViewAdapter extends RecyclerView.Adapter<UsersRecyclerViewAdapter.MyViewHolder> {

    List<UserModel> userModels;
    public UsersRecyclerViewAdapter(List<UserModel> userModels)
    {
        this.userModels=userModels;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,email,phoneNumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_text_view);
            email=itemView.findViewById(R.id.email_text_view);
            phoneNumber=itemView.findViewById(R.id.phoneNumber_text_view);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_view_item, viewGroup, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.name.setText(userModels.get(i).getName());
        viewHolder.email.setText(userModels.get(i).getEmail());
        viewHolder.phoneNumber.setText(userModels.get(i).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }
}
