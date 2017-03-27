package com.andromap33.mcms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class AddNewResident extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_resident);
    }

    public void add_resident(View view) {
        EditText editname = (EditText) findViewById(R.id.name);
        EditText editblock = (EditText) findViewById(R.id.block_no);
        EditText editroom = (EditText) findViewById(R.id.room_no);
        EditText editsection = (EditText) findViewById(R.id.section);
        EditText editmob = (EditText) findViewById(R.id.mob_no);
        EditText editroll = (EditText) findViewById(R.id.roll_no);

        String eName = editname.getText().toString() ;
        String eBlock = editblock.getText().toString() ;
        String eRoom = editroom.getText().toString() ;
        String eSection = editsection.getText().toString() ;
        String ePhone = editmob.getText().toString() ;
        String eRollNo = editroll.getText().toString() ;

        if(eName . length() == 0 || eBlock . length() == 0 || eRoom . length() == 0 || eSection . length() == 0 || ePhone . length() == 0 || eRollNo . length() == 0) {
            Toast . makeText(this , "Please fill all the fields ." , Toast . LENGTH_SHORT) . show() ;
        } else {
            ResidentDbHelper resDbHelper = new ResidentDbHelper(getApplicationContext());
            SQLiteDatabase mydb = resDbHelper.getWritableDatabase();

            // Creating a new map
            ContentValues values = new ContentValues();
            values.put(ResidentDBContract.ResidentEntry1.COLUMN_NAME_NAME, eName);
            values.put(ResidentDBContract.ResidentEntry1.COLUMN_NAME_BLOCK, eBlock);
            values.put(ResidentDBContract.ResidentEntry1.COLUMN_NAME_ROOM, eRoom);
            values.put(ResidentDBContract.ResidentEntry1.COLUMN_NAME_SECTION, eSection);
            values.put(ResidentDBContract.ResidentEntry1.COLUMN_NAME_PHONE, ePhone);
            values.put(ResidentDBContract.ResidentEntry1.COLUMN_NAME_ROLLNO, eRollNo);

            //Inserting a new row
            long newRowID = mydb.insert(
                    ResidentDBContract.ResidentEntry1.TABLE_NAME,
                   	ResidentDBContract.ResidentEntry1.COLUMN_NAME_NAME ,
                    values
            );
            Toast . makeText(this , "Resident added ." , Toast . LENGTH_SHORT) . show() ;
        	Intent back = new Intent(this , ResidentsList . class) ;
        	back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
            startActivity(back) ;
            finish();
        }
    }
}