package com.example.words;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    private Button buttonsubmit;
    private EditText editTextEnglish,editTextChinese;
    private WordViewModel wordViewModel;


    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity=requireActivity();
        wordViewModel= ViewModelProviders.of(activity).get(WordViewModel.class);  //获取数据库操作  ViewModel作用于整个acivity
        buttonsubmit=activity.findViewById(R.id.buttonsubmit);
        editTextChinese=activity.findViewById(R.id.editTextChinese);
        editTextEnglish=activity.findViewById(R.id.editTextEnglish);
        buttonsubmit.setEnabled(false);   //没有输入键盘不可用
        editTextEnglish.requestFocus();  //获取焦点
        InputMethodManager imm= (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);  //调用键盘
        imm.showSoftInput(editTextEnglish,0);   //显示键盘
        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String english=editTextEnglish.getText().toString().trim();//清除空格
                String chinese=editTextChinese.getText().toString().trim();
                buttonsubmit.setEnabled(!english.isEmpty()&&!chinese.isEmpty());//检查编辑框是否有输入

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        editTextEnglish.addTextChangedListener(textWatcher);
        editTextChinese.addTextChangedListener(textWatcher);
        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String english=editTextEnglish.getText().toString().trim();//清除空格
                String chinese=editTextChinese.getText().toString().trim();
                Word word=new Word(english,chinese);
                wordViewModel.insertWord(word);
                NavController controller= Navigation.findNavController(view);  //定义导航返回页面
                controller.navigateUp();
                InputMethodManager imm= (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(),0);//隐藏键盘
            }
        });
    }
}
