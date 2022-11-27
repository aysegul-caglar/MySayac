package com.example.mysayac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class setupActivity extends AppCompatActivity {

    int upLimit=20;
    Button uplus,uminus;
    EditText upvalue;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        uplus=(Button) findViewById(R.id.up_plus);
        uminus=(Button) findViewById(R.id.up_minus);
        upvalue=(EditText) findViewById(R.id.upperLimit);
        Context context= getApplicationContext();
        sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();

        upvalue.setText(String.valueOf(upLimit));
        uplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upLimit++;
                upvalue.setText(String.valueOf(upLimit));
            }
        });
        uminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upLimit--;
                upvalue.setText(String.valueOf(upLimit));
            }
        });
        upvalue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                upLimit= Integer.valueOf(upvalue.getText().toString());
            }
        });

    }
    @Override
    protected void onPause() {
        super.onPause();
        editor.putInt("UpperLimit",upLimit);
        editor.commit();
    }
}