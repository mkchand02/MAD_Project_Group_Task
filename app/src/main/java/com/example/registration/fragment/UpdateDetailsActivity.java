package com.example.registration.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.registration.R;

public class UpdateDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll1, ll2, ll3, ll4, ll5;
    private Button updateName, updateUsername, updateEmail, updatePassword, updateMobileNumber, save;
    private EditText editName, editUsername, editEmail, editPassword, confirmPassword, editMobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);
        setTitle("UPDATE DETAILS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        ll3 = findViewById(R.id.ll3);
        ll4 = findViewById(R.id.ll4);
        ll5 = findViewById(R.id.ll5);
        updateName = findViewById(R.id.update_name);
        updateUsername = findViewById(R.id.update_username);
        updateEmail = findViewById(R.id.update_email);
        updatePassword = findViewById(R.id.update_password);
        updateMobileNumber = findViewById(R.id.update_mobile_number);
        save = findViewById(R.id.save);
        updateName.setOnClickListener(this);
        updateUsername.setOnClickListener(this);
        updateEmail.setOnClickListener(this);
        updatePassword.setOnClickListener(this);
        updateMobileNumber.setOnClickListener(this);
        save.setOnClickListener(this);

        editName = findViewById(R.id.edit_name);
        editUsername = findViewById(R.id.edit_username);
        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        confirmPassword = findViewById(R.id.confirm_password);
        editMobileNumber = findViewById(R.id.edit_mobile_number);


        Intent intent = getIntent();
        String email = intent.getStringExtra("email").toString();
        editEmail.setText(email);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.update_name:
                ll2.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                editName.setVisibility(View.VISIBLE);
                save.setVisibility(View.VISIBLE);
                break;

            case R.id.update_username:
                ll1.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                editUsername.setVisibility(View.VISIBLE);
                save.setVisibility(View.VISIBLE);
                break;

            case R.id.update_email:
                ll1.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                editEmail.setVisibility(View.VISIBLE);
                save.setVisibility(View.VISIBLE);
                break;

            case R.id.update_password:
                ll1.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                editPassword.setVisibility(View.VISIBLE);
                confirmPassword.setVisibility(View.VISIBLE);
                save.setVisibility(View.VISIBLE);
                break;

            case R.id.update_mobile_number:
                ll1.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                editMobileNumber.setVisibility(View.VISIBLE);
                save.setVisibility(View.VISIBLE);
                break;

            case R.id.save:
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll3.setVisibility(View.VISIBLE);
                ll4.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                editName.setVisibility(View.GONE);
                editUsername.setVisibility(View.GONE);
                editEmail.setVisibility(View.GONE);
                editPassword.setVisibility(View.GONE);
                confirmPassword.setVisibility(View.GONE);
                editMobileNumber.setVisibility(View.GONE);
                save.setVisibility(View.GONE);
        }
    }
}
