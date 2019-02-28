package com.example.animtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView score;
    ImageView image;
    Button butt;
    Button butt2;
    int last_image;
    int scorenum;
    int victory1;
    int victory2;
    int victory3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        last_image = 1;
        int scorenum = 0;
        int victory1 = 0;
        victory2 = 0;
        victory3 = 0;
        score = findViewById(R.id.textView2);
        score.setText("Score is : 0");
        image = findViewById(R.id.imageView);
        image.setImageResource(R.drawable.rat1);
        butt2 = findViewById(R.id.button2);
        butt = findViewById(R.id.button);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveImage();
            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angryrat();
            }
        });


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

    public void moveImage(){
        if(last_image == 1){
            image.setImageResource(R.drawable.rat2);
            last_image = 2;
        }
        else{
            image.setImageResource(R.drawable.rat1);
            last_image = 1;
        }
        scorenum++;
        if(scorenum >= 50 && victory1 == 0){
            image.setImageResource(R.drawable.ratwin);
            victory1 = 1;
        }
        if(scorenum >= 100 && victory2 == 0){
            image.setImageResource(R.drawable.ratwin2);
            victory2 = 1;
        }
        if(scorenum >= 200 && victory3 == 0){
            image.setImageResource(R.drawable.ratwin3);
            victory3 = 1;
        }
        String scoreString = "Score is ";
        scoreString = scoreString.concat(Integer.toString(scorenum));
        score.setText(scoreString);





    }
    public void angryrat(){
        image.setImageResource(R.drawable.ratdamage);
        score.setText("*Translated from Rattish* \n Wrong answer!");
    }
}
