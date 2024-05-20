package com.example.testtechniqueweblibbastien.ui.game;

import android.annotation.SuppressLint;
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

    public Button restart ;
    public boolean stop = false;
    public Handler handler ;



    @SuppressLint("MissingInflatedId")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("starting game :>---------------------------------------------------------------");
        setContentView(R.layout.activity_game);
        Note = findViewById(R.id.Note);
        Upper = findViewById(R.id.Upper);
        Lower = findViewById(R.id.Lower);
        count = findViewById(R.id.ChordCount);
        quit =  findViewById(R.id.quit);
        timer = findViewById(R.id.Timer);
        restart = findViewById(R.id.restart);


        nbrSec = sharedPreferences.getInt("time", 5);


        quit.setOnClickListener(view -> {
            Intent i = new Intent(GameActivity.this , MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.putExtra("EXIT", true);
            startActivity(i);

        });

        restart.setOnClickListener(view -> {

            handler.removeCallbacksAndMessages(null);


            Game(0);
        });

        Game(0);
    }
    public void Game(int i)   {
        Chord c  = null;
        if (sharedPreferences.getBoolean("upper", false) == false && sharedPreferences.getBoolean("lower", false) == false){
            c = Chord.randomNormalChord();
        }else if (sharedPreferences.getBoolean("lower", false) && sharedPreferences.getBoolean("upper", false)== false) {
            c = Chord.randomLowerChord();
        }else if (sharedPreferences.getBoolean("upper", false) && sharedPreferences.getBoolean("lower", false)== false) {
            c = Chord.randomUpperChord();
        }else {
            c = Chord.randomChord();
        }
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
        handler = new Handler();
        if(j<nbrSec){
            j++;
            int finalj = j;
            handler.postDelayed(() -> waiting(i, finalj), 1000);
        }else{
            Game(i);
        }

    }

    public void displayChord(Chord c){
        System.out.println( "sahred value"+sharedPreferences.getBoolean("french", false));
            if (sharedPreferences.getBoolean("french", false) == false) {
                Note.setText(c.getValue());
            }else {
                System.out.println("in else");
                switch (c.getValue()){
                    case "A":
                        Note.setText("La");
                        break;
                    case "B":
                        Note.setText("Si");
                        break;
                    case "C":
                        Note.setText("Do");
                        break;
                    case "D":
                        Note.setText("Ré");
                        break;
                    case "E":
                        Note.setText("Mi");
                        break;
                    case "F":
                        Note.setText("Fa");
                        break;
                    case "G":
                        Note.setText("Sol");
                        break;
                    default:
                        System.out.println("default");
                        Note.setText(c.getValue());
                }
            }
            Upper.setText(c.getUpper());
            Lower.setText(c.getLower());
    }
}