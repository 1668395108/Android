package com.example.expandablistview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            //设置各分组的图片
            int[] logos = new int[] { R.drawable.zygxy1, R.drawable.bj,R.drawable.qh1};
            //设置各分组的显示文字
            private String[] generalsTypes = new String[] { "中原工学院", "北京大学", "清华大学"  };
            //子视图显示文字
            private String[][] generals = new String[][] {
                    { "丁磊", "董明珠", "雷军", "李嘉诚", "刘强东", "李彦宏" },
                    { "李彦宏","李兆基", "马化腾", "马云" }
                   ,{"王健林", "比尔盖茨", "渣渣灰"}};
            //子视图图片,对应每个人的图片
            public int[][] generallogos = new int[][] {
                    { R.drawable.dl1, R.drawable.dmz1,R.drawable.lj1, R.drawable.ljc1,R.drawable.lqd1 },
                    { R.drawable.lyh1, R.drawable.lzj1,R.drawable.mht1, R.drawable.my1 },
                    {R.drawable.wjl1,R.drawable.gc1, R.drawable.zzh}};
            //自己定义一个获得文字信息的方法
            TextView getTextView() {
                //定义布局参数
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(MainActivity.this); //创建TextView
                textView.setLayoutParams(lp);                    	//设置布局参数
                textView.setGravity(Gravity.CENTER_VERTICAL);  	//居中显示
                textView.setPadding(36, 0, 0, 0);                	//与边界的距离
                textView.setTextSize(16);                         	//设置文字大小
                textView.setTextColor(Color.BLACK);              	//设置文字颜色
                return textView;			}                  	//返回TextView组件
            //重写ExpandableListAdapter中的各个方法
            public int getGroupCount() {                	//取得分组的个数
                return generalsTypes.length;}
            public Object getGroup(int groupPosition) {  	//取得指定分组
                return generalsTypes[groupPosition];	}
            public long getGroupId(int groupPosition) {  	//取得指定分组的ID
                return groupPosition;	}
            public int getChildrenCount(int groupPosition) { //取得子项的个数
                return generals[groupPosition].length;	}
            public Object getChild(int groupPosition, int childPosition) {
                //取得指定子项
                return generals[groupPosition][childPosition];	}
            public long getChildId(int groupPosition, int childPosition) {
                //取得指定子项ID
                return childPosition;			}
            public boolean hasStableIds() {  //子项和分组的ID始终表示一个固定的组件对象
                return true;			}
            //覆写getGroupView方法
            public View getGroupView(int groupPosition, boolean isExpanded,
                                     View convertView, ViewGroup parent) {    //取得分组显示组件
                LinearLayout ll = new LinearLayout(MainActivity.this);
                //定义布局管理器
                ll.setOrientation(LinearLayout.HORIZONTAL);          //设置布局管理器的参数
                ImageView logo = new ImageView(MainActivity.this);
                //定义ImageView
                logo.setImageResource(logos[groupPosition]);//获得显示组图片
                logo.setPadding(20, 0, 0, 0);           	//设置边界
                ll.addView(logo);                        	//添加ImageView
                TextView textView = getTextView();     	//定义TextView组件
                textView.setTextColor(Color.BLACK);    	//文字颜色
                textView.setText(getGroup(groupPosition).toString());//设置显示文字
                ll.addView(textView);                		//添加TextView组件
                return ll;		}
            //覆写getChildView方法
            public View getChildView(int groupPosition, int childPosition,
                                     boolean isLastChild, View convertView, ViewGroup parent)
            {         //取得子项组件
                LinearLayout ll = new LinearLayout(MainActivity.this); //定义布局管理器
                ll.setOrientation(LinearLayout.HORIZONTAL);            		//设置布局管理器的参数
                ImageView generallogo=new ImageView(MainActivity.this);//定义ImageView
                //获得显示子项图片
                generallogo.setImageResource(generallogos[groupPosition]
                        [childPosition]);
                ll.addView(generallogo);             	//添加ImageView
                TextView textView = getTextView();   	//定义TextView组件
                textView.setText(getChild(groupPosition, childPosition).toString());
                //显示文字
                ll.addView(textView);                	//添加TextView组件
                return ll;			}
            public boolean isChildSelectable(int groupPosition,int childPosition) {
                return true ;}};                   		//判断指定的子选项是否被选中
        ExpandableListView expandableListView = (ExpandableListView) findViewById
                (R.id.list);          //获得ExpandableListView组件
        expandableListView.setAdapter(adapter); //获得数据
        //设置item单击事件的监听器
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v,int
                    groupPosition, int childPosition, long id) {   //单击该子项后的操作
                Toast.makeText(MainActivity.this,"您刚才单击了" +
                        adapter.getChild(groupPosition, childPosition),Toast.LENGTH_LONG).show();
                return false;}	});
    }
}
