package com.example.words;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Word> allWord=new ArrayList<>();
    private boolean useCardView;
    private WordViewModel wordViewModel;

     MyAdapter(boolean useCardView,WordViewModel wordViewModel) {
        this.useCardView = useCardView;
        this.wordViewModel=wordViewModel;
    }

     void setAllWord(List<Word> allWord) {
        this.allWord = allWord;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {   //管理cell_nomall文件中的TextView
        TextView textView_number,textView_English,textView_Chinses;
        Switch aSwitchChineseInvisible;
         MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_number=itemView.findViewById(R.id.textView_number);
            textView_English=itemView.findViewById(R.id.textView_English);
            textView_Chinses=itemView.findViewById(R.id.textView_Chiese);
            aSwitchChineseInvisible=itemView.findViewById(R.id.switchchinsesinvisible);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {   //创建ViewHolder时呼叫的
      //创建ViewHolder需要加载View
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View viewItem;
        if(useCardView)
        {
            viewItem=layoutInflater.inflate(R.layout.cell_card_2,parent,false);
        }else {
            viewItem=layoutInflater.inflate(R.layout.cell_normall_2,parent,false);
        }
        final MyViewHolder holder=new MyViewHolder(viewItem);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("https://m.youdao.com/dict?le=eng&q="+holder.textView_English.getText());
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.aSwitchChineseInvisible.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Word word= (Word) holder.itemView.getTag(R.id.word_for_view_holder);
                if(b){
                    holder.textView_Chinses.setVisibility(View.GONE);
                    word.setChineseInvisible(true);
                    wordViewModel.updateWord(word);
                }else {
                    holder.textView_Chinses.setVisibility(View.VISIBLE);
                    word.setChineseInvisible(false);
                    wordViewModel.updateWord(word);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {    //viewholder与RecycleView绑定时呼叫

        final Word word=allWord.get(position);
        holder.itemView.setTag(R.id.word_for_view_holder,word);
        holder.textView_number.setText(String.valueOf(position+1));
        holder.textView_English.setText(word.getWord());
        holder.textView_Chinses.setText(word.getChineseMeaning());
        if(word.isChineseInvisible()){
            holder.textView_Chinses.setVisibility(View.GONE);
            holder.aSwitchChineseInvisible.setChecked(true);
        }else {
            holder.textView_Chinses.setVisibility(View.VISIBLE);
            holder.aSwitchChineseInvisible.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {    //返回数据个数
        return allWord.size();
    }
}
