package com.example.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MyContentProvider extends ContentProvider{
    private static final UriMatcher uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
    private static final int CODE=1;
    private static final int CODE_1=2;
    private  String TAG="myLog";
    private DBHelper dbHelper;
    static {
        uriMatcher.addURI("com.example.provider.mycontentprovider","/person",CODE);
        uriMatcher.addURI("com.example.provider.mycontentprovider","/person/#",CODE_1);
    }

    private Uri uri;

    public MyContentProvider() {
    }
    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        dbHelper=new DBHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        int code = uriMatcher.match(uri);
        Log.d(TAG,String.valueOf(code));
        if (code == CODE_1) {
            Cursor cursor = database.query("person", projection, selection, selectionArgs, null, null, null);
            return cursor;
        } else {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        int code1 = uriMatcher.match(uri);
        Log.d(TAG,String.valueOf(code1));
        if (code1 == CODE) {
            Long id=database.insert("person","肖森",values);
            Log.d(TAG,"插入成功！");
            uri=ContentUris.withAppendedId(uri,id);  //将数据于id绑定
            database.close();
            return uri;
        } else {
            database.close();
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        int code = uriMatcher.match(uri);
        Log.d(TAG,String.valueOf(code));
        int deleteCount=-1;
        if (code == CODE) {
            deleteCount=database.delete("person",null,null);
            Log.d(TAG,"删除成功！");
        } else {
            database.close();
            throw new UnsupportedOperationException("Not yet implemented");
        }
        database.close();
        return deleteCount;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        int code = uriMatcher.match(uri);
        Log.d(TAG,String.valueOf(code));
        int updateCount=-1;
        if (code == CODE) {
            updateCount=database.update("person",values,null,null);
            Log.d(TAG,"修改成功！");
        } else {
            database.close();
            throw new UnsupportedOperationException("Not yet implemented");
        }
        database.close();
        return updateCount;
    }


    @Override
    public String getType(Uri uri) {
        this.uri = uri;
        // TODO: Implement this to handle requests for the MIME type of the data

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
