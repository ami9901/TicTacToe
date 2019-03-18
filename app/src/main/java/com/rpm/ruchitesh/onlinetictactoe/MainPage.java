package com.rpm.ruchitesh.onlinetictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }
    void goNext(View v){
        boolean choice=true;
        if(v.getId()==R.id.po1)
            choice=true;
        if(v.getId()==R.id.po2)
            choice=false;
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("computerPlay",choice);
        startActivity(i);

    }
}
