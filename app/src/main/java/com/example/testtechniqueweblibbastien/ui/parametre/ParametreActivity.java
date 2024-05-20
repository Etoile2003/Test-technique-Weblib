package com.example.testtechniqueweblibbastien.ui.parametre;

import static com.example.testtechniqueweblibbastien.MainActivity.sharedPreferences;
import static com.example.testtechniqueweblibbastien.MainActivity.editor;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;



import com.example.testtechniqueweblibbastien.R;
import com.example.testtechniqueweblibbastien.databinding.FragmentParametreBinding;
import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ParametreActivity extends Fragment {

    public static RadioButton time5;
    public static RadioButton time10;
    public static RadioButton time15;

    public RadioGroup timeGroup;

    public Switch upperSwitch;
    public Switch lowerSwitch;
    public Switch FrenchSwitch;

    //public static int nbrSec = 5;

private FragmentParametreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);




        binding = FragmentParametreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        timeGroup = root.findViewById(R.id.timeGroup);
        time5 = root.findViewById(R.id.time5);
        time10 = root.findViewById(R.id.time10);
        time15 = root.findViewById(R.id.time15);
        upperSwitch = root.findViewById(R.id.upperSwitch);
        lowerSwitch = root.findViewById(R.id.lowerSwitch);
        FrenchSwitch = root.findViewById(R.id.frenchSwitch);

        upperSwitch.setChecked(sharedPreferences.getBoolean("upper", false));
        lowerSwitch.setChecked(sharedPreferences.getBoolean("lower", false));
        FrenchSwitch.setChecked(sharedPreferences.getBoolean("french", false));

        upperSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            editor.putBoolean("upper", b);
            editor.apply();
        });
        lowerSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            editor.putBoolean("lower", b);
            editor.apply();
        });
        FrenchSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            editor.putBoolean("french", b);
            editor.apply();
        });

        switch (sharedPreferences.getInt("time", 5)){
            case 5:
                time5.setChecked(true);
                break;
            case 10:
                time10.setChecked(true);
                break;
            case 15:
                time15.setChecked(true);
                break;
        }

        timeGroup.setOnCheckedChangeListener((radioGroup, i) -> {
        if (i == R.id.time5 ){

            editor.putInt("time", 5);
            editor.apply();
        }
        if (i == R.id.time10){

            editor.putInt("time", 10);
            editor.apply();
        }
        if(i == R.id.time15){
                editor.putInt("time", 15);
                editor.apply();
        }
    });

    editor.commit();
        //time5.toggle();
        //time10.toggle();
    //time5.toggle();

        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}