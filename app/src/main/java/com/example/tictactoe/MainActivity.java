package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // Player Notations
    // 0 -> O
    // 1->  X
    int turnOf = 0;
    int [] current = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    // Current Meaning
    // 0-> O
    // 1-> X
    // 2 -> empty
    int [][] victoryStates = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Three Horizontal
                              {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Three VerticL
                                    {0,4,8}, {2,4,6}}; // Two Diagonals
    public void playerTurn(View view){
            ImageView img = (ImageView)view;
            int selectedImage = Integer.parseInt(img.getTag().toString());
            if(current[selectedImage]==2){
                current[selectedImage] = turnOf;
                img.setTranslationY(-1000f);
                if(turnOf==0){
                    img.setImageResource(R.drawable.zero);
                    turnOf=1;
                }
                else{
                    img.setImageResource(R.drawable.x);
                    turnOf=0;
                }
                img.animate().translationYBy(1000f).setDuration(300);

            }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
