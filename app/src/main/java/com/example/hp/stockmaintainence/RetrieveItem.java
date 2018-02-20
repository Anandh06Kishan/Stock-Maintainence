package com.example.hp.stockmaintainence;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RetrieveItem extends AppCompatActivity {
    EditText id;
    SQLiteDatabase db;
    Button ret;
    Cursor c;
    final Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_item);
        id=(EditText)findViewById(R.id.editTextret);
        ret=(Button)findViewById(R.id.buttonret);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=id.getText().toString();

                db=openOrCreateDatabase("ashok.db",MODE_PRIVATE,null);
                c=db.rawQuery("select * from stock where (id="+s1+")",null);

                if(c.getCount()==0)
                    Toast.makeText(getApplicationContext(),"Not found",Toast.LENGTH_SHORT).show();


                while(c.moveToNext()) {
                    String id = c.getString(0);
                    String name = c.getString(1);
                    String cost = c.getString(2);
                    String quantity = c.getString(3);
                    System.out.println(id);
                    //Toast.makeText(getApplicationContext(), "Id:" + id + " Name:" + name + " Cost:" + cost + " Quantity:" + quantity + "", Toast.LENGTH_LONG).show();
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                    builder1.setMessage("Id:" + id + "| Name:" + name + "| Cost:" + cost + "| Quantity:" + quantity );
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Go back to mainpage",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent add=new Intent(RetrieveItem.this,MainActivity.class);
                                    startActivity(add);
                                }
                            });

                    builder1.setNegativeButton(
                            "Search Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }


                c.close();
                db.close();
                }

        });
    }
}
