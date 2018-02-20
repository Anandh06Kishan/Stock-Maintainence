package com.example.hp.stockmaintainence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity {

    Button a,r,u,d,c;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c=(Button) findViewById(R.id.button5);
        a=(Button)findViewById(R.id.button1);
        r=(Button)findViewById(R.id.button2);
        u=(Button)findViewById(R.id.button3);
        d=(Button)findViewById(R.id.button4);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openOrCreateDatabase("ashok.db",MODE_PRIVATE,null);
                db.execSQL("create table if not exists stock(id varchar,name varchar,quantity varchar,price varchar);");
                Toast.makeText(getBaseContext(),"Stock is created!",Toast.LENGTH_LONG).show();
                db.close();
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add=new Intent(MainActivity.this,AddItem.class);
                startActivity(add);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ret = new Intent(MainActivity.this, RetrieveItem.class);
                startActivity(ret);
            }
        });
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upd=new Intent(MainActivity.this,UpdateItem.class);
                startActivity(upd);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent del=new Intent(MainActivity.this,DeleteItem.class);
                startActivity(del);
            }
        });
    }
}
