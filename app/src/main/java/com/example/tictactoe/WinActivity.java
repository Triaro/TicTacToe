package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;


public class WinActivity extends AppCompatActivity{

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.win);
        textView.setText(message);

        handler =new Handler();
        handler .postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1=new Intent(WinActivity.this, MainActivity.class);
                startActivity(intent1);

            }
        },3000);

    }
}
