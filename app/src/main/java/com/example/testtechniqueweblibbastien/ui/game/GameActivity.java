package com.example.testtechniqueweblibbastien.ui.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import static com.example.testtechniqueweblibbastien.MainActivity.sharedPreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testtechniqueweblibbastien.MainActivity;
import com.example.testtechniqueweblibbastien.R;
import com.example.testtechniqueweblibbastien.databinding.ActivityGameBinding;
import com.example.testtechniqueweblibbastien.ui.game.Chord;
import com.example.testtechniqueweblibbastien.ui.parametre.ParametreActivity;
import org.json.*;

import android.widget.Button;

import java.io.Console;

public class GameActivity extends AppCompatActivity {


    public TextView Note ;
    public TextView Upper;
    public TextView Lower;
    public TextView count ;
    public Button quit ;
    public int nbrNote = 10;
    public int nbrSec ;
    public TextView timer ;



    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("starting game :>---------------------------------------------------------------");
        setContentView(R.layout.activity_game);
        Note = findViewById(R.id.Note);
        Upper = findViewById(R.id.Upper);
        Lower = findViewById(R.id.Lower);
        count = findViewById(R.id.ChordCount);
        quit =  findViewById(R.id.quit);
        timer = findViewById(R.id.Timer);
        //nbrSec = ParametreActivity.nbrSec ;


        /*try {
            /*System.out.println("time 5 : "+ParametreActivity.time5.isActivated());
            System.out.println("time 10 : "+ParametreActivity.time10.isActivated());
            System.out.println("time 15 : "+ParametreActivity.time15.isActivated());
            if(ParametreActivity.time5.isActivated()){
                nbrSec=5;
            }else if( ParametreActivity.time10.isActivated()){
                nbrSec = 10 ;
            }else if (ParametreActivity.time15.isActivated()){
                nbrSec = 15;
            }else {
                nbrSec = 1 ;
            }
        }catch (Exception e){
            nbrSec = 5;
        }*/

        nbrSec = sharedPreferences.getInt("time", 5);


        quit.setOnClickListener(view -> {
            Intent i = new Intent(GameActivity.this , MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.putExtra("EXIT", true);
            startActivity(i);

        });
        Game(0);
    }
    public void Game(int i)  {

        Chord c = Chord.randomChord();
        displayChord(c);
        i++;
        count.setText(i+"/"+nbrNote);

        if(i<10){
            waiting(i,0);
        }
    }

    public void waiting(int i,int j){
        int r = nbrSec-j;
        //System.out.println(r);
        timer.setText(Integer.toString(r));
        Handler handler = new Handler();
        if(j<nbrSec){
            j++;
            int finalj = j;
            handler.postDelayed(() -> waiting(i, finalj), 1000);
        }else{
            Game(i);
        }

    }

    public void displayChord(Chord c){
            Note.setText(c.getValue());
            Upper.setText(c.getUpper());
            Lower.setText(c.getLower());
    }
}