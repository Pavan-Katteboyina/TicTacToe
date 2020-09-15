package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameHome extends AppCompatActivity {
    Button btn;
    Button btn1;
    ImageView img;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);
        tv=(TextView)findViewById(R.id.textView);
        img =(ImageView)findViewById(R.id.imageView);
        btn=(Button)findViewById(R.id.button);
        btn1=(Button)findViewById(R.id.button10);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameHome.this, MainActivity.class);
                startActivity(intent);

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(GameHome.this,Multiplayer.class);
                startActivity(intent);

            }
        });

        }
    }
