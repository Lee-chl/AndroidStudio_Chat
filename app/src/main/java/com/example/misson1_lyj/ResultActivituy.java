package com.example.misson1_lyj;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivituy extends AppCompatActivity implements View.OnClickListener {
    EditText edt ;
    private DBHelper db;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        db = new DBHelper(this);

        TextView tex =(TextView)findViewById(R.id.tex);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select reply from tb_textd order by _id "
                ,null);

        while (cursor.moveToNext()){
            tex.setText(cursor.getString(0));
        }
        db.close();




    }

    @Override
    public void onClick(View v) {
        String reply = edt.getText().toString();

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into tb_textd(reply) values(?)", new String[] {reply});
        db.close();


        Intent intent = new Intent(this, ResultActivituy.class );
        startActivity(intent);

    }
}
