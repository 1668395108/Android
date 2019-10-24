package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeixinAdapter extends ArrayAdapter<WeixinActivity> {
    private int resourceId;
    public WeixinAdapter(@NonNull Context context, int resource, @NonNull List<WeixinActivity> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }
    @Override
    public View getView(int p, View view, ViewGroup parent){
        WeixinActivity WeixinActivity=getItem(p);
        View view1= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView imageView=view1.findViewById(R.id.image);
        TextView textView=view1.findViewById(R.id.title);
        TextView textView1=view1.findViewById(R.id.title1);
        imageView.setImageResource(WeixinActivity.getImageId());
        textView.setText(WeixinActivity.getName());
        textView1.setText(WeixinActivity.getQuotes());
        return view1;
    }
}
//public class WeixinAdapter extends RecyclerView.Adapter<WeixinAdapter.ViewHolder>{
//    private  List<WeixinActivity> weixin;
//    static class ViewHolder extends RecyclerView.ViewHolder{
//        View weixinView;
//        ImageView imageView;
//        TextView textView1,textView;
//        public ViewHolder(View v){
//            super(v);
//            weixinView=v;
//            imageView=v.findViewById(R.id.image);
//            textView=v.findViewById(R.id.title);
//            textView1=v.findViewById(R.id.title1);
//        }
//    }
//    public WeixinAdapter(List<WeixinActivity> weixinList){
//        weixin=weixinList;
//    }
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.weixin,parent,false);
//        final ViewHolder holder=new ViewHolder(view);
//        holder.weixinView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                int position=holder.getAdapterPosition();
//                WeixinActivity w=weixin.get(position);
//                Toast.makeText(view.getContext(),"点击了"+w.getName(),Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(view.getContext(),ChatActivity.class);
//
//            }
//        });
//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Intent intent = new Intent(WeixinAdapter.this, ChatActivity.class);
//                int position=holder.getAdapterPosition();
//                WeixinActivity w=weixin.get(position);
//                Toast.makeText(view.getContext(),"点击了"+w.getName(),Toast.LENGTH_SHORT).show();
//            }
//        });
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        WeixinActivity w=weixin.get(position);
//        holder.imageView.setImageResource(w.getImageId());
//        holder.textView.setText(w.getName());
//        holder.textView1.setText(w.getQuotes());
//    }
//
//    @Override
//    public int getItemCount() {
//        return weixin.size();
//    }
//
//
//}