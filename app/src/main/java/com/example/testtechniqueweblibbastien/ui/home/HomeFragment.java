package com.example.testtechniqueweblibbastien.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testtechniqueweblibbastien.MainActivity;
import com.example.testtechniqueweblibbastien.R;
import com.example.testtechniqueweblibbastien.databinding.FragmentHomeBinding;
import com.example.testtechniqueweblibbastien.ui.game.GameActivity;

public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;

    public Button startButton ;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        /*final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/

        startButton = root.findViewById(R.id.start);
        startButton.setOnClickListener(
                view -> {
                    Intent gameActivity = new Intent(getActivity() , GameActivity.class);
                    startActivity(gameActivity);
                }
        );

        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}