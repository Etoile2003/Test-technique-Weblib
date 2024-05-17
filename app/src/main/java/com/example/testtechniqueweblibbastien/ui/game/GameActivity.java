package com.example.testtechniqueweblibbastien.ui.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testtechniqueweblibbastien.R;
import com.example.testtechniqueweblibbastien.databinding.FragmentGameBinding;

import android.widget.Button;

public class GameActivity extends AppCompatActivity {


    public TextView Note ;
    public TextView Upper;
    public TextView Lower;
    public TextView count ;
    public Button quit ;
    public int nbrNote = 10;
private FragmentGameBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws InterruptedException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_game);
        Note = findViewById(R.id.Note);
        Upper = findViewById(R.id.Upper);
        Lower = findViewById(R.id.Lower);
        count = findViewById(R.id.ChordCount);
        quit =  findViewById(R.id.quit);


        binding = FragmentGameBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        Game();
            return root;
        }
    public void Game() throws InterruptedException {
        int i = 0 ;
        while (i < nbrNote){
            Chord c = Chord.randomChord();
            i++;
            count.setText(i);
            Thread.sleep(1000);

        }

    }

    public void displayChord(Chord c){
            Note.setText(c.getValue());



    }


}