package com.example.registration.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.registration.R;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {

    private static final String TAG ="SplashScreenActivity";
    private static ArrayList<Users> arrayList;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_user_info);
        Intent intent= getIntent();
        String name=intent.getStringExtra("Name");
        setTitle(name);
        textView = findViewById(R.id.usr_name);
        textView.setText(name);
        name = intent.getStringExtra("Username");
        textView = findViewById(R.id.usr_username);
        textView.setText(name);
        long id = (long) intent.getLongExtra("Id", 0);
        textView = findViewById(R.id.usr_id);
        textView.setText(""+id);
        name = intent.getStringExtra("Email");
        textView = findViewById(R.id.usr_email);
        textView.setText(name);
        name = intent.getStringExtra("Gender");
        textView = findViewById(R.id.usr_gender);
        textView.setText(name);
        imageView = findViewById(R.id.usr_img);
        if (name.equalsIgnoreCase("MALE")) {
            imageView.setImageResource(R.drawable.customerm);
        }else
            imageView.setImageResource(R.drawable.customerf);
        name = intent.getStringExtra("ImageUrl");
        Log.d(TAG,"Intent String Passed");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
