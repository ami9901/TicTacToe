package com.example.ruchitesh.onlinetictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private static int turn=0;
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
    }
    void makeChange(View view){
        Button selected = (Button) view;
        switch (selected.getId()){
            case R.id.b1:
//                Toast.makeText(this,"b1 selected",Toast.LENGTH_LONG).show();
                turn++;
                break;
            case R.id.b2:
                Toast.makeText(this,"b2 selected",Toast.LENGTH_LONG).show();
                turn++;
                break;
            case R.id.b3:
                turn++;
                Toast.makeText(this,"b3 selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.b4:
                turn++;
                Toast.makeText(this,"b4 selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.b5:
                turn++;
                Toast.makeText(this,"b5 selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.b6:
                turn++;
                Toast.makeText(this,"b6 selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.b7:
                turn++;
                Toast.makeText(this,"b7 selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.b8:
                turn++;
                Toast.makeText(this,"b8 selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.b9:
                turn++;
                Toast.makeText(this,"b9 selected",Toast.LENGTH_LONG).show();
                break;

        }
        play(turn,selected);
    }
}
