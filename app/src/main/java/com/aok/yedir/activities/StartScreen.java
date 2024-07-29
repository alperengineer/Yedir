package com.aok.yedir.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.aok.yedir.R;
import com.aok.yedir.databinding.ActivityStartScreenBinding;

public class StartScreen extends AppCompatActivity {
    private ActivityStartScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        EdgeToEdge.enable(this);
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void signUp(View view){
        Intent intent = new Intent(StartScreen.this, SignUp.class);
        startActivity(intent);
        finish();
    }

    public void signIn(View view){
        Intent intent = new Intent(StartScreen.this, SignIn.class);
        startActivity(intent);
        finish();
    }

}