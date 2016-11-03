package com.andromap33.mcms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppSharedPreference . setFlag(getApplicationContext() , true) ;
        String menu = AppSharedPreference . getTodayMenu(getApplicationContext()) ;
        String price = AppSharedPreference . getPrice(getApplicationContext()) ;
        TextView menu_txt = (TextView) findViewById(R . id . today_menu_text) ;
        menu_txt . setText("Today's menu : \n" + menu) ;
        TextView price_txt = (TextView) findViewById(R . id . price_text) ;
        price_txt . setText("Price : " + price) ;
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void list_residents(View view) {
        Intent intent1 = new Intent(this , ResidentsList . class) ;
        startActivity(intent1) ;
    }

    public void view_orders(View view) {
        Intent intent2 = new Intent(this , ViewOrders . class) ;
        startActivity(intent2) ;      
    }

    public void add_today_menu(View view) {
        Intent intent3 = new Intent(this , AddTodayMenu . class) ;
        startActivity(intent3) ;
    }

    public void rate_us(View view) {
        
    }

}