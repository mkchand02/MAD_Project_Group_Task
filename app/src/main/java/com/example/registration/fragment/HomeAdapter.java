package com.example.registration.fragment;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.registration.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Viewholder> {

    @NonNull
    private List<Users> users;
    private Context context;

    //THIS IS THE CONSTRUCTOR USED TO INITIALIZE THE VARIABLES
    public HomeAdapter(List<Users> users, Context context) {
        this.users = users;
        this.context = context;
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;
        private CardView cardView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.card_view);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition()!=-1){
                        TextView tv = v.findViewById(R.id.textView);
                        String username = tv.getText().toString();
                        long id;
                        String name;
                        String email;
                        String gender;
                        //int credits;
                        String imageUrl;
                        for(int i=0; i<20; i++)
                            if(HomeFragment.userArray.get(i).getUsername().equalsIgnoreCase(username)){
                                id = HomeFragment.userArray.get(i).getId();
                                name = HomeFragment.userArray.get(i).getName();
                                email = HomeFragment.userArray.get(i).getEmail();
                                gender = HomeFragment.userArray.get(i).getGender();
                                //credits = HomeFragment.userArray.get(i).getCredits();
                                imageUrl = HomeFragment.userArray.get(i).getImageUrl();
                                Intent intent = new Intent();
                                intent.setClass(context, UserInfoActivity.class);
                                intent.putExtra("Username", username);
                                intent.putExtra("Id", id);
                                intent.putExtra("Name", name);
                                intent.putExtra("Email", email);
                                intent.putExtra("Gender", gender);
                                intent.putExtra("ImageUrl", imageUrl);
                                context.startActivity(intent);
                            }
                    }
                }
            });
        }
    }

    @NonNull
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        Users users = this.users.get(i);
        viewholder.textView.setText(users.getUsername());
        if(users.getGender().equalsIgnoreCase("MALE"))
            viewholder.imageView.setImageResource(R.drawable.customerm);
        else
            viewholder.imageView.setImageResource(R.drawable.customerf);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


}
