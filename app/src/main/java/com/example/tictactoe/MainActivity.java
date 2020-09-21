package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int roundCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bu(View view) {

        Button buSelected =(Button) view;
        buSelected.setBackgroundColor(Color.MAGENTA);
        int CellId=0;
        switch ((buSelected.getId())){

            case  R.id.button1:
                CellId=1;
                break;

            case R.id.button2:
                CellId=2;
                break;

            case R.id.button3:
                CellId=3;
                break;

            case R.id.button4:
                CellId=4;
                break;

            case R.id.button5:
                CellId=5;
                break;

            case R.id.button6:
                CellId=6;
                break;

            case R.id.button7:
                CellId=7;
                break;

            case R.id.button8:
                CellId=8;
                break;



            case R.id.button9:
                CellId=9;
                break;

        }


        Playgame(CellId, buSelected);

    }
    int ActivePlayer=1;
    ArrayList<Integer> Player1=new ArrayList<Integer>();
    ArrayList<Integer> Player2= new ArrayList<Integer>();


    void Playgame (int CellId, Button buSelected){

        Log.d("player:", String.valueOf(CellId));
        Log.d("button Id:",String.valueOf(CellId));
        Log.d("Button Text:",buSelected.getText().toString());


        if (ActivePlayer==1){
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.MAGENTA);
            buSelected.setTextColor(Color.WHITE);
            Player1.add(CellId);
            ActivePlayer=2;
            Autoplay();
        }
        else if (ActivePlayer==2){
            buSelected.setText("O");
            buSelected.setBackgroundColor(Color.GREEN);
            buSelected.setTextColor(Color.WHITE);
            Player2.add(CellId);
            ActivePlayer=1;
        }
         roundCount++;
        buSelected.setEnabled(false);
        CheckWinner();


    }
    void CheckWinner(){

        int Winner=-1;

        //row check

        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            Winner=1;

        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            Winner=2;

        }
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            Winner=1;

        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            Winner=2;

        }
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            Winner=1;

        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            Winner=2;

        }

        //columcheck

        if (Player1.contains(1) && Player1.contains(3) && Player1.contains(7)){
            Winner=1;

        }
        if (Player2.contains(1) && Player2.contains(3) && Player2.contains(7)){
            Winner=2;

        }


        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            Winner=1;

        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            Winner=2;
        }


        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            Winner=1;

        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            Winner=2;

        }


        //Diagonal check

        if (Player1.contains(1) && Player1.contains(5) && Player1.contains(9)) {
            Winner = 1;

        }
        if (Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){
            Winner=2;

        }


        if (Player1.contains(3) && Player1.contains(5) && Player1.contains(7)) {
            Winner = 1;

        }
        if (Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){
            Winner=2;

        }



        if (Winner!=-1){
            if (Winner==1){
                Toast.makeText(this,"Player 1 Won the Match", Toast.LENGTH_LONG).show();
                finish();
            }

            if (Winner==2){
                Toast.makeText(this,"Computer Won the Match", Toast.LENGTH_LONG).show();
                finish();
            }
        else  {
                if (roundCount==9){
                    Toast.makeText(this, "Draw Match", Toast.LENGTH_LONG).show();
                    finish();
                }
            }


        }





    }


    void  Autoplay() {
        ArrayList<Integer> EmptyCells = new ArrayList<Integer>();

        for (int CellId = 1; CellId < 10; CellId++) {
            if (!(Player1.contains(CellId) || Player2.contains(CellId))) {
                EmptyCells.add(CellId);
            }
        }
        Random r = new Random();
        int RandIndex = r.nextInt(EmptyCells.size() - 0) + 0;
        int CellId=EmptyCells.get(RandIndex);
        Button buSelected;





        switch (CellId){

            case 1:
               buSelected=findViewById(R.id.button1);
                break;

            case 2:
                buSelected=findViewById(R.id.button2);
                break;

            case 3:
                buSelected=findViewById(R.id.button3);
                break;

            case 4:
                buSelected=findViewById(R.id.button4);
                break;

            case 5:
                buSelected=findViewById(R.id.button5);
                break;

            case 6:
                buSelected=findViewById(R.id.button6);
                break;

            case 7:
                buSelected=findViewById(R.id.button7);
                break;

            case 8:
                buSelected=findViewById(R.id.button8);
                break;



            case 9:
                buSelected=findViewById(R.id.button9);
                break;
            default:
                buSelected=findViewById(R.id.button1);
                break;
        }
        Playgame(CellId, buSelected);


    }



}