package com.andromap33.mcms;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.database.Cursor;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResidentDetailedActivity extends AppCompatActivity {

    public String rollNO ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_resident);
    	Intent detailedIntent = this . getIntent() ;
        if(detailedIntent != null && detailedIntent . hasExtra(Intent . EXTRA_TEXT)) {
    		//String residentStr = detailedIntent . getStringExtra(Intent . EXTRA_TEXT) ;
    		//TextView detailedTextView = (TextView) findViewById(R.id.detailed_text_view) ;
    		//detailedTextView . setText(residentStr) ;
            rollNO = detailedIntent . getStringExtra(Intent . EXTRA_TEXT) ;
            //Toast . makeText(this , rollNO , Toast . LENGTH_SHORT) . show() ;
    	}
        show_entries() ;
    }

    public void add_entry(View view) {
        Intent intent = new Intent(this , AddNewEntry . class) . putExtra(Intent . EXTRA_TEXT , rollNO) ;
        startActivity(intent) ;
    }

    public void show_entries() {
        ResidentDbHelper resDbHelper = new ResidentDbHelper(getApplicationContext());
        SQLiteDatabase mydb = resDbHelper.getReadableDatabase();
        Cursor c = mydb.rawQuery("SELECT * FROM " + ResidentDBContract.ResidentEntry2.TABLE_NAME + " WHERE " + ResidentDBContract.ResidentEntry2.COLUMN_NAME_ROLLNO + " = " + rollNO + " ;" , null);
        ArrayList<String> entries_list = new ArrayList<String>() ;
        int total_bill = 0 ;
        while(c.moveToNext()) {
            String str ;
            String diet_Taken = c.getString(c.getColumnIndexOrThrow(ResidentDBContract.ResidentEntry2.COLUMN_NAME_DIET));
            int diet_Price = c.getInt(c.getColumnIndexOrThrow(ResidentDBContract.ResidentEntry2.COLUMN_NAME_PRICE));
            total_bill = total_bill + diet_Price ;
            str = "Diet taken : " + diet_Taken + "\nPrice : " + diet_Price ;
            entries_list . add(str) ;
        }

        final ArrayAdapter<String> entries_adapter = new ArrayAdapter<String> (this ,
                                                R.layout.list_item_entry ,
                                                R.id.list_item_entry_textview ,
                                                entries_list ) ;
        ListView entries_listview = (ListView) findViewById(R.id.listview_entries) ;
        entries_listview . setAdapter(entries_adapter) ;
        TextView totalBill = (TextView) findViewById(R . id . total_bill_textview) ;
        totalBill . setText("Total bill : " + total_bill) ;
    }
}