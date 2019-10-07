package com.example.words;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.Switch;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WordsFragment extends Fragment {
    private WordViewModel wordViewModel;
    private MyAdapter myAdapterdefault,myAdapterCard;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private LiveData<List<Word>> filterword;
    private static final String VIEW_TEPY = "view_type_shp";
    private static final String IS_USING_CARD_VIEW="is_ueing_card_view" ;

    public WordsFragment() {
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_words, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wordViewModel= ViewModelProviders.of(requireActivity()).get(WordViewModel.class);  //获取ViewModel对象
        recyclerView=requireActivity().findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        myAdapterdefault=new MyAdapter(false,wordViewModel);
        myAdapterCard=new MyAdapter(true,wordViewModel);

        SharedPreferences shp=requireActivity().getSharedPreferences(VIEW_TEPY,Context.MODE_PRIVATE);//数据存储
        boolean viewtype=shp.getBoolean(IS_USING_CARD_VIEW,false);
        SharedPreferences.Editor editor=shp.edit();
        if(viewtype){
            recyclerView.setAdapter(myAdapterdefault);
           // editor.putBoolean(IS_USING_CARD_VIEW,false);
        }else {
            recyclerView.setAdapter(myAdapterCard);
           // editor.putBoolean(IS_USING_CARD_VIEW,true);
        }
        //editor.apply();
       // recyclerView.setAdapter(myAdapterdefault);
        filterword=wordViewModel.getAllWordLife();
        filterword.observe(requireActivity(), new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                int temp=myAdapterdefault.getItemCount();
                myAdapterdefault.setAllWord(words);
                myAdapterCard.setAllWord(words);
                if(temp!=words.size()){
                    myAdapterdefault.notifyDataSetChanged();
                    myAdapterCard.notifyDataSetChanged();
                }
            }
        });
        floatingActionButton=requireActivity().findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller= Navigation.findNavController(view);
                controller.navigate(R.id.action_wordsFragment_to_addFragment);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu,menu);
        SearchView searchView= (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setMaxWidth(700);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
               // Log.d("myLog","onQueryTextChange"+s);
                String patten=s.trim();
                filterword.removeObservers(requireActivity());
                filterword=wordViewModel.findWordWithPatten(patten);
                filterword.observe(requireActivity(), new Observer<List<Word>>() {
                    @Override
                    public void onChanged(List<Word> words) {
                        int temp=myAdapterdefault.getItemCount();
                        myAdapterdefault.setAllWord(words);
                        myAdapterCard.setAllWord(words);
                        if(temp!=words.size()){
                            myAdapterdefault.notifyDataSetChanged();
                            myAdapterCard.notifyDataSetChanged();
                        }
                    }
                });
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.clearData:
                AlertDialog.Builder builder=new AlertDialog.Builder(requireActivity());
                builder.setTitle("清空数据");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        wordViewModel.deleteallWord();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.create();
                builder.show();break;
            case R.id.switchView:
                SharedPreferences shp=requireActivity().getSharedPreferences(VIEW_TEPY,Context.MODE_PRIVATE);
                boolean viewtype=shp.getBoolean(IS_USING_CARD_VIEW,false);
                SharedPreferences.Editor editor=shp.edit();
                if(viewtype){
                    recyclerView.setAdapter(myAdapterdefault);
                    editor.putBoolean(IS_USING_CARD_VIEW,false);
                }else {
                    recyclerView.setAdapter(myAdapterCard);
                    editor.putBoolean(IS_USING_CARD_VIEW,true);
                }
                editor.apply();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
