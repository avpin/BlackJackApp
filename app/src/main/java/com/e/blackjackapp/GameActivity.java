package com.e.blackjackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Game game = new Game(getResources(), this);


        Button bHit = findViewById(R.id.hitButton);
        Button nGame = findViewById(R.id.newGameButton);
        //bHit.setOnClickListener(new View.OnClickListener() {
          //                          @Override
            //                        public void onClick(View v) {
              //                          system.out.println("");
                //                    }
                  //                  system.out.println("");
                    //            }


    }

}
