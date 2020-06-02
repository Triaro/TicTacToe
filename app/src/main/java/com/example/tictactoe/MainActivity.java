package com.example.tictactoe;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tictactoe.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 0- O
    // 1- X
    int activePlayer=0;
    int gameState[] ={ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    // States :-
    // 0- O
    // 1- X
    // 2- NULL

    int winPositions[][] = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};



    public void playerTap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedImage= Integer.parseInt(img.getTag().toString());


        if(gameState[tappedImage]==2)
        { gameState[tappedImage]=activePlayer;
          img.setTranslationY(-1000f);
          if(activePlayer==0)
          {
              img.setImageResource(R.drawable.o);
              activePlayer=1;
              TextView status = findViewById(R.id.status);
              status.setText("Tap for X");
           }

          else
          {   img.setImageResource(R.drawable.x);
              activePlayer=0;
              TextView status = findViewById(R.id.status);
              status.setText("Tap for O");
          }
          img.animate().translationYBy(1000f).setDuration(300);
          // Check if someone won?
            for(int winposition[]: winPositions)
            {
                if(gameState[winposition[0]]== gameState[winposition[1]] &&
                        gameState[winposition[1]]== gameState[winposition[2]] &&
                        gameState[winposition[0]]!=2)
                {

                   String winnerStr;
                    if(gameState[winposition[0]]==0)
                    {
                        winnerStr = "O has Won";
                    }
                    else
                        winnerStr = "X has Won";



                    activePlayer=0;
                    for(int i=0; i<gameState.length; i++)
                    {
                        gameState[i]=2;
                    }
                    ((ImageView)findViewById(R.id.imageView2)).setImageResource((0));
                    ((ImageView)findViewById(R.id.imageView3)).setImageResource((0));
                    ((ImageView)findViewById(R.id.imageView4)).setImageResource((0));
                    ((ImageView)findViewById(R.id.imageView5)).setImageResource((0));
                    ((ImageView)findViewById(R.id.imageView6)).setImageResource((0));
                    ((ImageView)findViewById(R.id.imageView7)).setImageResource((0));
                    ((ImageView)findViewById(R.id.imageView8)).setImageResource((0));
                    ((ImageView)findViewById(R.id.imageView9)).setImageResource((0));
                    ((ImageView)findViewById(R.id.imageView10)).setImageResource((0));

                    Intent intent =new Intent(MainActivity.this, WinActivity.class);
                    intent.putExtra(EXTRA_MESSAGE, winnerStr);
                    startActivity(intent);
                }

            }

        }
    }

  /*  public void gameReset(View view)
    {
        gameActive=true;
        activePlayer=0;
        for(int i=0; i<gameState.length; i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource((0));
        ((ImageView)findViewById(R.id.imageView3)).setImageResource((0));
        ((ImageView)findViewById(R.id.imageView4)).setImageResource((0));
        ((ImageView)findViewById(R.id.imageView5)).setImageResource((0));
        ((ImageView)findViewById(R.id.imageView6)).setImageResource((0));
        ((ImageView)findViewById(R.id.imageView7)).setImageResource((0));
        ((ImageView)findViewById(R.id.imageView8)).setImageResource((0));
        ((ImageView)findViewById(R.id.imageView9)).setImageResource((0));
        ((ImageView)findViewById(R.id.imageView10)).setImageResource((0));



    }

   */
}
