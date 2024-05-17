package com.example.testtechniqueweblibbastien.ui.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testtechniqueweblibbastien.R;
import com.example.testtechniqueweblibbastien.databinding.FragmentGameBinding;
import com.example.testtechniqueweblibbastien.ui.game.Chord;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameFragment extends Fragment {

    public TextView Note ;
    public TextView Upper;
    public TextView Lower;

    public int nbrNote = 10;
private FragmentGameBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentGameBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
    setContentView(R.layout.activity_main);
    Note = findViewById()

    Game();
        return root;
    }
    public void Game(){
        int i = 0 ;
        while (i < nbrNote){
            Chord c = Chord.randomChord();


        }

    }

    public void displayChord(Chord c){

        if (c.)


    }



@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}