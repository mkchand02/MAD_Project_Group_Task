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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TransactionFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    static List<Transaction> transArray;
    static View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_transaction, container, false);
        recyclerView = view.findViewById(R.id.trans_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        transArray = new ArrayList<>();
        Calendar calendar;
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");
        //THIS CREATES THE LIST OF USERS WHICH WILL BE ULTIMATELY REPACED BY THE DATABASE CALLBACKS
        for(int i=0 ; i<20 ; i++)
        {
            calendar = Calendar.getInstance();
            date = calendar.getTime();
            Transaction listItem = new Transaction((i%2==1)?true:false, (i%2==1)?"S"+i+i+i:"R"+i+i+i, "User"+(int)(3.14%(i+1)), dateFormat.format(date), dayFormat.format(date), (i+1)*100);
            transArray.add(listItem);
        }
        adapter = new TransactionRVAdaptor(transArray,getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}