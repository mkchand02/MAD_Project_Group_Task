package com.example.registration.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.registration.R;
import java.util.List;

public class TransactionRVAdaptor extends RecyclerView.Adapter<TransactionRVAdaptor.ViewHolder>{

    @NonNull
    private List<Transaction> transactions;
    private Context context;

    //THIS IS THE CONSTRUCTOR USED TO INITIALIZE THE VARIABLES
    public TransactionRVAdaptor(List<Transaction> transactions, Context context) {
        this.transactions = transactions;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tid, tstatus, tFromUser, transTime, transDate, transCreditsTransfer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tid = itemView.findViewById(R.id.tid);
            tstatus = itemView.findViewById(R.id.tstatus);
            tFromUser = itemView.findViewById(R.id.trans_fromorto_user);
            transTime = itemView.findViewById(R.id.trans_time);
            transDate = itemView.findViewById(R.id.trans_date);
            transCreditsTransfer = itemView.findViewById(R.id.trans_credits);
        }
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transaction_list, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionRVAdaptor.ViewHolder viewholder, int i) {
        Transaction transactions = this.transactions.get(i);
        viewholder.tid.setText("Transaction ID:"+transactions.getId());
        viewholder.tstatus.setText("Status:"+((transactions.isStatus()==true)?"SENT":"RECEIVE"));
        viewholder.tFromUser.setText(((transactions.isStatus()==true)?"Sent To User:\n":"Received From User:\n")+transactions.getFromUser());
        viewholder.transTime.setText("Time:" + transactions.getTime());
        viewholder.transDate.setText("Date:" + transactions.getDate());
        viewholder.transCreditsTransfer.setText("Credit Transfer:" + transactions.getCreditsTransferred());
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }
}
