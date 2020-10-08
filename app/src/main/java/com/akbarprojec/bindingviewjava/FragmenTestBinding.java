package com.akbarprojec.bindingviewjava;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akbarprojec.bindingviewjava.databinding.FragmenTestBindingBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmenTestBinding#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmenTestBinding extends Fragment {
    FragmenTestBindingBinding testBinding;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FragmenTestBinding() {
        // Required empty public constructor
    }

    public static FragmenTestBinding newInstance(String param1, String param2) {
        FragmenTestBinding fragment = new FragmenTestBinding();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //binding fragment
        testBinding = DataBindingUtil.inflate(inflater, R.layout.fragmen_test_binding, container, false);
        View view = testBinding.getRoot();
        return view;
    }
}