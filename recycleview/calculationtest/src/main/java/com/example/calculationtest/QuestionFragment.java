package com.example.calculationtest;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculationtest.databinding.FragmentQuestionBinding;

public class QuestionFragment extends Fragment {

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final MyViewModle myViewModle;
        myViewModle=ViewModelProviders.of(requireActivity(),new SavedStateVMFactory(requireActivity())).get(MyViewModle.class);
        myViewModle.generator();
        final FragmentQuestionBinding binding;
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_question,container,false);
        binding.setData(myViewModle);
        binding.setLifecycleOwner(requireActivity());
        final StringBuilder builder=new StringBuilder();
        View.OnClickListener listener=new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button1:
                        builder.append("1");break;
                    case R.id.button2:
                        builder.append("2");break;
                    case R.id.button3:
                        builder.append("3");break;
                    case R.id.button4:
                        builder.append("4");break;
                    case R.id.button5:
                        builder.append("5");break;
                    case R.id.button6:
                        builder.append("6");break;
                    case R.id.button7:
                        builder.append("7");break;
                    case R.id.button8:
                        builder.append("8");break;
                    case R.id.button9:
                        builder.append("9");break;
                    case R.id.button10:
                        builder.append("0");break;
                    case R.id.button11:
                        builder.setLength(0);break;
                }
                 if(builder.length()==0){
                     binding.textView9.setText(getString(R.string.input_indater));
                 }else {
                     binding.textView9.setText(builder.toString());
                 }
            }
        };
        binding.button1.setOnClickListener(listener);
        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
        binding.button4.setOnClickListener(listener);
        binding.button5.setOnClickListener(listener);
        binding.button6.setOnClickListener(listener);
        binding.button7.setOnClickListener(listener);
        binding.button8.setOnClickListener(listener);
        binding.button9.setOnClickListener(listener);
        binding.button10.setOnClickListener(listener);
        binding.button11.setOnClickListener(listener);

        binding.button12.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void onClick(View view) {
                if(builder.length()==0){
                    builder.append("-1");
                }
                if(Integer.valueOf(builder.toString()).intValue()==myViewModle.getAnswer().getValue()){
                    myViewModle.answerCorrect();
                    builder.setLength(0);
                    binding.textView9.setText(R.string.answer_corrent_message);
                    //builder.append(getString(R.string.answer_corrent_message));
                }else {
                    NavController controller= Navigation.findNavController(view);
                    if(myViewModle.win_flag){
                        controller.navigate(R.id.action_questionFragment_to_winFragment);
                        myViewModle.win_flag=false;
                        myViewModle.save();
                    }else {
                        controller.navigate(R.id.action_questionFragment_to_loseFragment);
                    }

                }
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

}
