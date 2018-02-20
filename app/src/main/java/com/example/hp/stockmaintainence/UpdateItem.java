package com.example.hp.stockmaintainence;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateItem extends AppCompatActivity {

    EditText id,name,cost,quantity;
    Button upd;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);
        id=(EditText)findViewById(R.id.editTextupd1);
        name=(EditText)findViewById(R.id.editTextupd2);
        cost=(EditText)findViewById(R.id.editTextupd3);
        quantity=(EditText)findViewById(R.id.editTextupd4);
        upd=(Button)findViewById(R.id.buttonupd);
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=id.getText().toString();
                String s2=name.getText().toString();
                String s3=quantity.getText().toString();
                String s4=cost.getText().toString();
                db=openOrCreateDatabase("ashok.db",MODE_PRIVATE,null);
                db.execSQL("update stock set name='"+s2+"',price='"+s3+"',quantity='"+s4+"' where (id='"+s1+"')");
                Toast.makeText(getApplicationContext(),"Updated!!",Toast.LENGTH_LONG).show();

                db.close();
            }
        });
    }
}
