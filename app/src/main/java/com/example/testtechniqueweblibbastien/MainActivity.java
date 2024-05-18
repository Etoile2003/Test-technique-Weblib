package com.example.testtechniqueweblibbastien;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testtechniqueweblibbastien.databinding.ActivityMainBinding;
import com.example.testtechniqueweblibbastien.ui.game.GameActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding binding;

    public Button startButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home,R.id.navigation_home , R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.mainPage);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        startButton = findViewById(R.id.start);
        startButton.setOnClickListener(
                view -> {
                    Intent gameActivity = new Intent(MainActivity.this , GameActivity.class);
                    startActivity(gameActivity);
                }
        );
    }


}