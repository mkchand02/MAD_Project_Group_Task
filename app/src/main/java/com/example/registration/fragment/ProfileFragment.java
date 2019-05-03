package com.example.registration.fragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import com.example.registration.LoginActivity;
import com.example.registration.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private TextView name;
    private Button buttonlogout;
    private Button buttonUpdate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, null);
        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user=firebaseAuth.getCurrentUser();
        textViewUserEmail=(TextView) view.findViewById(R.id.textViewUserEmail);
        name = view.findViewById(R.id.usr_name);
        buttonlogout=(Button) view.findViewById(R.id.buttonlogout);
        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(getActivity().getApplicationContext(), LoginActivity.class));
                getActivity().finish();
            }
        });

        if(firebaseAuth.getCurrentUser()==null)
        {
            getActivity().finish();
            Intent intent = new Intent();
            intent.setClass(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
        textViewUserEmail.setText(user.getEmail());
        name.setText(user.getEmail().substring(0, user.getEmail().lastIndexOf('@')));
        name = view.findViewById(R.id.usr_username);
        name.setText(user.getEmail().substring(0, user.getEmail().lastIndexOf('@')));

        buttonUpdate = view.findViewById(R.id.button_update);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), UpdateDetailsActivity.class);
                intent.putExtra("email", user.getEmail());
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
