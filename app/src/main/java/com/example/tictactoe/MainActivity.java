package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameRunning = true;
    // Player Notations
    // 0 -> O
    // 1->  X
    int turnOf = 0;
    int [] current = {69, 69, 69, 69, 69, 69, 69, 69, 69};
    // Current Meaning
    // 0-> O
    // 1-> X
    // 69 -> empty  :/
    int [][] victoryStates = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Three Horizontal
                              {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Three VerticL
                                    {0,4,8}, {2,4,6}}; // Two Diagonals
    public void playerTurn(View view){
            ImageView img = (ImageView)view;
            int selectedImage = Integer.parseInt(img.getTag().toString());
            if(!gameRunning){
                gameRestart(view );
            }
            if(current[selectedImage]==69){
                current[selectedImage] = turnOf;
                img.setTranslationY(-1000f);
                if(turnOf==0){
                    img.setImageResource(R.drawable.zero);
                    turnOf=1;
                    TextView callForTurn = findViewById(R.id.callForTurn);
                    callForTurn.setText("Player2: Tap to Play");
                }
                else{
                    img.setImageResource(R.drawable.x);
                    turnOf=0;
                    TextView callForTurn = findViewById(R.id.callForTurn);
                    callForTurn.setText("Player1: Tap to Play");
                }
                img.animate().translationYBy(1000f).setDuration(300);

            }
            // Check for winner
            for(int[] victoryState: victoryStates){
                if(current[victoryState[0]]== current[victoryState[1]] && current[victoryState[1]]== current[victoryState[2]] && current[victoryState[0]]!=69){
                            // Winner is found
                    String winner;
                    gameRunning = false;
                    if(current[victoryState[0]]==0){
                        winner = "O has won";
                    }
                    else{
                        winner = "X has won";
                    }
                    // Changing the callForTurn block and declaring the winner.
                    TextView callForTurn = findViewById(R.id.callForTurn);
                    callForTurn.setText(winner);
                }
            }
            // Check for draw
            boolean draw = false;
            int i=0;
            while(i<9){
                if(current[i]==1 || current[i]==0){
                    i+=1;
                }
                else{
                    break;
                }
            }
            if(i==9){
                String drawMessage = "Match Drawn";
                gameRunning = false;
                TextView callForTurn = findViewById(R.id.callForTurn);
                callForTurn.setText(drawMessage);
            }

    }
    public void gameRestart(View view){
        gameRunning = true;
        turnOf=0;
        current = new int[]{69, 69, 69, 69, 69, 69, 69, 69, 69};
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
