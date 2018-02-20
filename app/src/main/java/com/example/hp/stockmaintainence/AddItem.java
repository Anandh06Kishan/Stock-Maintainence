package com.example.hp.stockmaintainence;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItem extends AppCompatActivity {

    EditText id,name,cost,quantity;
    Button submit;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        id=(EditText)findViewById(R.id.editText);
        name=(EditText)findViewById(R.id.editText2);
        cost=(EditText)findViewById(R.id.editText3);
        quantity=(EditText)findViewById(R.id.editText4);
        submit=(Button)findViewById(R.id.buttonsub);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=id.getText().toString();
                String s2=name.getText().toString();
                String s3=cost.getText().toString();
                String s4=quantity.getText().toString();
                db=openOrCreateDatabase("ashok.db",MODE_PRIVATE,null);
                db.execSQL("insert into stock values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
                Toast.makeText(getApplicationContext(),"Inserted", Toast.LENGTH_LONG).show();
                db.close();
            }
        });
    }
}
