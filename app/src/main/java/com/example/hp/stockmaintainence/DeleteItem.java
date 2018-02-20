package com.example.hp.stockmaintainence;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteItem extends AppCompatActivity {
    EditText id;
    SQLiteDatabase db;
    Button del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);
        id=(EditText)findViewById(R.id.editTextdel1);
        del=(Button)findViewById(R.id.buttondel);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=id.getText().toString();
                db=openOrCreateDatabase("ashok.db",MODE_PRIVATE,null);
                db.execSQL("delete from stock where (id="+s1+")");
                Toast.makeText(getBaseContext(),"Deleted!",Toast.LENGTH_LONG).show();

                db.close();
            }
        });
    }
}
