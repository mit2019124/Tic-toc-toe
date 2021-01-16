package com.example.tiktoktoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PlayWithHuman extends AppCompatActivity {
    boolean gameActive = true;
    int activePlayer = 0;
    int count = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    int[][] winpos ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public  void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        count = 0;
        for (int i=0; i< gameState.length;i++) {
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.im10)).setImageResource(0);
        ((ImageView)findViewById(R.id.im11)).setImageResource(0);
        ((ImageView)findViewById(R.id.im12)).setImageResource(0);
        ((ImageView)findViewById(R.id.im13)).setImageResource(0);
        ((ImageView)findViewById(R.id.im14)).setImageResource(0);
        ((ImageView)findViewById(R.id.im15)).setImageResource(0);
        ((ImageView)findViewById(R.id.im16)).setImageResource(0);
        ((ImageView)findViewById(R.id.im17)).setImageResource(0);
        ((ImageView)findViewById(R.id.im18)).setImageResource(0);
    }
    public void tapS(View view){
        ImageView img=(ImageView)view;
        int tapImg = Integer.parseInt(img.getTag().toString());

        if(gameState[tapImg] == 2 && gameActive){
            count +=1;
            gameState[tapImg] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0){
                img.setImageResource(R.drawable.zero);
                activePlayer = 1;
                TextView status = findViewById(R.id.t2);
                status.setText("x's turn to play");
            }
            else{
                img.setImageResource(R.drawable.x);
                activePlayer = 0;
                TextView status = findViewById(R.id.t2);
                status.setText("0's turn to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
            for(int[] wincheck: winpos) {
                if (gameState[wincheck[0]] == gameState[wincheck[1]] &&
                        gameState[wincheck[1]] == gameState[wincheck[2]] && gameState[wincheck[0]] != 2) {
                    String winerStr;
                    gameActive = false;
                    if (gameState[wincheck[0]] == 0) {
                        winerStr = "0 wins";
                    } else {
                        winerStr = "x wins";
                    }
                    TextView status = findViewById(R.id.t2);
                    status.setText(winerStr);
                }
            }
            if (count == 9 && gameActive) {
                String winerStr;
                winerStr = "match Draw";
                TextView status = findViewById(R.id.t2);
                status.setText(winerStr);
                gameReset(view);
            }

        }else if(!gameActive){
            String winerStr;
            winerStr = "Start Again";
            TextView status = findViewById(R.id.t2);
            status.setText(winerStr);
            gameReset(view);
        }else{
            Toast.makeText(this,"Enter a valid box",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
    }
}
