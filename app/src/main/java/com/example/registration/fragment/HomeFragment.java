package com.example.registration.fragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.registration.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    static List<Users> userArray;
    static View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_home, container, false);
        recyclerView = view.findViewById(R.id.list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        userArray = new ArrayList<>();
        String gender, image;
        //THIS CREATES THE LIST OF USERS WHICH WILL BE ULTIMATELY REPACED BY THE DATABASE CALLBACKS
        for(int i=0 ; i<20 ; i++)
        {
            if(i%3==0)gender = "MALE";
            else if(i%3==2) gender = "FEMALE";
            else gender = "OTHER";
            Users listItem = new Users((i*100+(i+1)*10+(i+2)), "DummyUsername"+(i+1), "DummyUser"+(i+1), "DummyUser"+(i+1)+"@gmail.com", gender, "cadd", (i+1)*100);
            userArray.add(listItem);
        }
        adapter = new HomeAdapter(userArray,getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}