package com.com.viewmodel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;

import com.example.menu.R;
import com.example.menu.databinding.ViewmodelshpBinding;

public class ViewModelSHP extends AppCompatActivity {
    MyViewModel myViewModel;
    ViewmodelshpBinding binding;
    //ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewmodelshp);
       // myViewModel.context=getApplicationContext();
        binding= DataBindingUtil.setContentView(this,R.layout.viewmodelshp);
        myViewModel=ViewModelProviders.of(this,new  SavedStateVMFactory(this)).get(MyViewModel.class);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);

    }
}
