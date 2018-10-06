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
    private static int turn=0;
    private static boolean won=false;
    boolean gameWithComputer=true;
    ArrayList<Integer> player1=new ArrayList<>();
    ArrayList<Integer> player2=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameWithComputer=getIntent().getExtras().getBoolean("computerPlay");
        reset(null);

    }

    void play(Button selected){
        if(turn%2==0){
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
        if(turn==9&&won==false)
            Toast.makeText(this,"Draw!!",Toast.LENGTH_LONG).show();
    }
    void autoPlay(Button selected){
            selected.setBackgroundColor(getResources().getColor(R.color.cream));
            selected.setText("O");
            selected.setEnabled(false);
            turn++;
            checkWinner();
            if(turn%2==0&&turn<9&&(!won)) {
                int id;
                id = (int) (Math.random() * 9) + 1;
                while (player1.contains(id)||player2.contains(id)){
                    id = (int) (Math.random() * 9) + 1;
                    Toast.makeText(this, "new id : " + id, Toast.LENGTH_LONG).show();
                }
                Toast.makeText(this, "" + id, Toast.LENGTH_LONG).show();
               addInTheList(id);
                Button button = (Button) findViewById(getResources().getIdentifier("b" + id, "id",
                        this.getPackageName()));
                button.setBackgroundColor(getResources().getColor(R.color.coral));
                button.setText("X");
                button.setEnabled(false);
                checkWinner();
            }
        if(turn==10&&won==false)
            Toast.makeText(this,"Draw!!",Toast.LENGTH_LONG).show();

    }
    void reset(View view){
        for (int i = 1; i <= 9; i++)
        {
            Button button = (Button) findViewById(getResources().getIdentifier("b" + i, "id",
                    this.getPackageName()));
            button.setEnabled(true);
            button.setText("");
            button.setBackgroundColor(getResources().getColor(R.color.btnclr));
        }
        turn=0;
        won=false;
        player1.clear();
        player2.clear();

    }
    void addInTheList(int bid){
        if((turn&1)==1){
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
            won=true;
        }
        else if((player2.contains(1)&&player2.contains(2)&&player2.contains(3))||(player2.contains(1)&&player2.contains(4)&&player2.contains(7))||(player2.contains(1)&&player2.contains(5)&&player2.contains(9))
                ||(player2.contains(2)&&player2.contains(5)&&player2.contains(8))||(player2.contains(3)&&player2.contains(6)&&player2.contains(9))||(player2.contains(3)&&player2.contains(5)&&player2.contains(7))
                ||(player2.contains(4)&&player2.contains(5)&&player2.contains(6))||(player2.contains(7)&&player2.contains(8)&&player2.contains(9))) {
            Toast.makeText(this, "Player2 wins!", Toast.LENGTH_LONG).show();
            disableAll();
            won=true;
        }


    }
    void makeChange(View view){
        Button selected = (Button) view;
        turn++;
        switch (selected.getId()){
            case R.id.b1:
//                //Toast.makeText(this,"b1 selected",//Toast.LENGTH_LONG).show();
                addInTheList(1);
                break;
            case R.id.b2:
                //Toast.makeText(this,"b2 selected",//Toast.LENGTH_LONG).show();
                addInTheList(2);
                break;
            case R.id.b3:
                //Toast.makeText(this,"b3 selected",//Toast.LENGTH_LONG).show();
                addInTheList(3);
                break;
            case R.id.b4:
                addInTheList(4);
                //Toast.makeText(this,"b4 selected",//Toast.LENGTH_LONG).show();
                break;
            case R.id.b5:
                addInTheList(5);
                //Toast.makeText(this,"b5 selected",//Toast.LENGTH_LONG).show();
                break;
            case R.id.b6:
                addInTheList(6);
                //Toast.makeText(this,"b6 selected",//Toast.LENGTH_LONG).show();
                break;
            case R.id.b7:
                addInTheList(7);
                //Toast.makeText(this,"b7 selected",//Toast.LENGTH_LONG).show();
                break;
            case R.id.b8:
                addInTheList(8);
                //Toast.makeText(this,"b8 selected",//Toast.LENGTH_LONG).show();
                break;
            case R.id.b9:
                addInTheList(9);
                //Toast.makeText(this,"b9 selected",//Toast.LENGTH_LONG).show();
                break;

        }
        if(!gameWithComputer)
        play(selected);
        else
            autoPlay(selected);
        //Toast.makeText(this,"Last "+turn,Toast.LENGTH_LONG).show();

    }
}
