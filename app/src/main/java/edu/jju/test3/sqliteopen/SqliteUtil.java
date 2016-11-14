package edu.jju.test3.sqliteopen;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.jju.test3.util.TelSqlutil;


/**
 * Created by Administrator on 2016/11/11.
 */

public class SqliteUtil {
    private SQLiteDatabase db;
    private List<TelSqlutil> oList=new ArrayList<TelSqlutil>();

    public SqliteUtil(Context context,String sqlite_name){
        MySqlite open=new MySqlite(context,sqlite_name,null,1);
        this.db=open.getWritableDatabase();
    }

    public  void insert_(String name,String tel,String group){
        db.execSQL("insert into teltab(child_name,child_tel,group_name)values(?,?,?)",new String[]{name,tel,group});
    }

    public List<TelSqlutil> query_(String into){
        Cursor cursor=db.rawQuery("select * from teltab where child_name like ? or child_tel like ? ",new String[]{into});
        while (cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex("child_name"));
            String tel=cursor.getString(cursor.getColumnIndex("child_tel"));
            String group=cursor.getString(cursor.getColumnIndex("group_name"));
            TelSqlutil util=new TelSqlutil();
            util.setChild_name(name);
            util.setGroup_name(group);
            util.setChild_tel(tel);
            oList.add(util);

        }
        return oList;
    }
}
