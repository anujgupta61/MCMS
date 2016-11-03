package com.andromap33.mcms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

public class AddTodayMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_today_menu);
    }

    public void add_today_menu(View view) {
    	EditText editMenu = (EditText) findViewById(R . id . today_menu) ;
    	EditText editPrice = (EditText) findViewById(R . id . price) ;
    	String todayMenu = editMenu . getText() . toString() ;
    	String price = editPrice . getText() . toString() ;
        if(todayMenu . length() == 0 || price . length() == 0) {
            Toast . makeText(this , "Please enter both fields ." , Toast . LENGTH_SHORT) . show() ;
        } else {
            AppSharedPreference . setTodayMenu(getApplicationContext() , todayMenu) ;
            AppSharedPreference . setPrice(getApplicationContext() , price) ;
            Toast . makeText(this , "Today's menu added ." , Toast . LENGTH_SHORT) . show() ;
            Intent back = new Intent(this , MainActivity . class) ;
        	back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
            startActivity(back) ;
            finish();
        }
    }
}