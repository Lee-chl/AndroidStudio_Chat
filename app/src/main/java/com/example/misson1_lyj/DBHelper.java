package com.example.misson1_lyj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public DBHelper(Context context){
        super(context, "text_db", null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String textdbSQL = "create table tb_textd(" +
                "_id integer primary key autoincrement,"
                +  "reply)";

            db.execSQL(textdbSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_textd");
            onCreate(db);
        }

    }
}
