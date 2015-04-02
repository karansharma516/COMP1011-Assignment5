/**
 * Author: Karan Sharma
 * File Name: SplashScreen.java
 * Date: April 2, 2015
 * App Description: This app gives the user body mass index value and displays the information from 
 * health department to the user. This app also allow the user to select different units.
 */

package ca.georgiancollege.bmiclaculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
 
public class SplashScreen extends Activity {
 
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
 
        new Handler().postDelayed(new Runnable() {
 
            
            @Override
            public void run() {
                
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
 
}