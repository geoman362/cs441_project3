package com.example.george.runfast;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //ratRace ratRace;
    AnimationDrawable ratanimation;
    int last_image;
    ImageView ratImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ratRace = new ratRace(this);
       // setContentView(ratRace);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ratImage = (ImageView) findViewById(R.id.imageView);
        ratImage.setImageResource(R.drawable.ratdamage);
        last_image = 1;
        //ratImage.setBackgroundResource(R.drawable.ratwin);
        //ratanimation = (AnimationDrawable) ratImage.getBackground();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
        Button playbutt = (Button) findViewById(R.id.playButton);
        playbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle_rat();
            }
        });

       /* ratImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // run animation

            }
        });*/

    }

    public void toggle_rat(){
        if(last_image == 1){
            ratImage.setImageResource(R.drawable.rat2);
            last_image = 2;
        }
        else{
            ratImage.setImageResource(R.drawable.rat1);
            last_image = 1;
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
