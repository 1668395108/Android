package com.example.resolver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText editText_name,editText_update_name;
    private  String TAG="myLog";
    private TextView textView_showlinkman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_name=findViewById(R.id.editText_name);
        editText_update_name=findViewById(R.id.editText_update_name);
        textView_showlinkman=findViewById(R.id.textView_showlinkman);
    }


    public void insert(View view)
    {
        ContentResolver resolver=getContentResolver();
        Uri uri=Uri.parse("content://com.example.provider.mycontentprovider/person");
        ContentValues values=new ContentValues();
        values.put("name",editText_name.getText().toString());
        resolver.insert(uri,values);
        editText_name.setText("");
        Toast.makeText(this, "保存成功！", Toast.LENGTH_SHORT).show();
    }
    public void update(View view)
    {
        Log.d(TAG,"进入更新");
        ContentResolver resolver=getContentResolver();
        Uri uri=Uri.parse("content://com.example.provider.mycontentprovider/person");
        ContentValues values=new ContentValues();
        Log.d(TAG,"更新中...");
        values.put("name",editText_update_name.getText().toString());
        resolver.update(uri,values,null,null);
        Log.d(TAG,"更新完成！");
        Toast.makeText(this, "修改成功！", Toast.LENGTH_SHORT).show();
        editText_update_name.setText("");
    }
    public void query(View view)
    {
        ContentResolver resolver=getContentResolver();
        Uri uri=Uri.parse("content://com.example.provider.mycontentprovider/person/1");
        try (Cursor cursor = resolver.query(uri, null, null, null, null, null)) {
            assert cursor != null;
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Dialog dialog = new AlertDialog.Builder(this)
                        .setTitle("数据库信息")
                        .setMessage(cursor.getString(1)).create();
                dialog.show();
            }
        }
    }
    public void delete(View view)
    {
        Log.d(TAG,"进入删除！");
        ContentResolver resolver=getContentResolver();
        Uri uri=Uri.parse("content://com.example.provider.mycontentprovider/person");
        Log.d(TAG,"删除中...");
        resolver.delete(uri,null,null);
        Log.d(TAG,"删除完成！");
        Toast.makeText(this, "删除成功！", Toast.LENGTH_SHORT).show();
    }

    public void ShowLinkman(View view) {

        Toast.makeText(this, "联系人未查到！", Toast.LENGTH_SHORT).show();
//        ContentResolver cr = this.getContentResolver();
//        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
//        //Cursor cursor = getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, null, null, null);
//        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
//            int nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.
//                    DISPLAY_NAME);
//            String name = cursor.getString(nameIndex);   //取得联系人名字
//            //textView_showlinkman.append("name=" + name + ";");    //取得联系人ID
//            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));    //根据联系人ID查询对应的电话号码
//            Cursor phoneNumbers = cr.query(ContactsContract.CommonDataKinds.
//                    Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.
//                    Phone.CONTACT_ID + " = " + contactId, null, null);
//            //根据联系人ID查询对应的email
//            textView_showlinkman.append("name="+name+";"+"  phoneNumbers"+phoneNumbers);
//        }



        /*读取通讯录联系人*/
//        ContentResolver cr =this.getContentResolver();
//        //取得电话本中开始一项的光标，必须先moveToNext()
//        Log.d(TAG,"连接.....！");
//        Cursor cursor =cr.query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
//        Log.d(TAG,"连接成功！");
//        while(cursor.moveToNext()){
//            //取得联系人的名字索引
//            int nameIndex  =cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
//            String name = cursor.getString(nameIndex);
//            //取得联系人的ID索引值
//            String contactId =cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//            //查询该位联系人的电话号码，类似的可以查询email，phone
//            Cursor phone =cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
//                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID+ " = "
//                            + contactId, null, null);//第一个参数是确定查询电话号，第三个参数是查询具体某个人的过滤值
//            //一个人可能有几个号码
//            while(phone.moveToNext()){
//                String phoneNumber =phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                textView_showlinkman.append(name);
//                textView_showlinkman.append(phoneNumber);
//            }
//            phone.close();
        }

//        cursor.close();
/*读SIM卡内容*/
//        try{
//            Intent intent = new Intent();
//            intent.setData(Uri.parse("content://icc/adn"));
//            Uri uri = intent.getData();
//            ContentResolver cr = this.getContentResolver();
//            Cursor cursor =this.getContentResolver().query(uri, null, null, null, null);
//            if (cursor != null) {
//                while(cursor.moveToNext()){
//                    //取得联系人的名字索引
//                    int nameIndex  = cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
//                    String name = cursor.getString(nameIndex);
//                    //取得联系人的ID索引值
//                    String contactId =cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//                    //查询该位联系人的电话号码，类似的可以查询email，photo
//                    Cursor phone =cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
//                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID+ " = "
//                                    + contactId, null, null);//第一个参数是确定查询电话号，第三个参数是查询具体某个人的过滤值
//                    //一个人可能有几个号码
//                    while(phone.moveToNext()){
//                        String phoneNumber =phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        //自己的逻辑代码
//                    }
//                    textView_showlinkman.append(name+phone);
//                    phone.close();
//                }
//                cursor.close();
//            }
//        }catch(Exception e){}



}
