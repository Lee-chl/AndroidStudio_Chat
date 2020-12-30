package com.example.misson1_lyj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt ;
    Button btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = (EditText)findViewById(R.id.edt);
        btn = (Button)findViewById(R.id.btn);
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
