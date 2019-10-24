package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<WeixinActivity> weixinlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initweixin();
//       // WeixinAdapter adapter=new WeixinAdapter(MainActivity.this,R.layout.weixin,weixinlist);
//        RecyclerView recyclerView=findViewById(R.id.recycle1);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);  //纵向排列
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);  //横向排列
//
//        //StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL); //瀑布流布局
//        recyclerView.setLayoutManager(layoutManager);
//        WeixinAdapter adapter=new WeixinAdapter(weixinlist);
//        recyclerView.setAdapter(adapter);

        WeixinAdapter adapter=new WeixinAdapter(MainActivity.this,R.layout.weixin,weixinlist);
        ListView listView=findViewById(R.id.recycle1);
        listView.setAdapter(adapter);
    }
    public  void initweixin() {
        for (int i = 0; i < 3; i++) {
            WeixinActivity my = new WeixinActivity("马云", R.mipmap.my1, "我对钱不感兴趣");
            weixinlist.add(my);
            WeixinActivity wjl = new WeixinActivity("王健林", R.mipmap.wjl1, "一无所有");
            weixinlist.add(wjl);
            WeixinActivity mht = new WeixinActivity("马化腾", R.mipmap.mht1, "曾梦想仗剑走天涯");
            weixinlist.add(mht);
            WeixinActivity zzh = new WeixinActivity("渣渣灰", R.mipmap.zzh, "看一看世界的繁华");
            weixinlist.add(zzh);
            WeixinActivity lqd = new WeixinActivity("刘强东", R.mipmap.lqd1, "年少的心总有些轻狂");
            weixinlist.add(lqd);
            WeixinActivity lyh = new WeixinActivity("李彦宏", R.mipmap.lyh1, "曾让你心疼的姑娘");
            weixinlist.add(lyh);
            WeixinActivity lzj = new WeixinActivity("李兆基", R.mipmap.lzj1, "如今已悄然无踪影");
            weixinlist.add(lzj);
            WeixinActivity dmz = new WeixinActivity("董明珠", R.mipmap.dmz1, "爱情总让你渴望又感到烦恼");
            weixinlist.add(dmz);
            WeixinActivity ljc = new WeixinActivity("李嘉诚", R.mipmap.ljc1, "每一次难过的时候");
            weixinlist.add(ljc);
            WeixinActivity lj = new WeixinActivity("雷军", R.mipmap.lj1, "如今你四海为家");
            weixinlist.add(lj);
            WeixinActivity dl = new WeixinActivity("丁磊", R.mipmap.dl1, "如今你四海为家");
            weixinlist.add(dl);
        }
    }
}
