package com.example.calculationtest;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculationtest.databinding.FragmentWinBinding;


public class WinFragment extends Fragment {


    public WinFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModle myViewModle= ViewModelProviders.of(requireActivity(),new SavedStateVMFactory(requireActivity())).get(MyViewModle.class);
        FragmentWinBinding binding;
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_win,container,false);
        binding.setData(myViewModle);
        binding.setLifecycleOwner(requireActivity());
        binding.button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_winFragment_to_titleFragment);
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

}
