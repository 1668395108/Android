package com.example.mls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int [] imageid=new int[]{
                R.mipmap.my1,R.mipmap.mht1,R.mipmap.lqd1,R.mipmap.lyh1,R.mipmap.dl1,R.mipmap.lj1,R.mipmap.ljc1,R.mipmap.lzj1,R.mipmap.wjl1,R.mipmap.dmz1,R.mipmap.zzh,
        };
        String[] title=new String[]{ "马云","马化腾","刘强东","李彦宏","丁磊","雷军","李嘉诚","李兆基","王健林","董明珠","渣渣灰"};
        String[] title1=new String[]{ "只有在朦胧黯淡时才念及灯火光亮","只有在冰天雪地时才怀念阳光温暖","只有在已然放手后才始知那是真爱","只有在身处低谷时才遥想过去峥嵘","只有在乡愁涌动时才痛恨旅途遥远","只有在让她走之后才始知那是真爱","你就让她走吧",
                "酒杯已空，醉然疑视。","希望有一天，你能让梦持续","但是梦想来的太慢，走得太快。","闭上双眼，整个脑海都是你。"};
        List<Map<String,Object>> listitem=new ArrayList<Map<String, Object>>();
        for(int i=0;i<imageid.length;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("image",imageid[i]);
            map.put("name",title[i]);
            map.put("name1",title1[i]);
            listitem.add(map);
        }
        SimpleAdapter adapter=new SimpleAdapter(this,listitem,R.layout.main,new String[]{"name","image","name1"},
                new int[]{R.id.title,R.id.image,R.id.title1});
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map=(Map<String,Object> )parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,map.get("name").toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
