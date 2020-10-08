package com.akbarprojec.bindingviewjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.akbarprojec.bindingviewjava.databinding.ActivityFragmentWithDataBindingBinding;

public class FragmentWithDataBinding extends AppCompatActivity {

    ActivityFragmentWithDataBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFragmentWithDataBindingBinding binding = ActivityFragmentWithDataBindingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new FragmenTestBinding()).commit();

    }


}