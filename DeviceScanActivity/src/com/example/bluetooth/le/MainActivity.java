package com.example.bluetooth.le;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends Activity 
{
	Button startslideshow;
	Handler mHandler;
	int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        
        setContentView(R.layout.activity_main);
        
        /*
        startslideshow = (Button) findViewById(R.id.landingpage_button);
        
        startslideshow.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) 
            {
                // TODO Auto-generated method stub
                Intent i = new Intent();
                i.setClass(MainActivity.this, ImageActivity.class);
                MainActivity.this.startActivity(i);                
            }
        });
        */
        
        mHandler = new Handler();
        mHandler.post(runnable);       
        
    }
    
    final Runnable runnable = new Runnable() 
    {
        public void run() 
        {

            // TODO Auto-generated method stub
            if (count < 2) 
            {
                count++;
                mHandler.postDelayed(runnable, 1000);
            } 
            else 
            {
            	//if(no data)
            	Intent i = new Intent();
                i.setClass(MainActivity.this, ImageActivity.class);
                MainActivity.this.startActivity(i); 
                //else goto RecordsActivity
            }
        }
    };
    
    @Override
    protected void onDestroy() 
    {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (mHandler != null) 
        {
            mHandler.removeCallbacks(runnable);
        }
    }
    
    


}
