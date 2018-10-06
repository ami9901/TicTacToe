package com.example.ruchitesh.onlinetictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private static int turn=0;
    ArrayList<Integer> player1=new ArrayList<>();
    ArrayList<Integer> player2=new ArrayList<>();
    void play(int turnNumber,Button selected){
        if(turnNumber%2==0){
            selected.setBackgroundColor(getResources().getColor(R.color.coral));
            selected.setText("X");
            selected.setEnabled(false);
        }
        else{
            selected.setBackgroundColor(getResources().getColor(R.color.cream));
            selected.setText("O");
            selected.setEnabled(false);
        }
        checkWinner();
    }
    void addInTheList(int t,int bid){
        if((t&1)==1){
//            Toast.makeText(this,"added into player1",Toast.LENGTH_LONG).show();
            player1.add(bid);
        }
        else{
            player2.add(bid);
        }
    }
    void disableAll(){
        for (int i = 1; i <= 9; i++)
        {
            Button button = (Button) findViewById(getResources().getIdentifier("b" + i, "id",
                    this.getPackageName()));
            button.setEnabled(false);
        }
    }
    void checkWinner(){
        if((player1.contains(1)&&player1.contains(2)&&player1.contains(3))||(player1.contains(1)&&player1.contains(4)&&player1.contains(7))||(player1.contains(1)&&player1.contains(5)&&player1.contains(9))
                ||(player1.contains(2)&&player1.contains(5)&&player1.contains(8))||(player1.contains(3)&&player1.contains(6)&&player1.contains(9))||(player1.contains(3)&&player1.contains(5)&&player1.contains(7))
                ||(player1.contains(4)&&player1.contains(5)&&player1.contains(6))||(player1.contains(7)&&player1.contains(8)&&player1.contains(9))) {
            Toast.makeText(this, "Player1 wins!", Toast.LENGTH_LONG).show();
            disableAll();
        }
        else if((player2.contains(1)&&player2.contains(2)&&player2.contains(3))||(player2.contains(1)&&player2.contains(4)&&player2.contains(7))||(player2.contains(1)&&player2.contains(5)&&player2.contains(9))
                ||(player2.contains(2)&&player2.contains(5)&&player2.contains(8))||(player2.contains(3)&&player2.contains(6)&&player2.contains(9))||(player2.contains(3)&&player2.contains(5)&&player2.contains(7))
                ||(player2.contains(4)&&player2.contains(5)&&player2.contains(6))||(player2.contains(7)&&player2.contains(8)&&player2.contains(9))) {
            Toast.makeText(this, "Player2 wins!", Toast.LENGTH_LONG).show();
            disableAll();
        }

    }
    void makeChange(View view){
        Button selected = (Button) view;
        turn++;
        switch (selected.getId()){
            case R.id.b1:
//                //Toast.makeText(this,"b1 selected",//Toast.LENGTH_LONG).show();
                addInTheList(turn,1);
                break;
            case R.id.b2:
                //Toast.makeText(this,"b2 selected",//Toast.LENGTH_LONG).show();
                addInTheList(turn,2);
                break;
            case R.id.b3:
                //Toast.makeText(this,"b3 selected",//Toast.LENGTH_LONG).show();
                addInTheList(turn,3);
                break;
            case R.id.b4:
                addInTheList(turn,4);
                //Toast.makeText(this,"b4 selected",//Toast.LENGTH_LONG).show();
                break;
            case R.id.b5:
                addInTheList(turn,5);
                //Toast.makeText(this,"b5 selected",//Toast.LENGTH_LONG).show();
                break;
            case R.id.b6:
                addInTheList(turn,6);
                //Toast.makeText(this,"b6 selected",//Toast.LENGTH_LONG).show();
                break;
            case R.id.b7:
                addInTheList(turn,7);
                //Toast.makeText(this,"b7 selected",//Toast.LENGTH_LONG).show();
                break;
            case R.id.b8:
                addInTheList(turn,8);
                //Toast.makeText(this,"b8 selected",//Toast.LENGTH_LONG).show();
                break;
            case R.id.b9:
                addInTheList(turn,9);
                //Toast.makeText(this,"b9 selected",//Toast.LENGTH_LONG).show();
                break;

        }

        play(turn,selected);
    }
}
