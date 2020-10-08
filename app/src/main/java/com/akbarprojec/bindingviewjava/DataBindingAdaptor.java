package com.akbarprojec.bindingviewjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akbarprojec.bindingviewjava.databinding.CardDataBindingBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class DataBindingAdaptor extends RecyclerView.Adapter<DataBindingAdaptor.MyAdaptor> {
    ArrayList<User> users;
    Context context;

    public DataBindingAdaptor(ArrayList<User> users, Context context) {
        this.users = users;
        this.context = context;
    }


    @NonNull
    @Override
    public DataBindingAdaptor.MyAdaptor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardDataBindingBinding bindingBinding = DataBindingUtil.inflate(inflater, R.layout.card_data_binding, parent, false);

        /* atau bisa juga seperti ini
          CardDataBindingBinding bindingBinding1 = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.card_data_binding,parent,false);
        */
        return new MyAdaptor(bindingBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull DataBindingAdaptor.MyAdaptor holder, int position) {
        User user = users.get(position);
        holder.cardDataBinding.setUser(user);
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyAdaptor extends RecyclerView.ViewHolder {
        /* tampa data binding dilaaaakukan seperti ini
            private TextView txtA,txtB,txtC,txtD;
         */
        TextView txtA;

        private CardDataBindingBinding cardDataBinding;
        public MyAdaptor(@NonNull CardDataBindingBinding itemView) {
            super(itemView.getRoot());

            /* tampa data binding dilaaaakukan seperti ini
                txtA=itemView.findViewByID(R.......)
            */
            this.cardDataBinding = itemView;
        }
    }


}
