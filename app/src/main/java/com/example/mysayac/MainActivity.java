package com.example.mysayac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView value;
    Button minus,plus,ayar;
    int counter=0;
    int upLimit=20;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value = (TextView) findViewById(R.id.value);
        minus = (Button) findViewById(R.id.minus);
        plus = (Button) findViewById(R.id.plus);
        ayar = (Button) findViewById(R.id.setup);

        Context context = getApplicationContext();
        sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter < upLimit)
                    counter++;
                value.setText(String.valueOf(counter));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                value.setText(String.valueOf(counter));
            }
        });
        ayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, setupActivity.class);
                startActivity(i);
            }
        });
    }
        @Override
        protected void onResume(){
        super.onResume();
        upLimit= sharedPreferences.getInt("UpperLimit",20);


    }
}