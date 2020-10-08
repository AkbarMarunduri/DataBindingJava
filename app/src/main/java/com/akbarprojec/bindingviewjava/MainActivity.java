package com.akbarprojec.bindingviewjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;


import com.akbarprojec.bindingviewjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        /*cara laain untuk melakukan binding
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         */

        User[] users = new User[5];
        users[0] = new User("AAAA", "sad");
        users[1] = new User("BBBBB", "sad");
        users[2] = new User("CCCCCC", "sad");
        users[3] = new User("DDDDDDD", "sad");
        users[4] = new User("EEEEEEEE", "sad");


        ArrayList<User> userList=new ArrayList<>();
        for (int i = 0; i < users.length; i++) {
            userList.add(users[i]);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvBindingData.setLayoutManager(layoutManager);
        DataBindingAdaptor dataBindingAdaptor = new DataBindingAdaptor(userList, this);
        binding.rvBindingData.setAdapter(dataBindingAdaptor);

        //memasukkan data ke variabel user yang ada pada "activity_main.xml"
        User user = new User("akbar","12334");
        binding.setUser(user);

        binding.btFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentWithDataBinding.class);
                startActivity(intent);
            }
        });
    }
}
