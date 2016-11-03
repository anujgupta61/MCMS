package com.andromap33.mcms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Introduction extends AppCompatActivity {

    public static int intro_count = -1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	if(AppSharedPreference . getFlag(getApplicationContext()) == true) {
    		Intent main = new Intent(this , MainActivity . class) ;
            main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
    		startActivity(main) ;
            finish();
	   	} else {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_introduction);
    	}
    }

    @Override
    public void onPause() {
    	super . onPause() ;
    	intro_count = -1 ;
    	TextView intro = (TextView) findViewById(R . id . intro_text) ;
    	intro . setText(R . string . intro_text) ;
    }

    public void showNextIntro(View view) {
    	TextView intro = (TextView) findViewById(R . id . intro_text) ;
    	switch(intro_count) {
    		case -1 :
    			intro . setText("This mode is for Mess/Canteen . With the help of this app , you can manage the accounts of residents . A list of residents who are having account in your mess will be displayed ; after clicking on any resident in list , multiple options such as insert new entry will be displayed .") ;
    			intro_count ++ ;
    			break ;
    		case 0 :
    			intro . setText("You can add today's menu which will be shown in the user mode of this app . After a whole month , total bill of every resident will be generated and sent to the resident .") ;
    			intro_count ++ ;
    			break ;
    		case 1 :
    			intro . setText("Residents can order the food through this app ; Orders will be displayed in this app in ascending order of time . Options of calculator and notes will also be provided for help .") ;
    			intro_count ++ ;
    			break ;
    		case 2 :
    			intro . setText("All the entries added by you will also be sent to the residents so that they can verify whether that entry is correct or not . By this way real bill will be generated .") ;
    			intro_count ++ ;
    			break ;
    		case 3 :
    			intro . setText("Thanks for reading all the stuff . I hope this app will be helpful to you .") ;
    			intro_count ++ ;
    			break ;
    		case 4 :
    			Intent main = new Intent(this , MainActivity . class) ;
            	main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
    			startActivity(main) ;
    			finish() ;
    			break ;
    	}
    }

    public void skipToMain(View view) {
    	Intent main = new Intent(this , MainActivity . class) ;
        main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
    	startActivity(main) ;
    	finish() ;
    }
}
