package com.example.tiktoktoe;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void startLocalGame(View view) {
        Intent intent=new Intent(this,PlayWithHuman.class);
        startActivity(intent);
    }

    public void startComputerGame(View view) {
        Intent intent=new Intent(this,PlayWithComputer.class);
        startActivity(intent);
    }

    public void playOnWiFi(View view) {
    }

    public void playOnInternet(View view) {
    }

    public void quitGame(View view) {
    }
}
