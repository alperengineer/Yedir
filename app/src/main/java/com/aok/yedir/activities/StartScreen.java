package com.aok.yedir.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.aok.yedir.R;
import com.aok.yedir.databinding.ActivityStartScreenBinding;

public class StartScreen extends AppCompatActivity {
    private ActivityStartScreenBinding binding;
    private AppCompatButton signUpBtn;
    TextView signInText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        EdgeToEdge.enable(this);
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.startScreen), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        signUpBtn = binding.startScreenSignUpBtn;
        signInText = binding.startScreenSignIn;


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInTxt();
            }
        });


    }

    private void signUp(){
        Intent intent = new Intent(StartScreen.this, SignUp.class);
        startActivity(intent);
        finish();
    }

    private void signInTxt(){
        Intent intent = new Intent(StartScreen.this, SignIn.class);
        startActivity(intent);
        finish();
    }

}