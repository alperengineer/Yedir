package com.aok.yedir.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.aok.yedir.R;
import com.aok.yedir.databinding.ActivitySignInBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignIn extends AppCompatActivity {
    private ActivitySignInBinding binding;
    private TextInputEditText passwordEditText;
    private TextInputLayout passwordLayout;
    private AppCompatButton signInBtn;
    private ImageView signInWithGoogleImg, signInWithPhoneNumberImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        EdgeToEdge.enable(this);
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signIn), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        passwordEditText = binding.passwordText;
        passwordLayout = binding.passwordLayout;
        signInBtn = binding.signInBtn;
        signInWithGoogleImg = binding.signInWithGoogle;
        signInWithPhoneNumberImg = binding.signInWithPhoneNumber;

        passwordCharLengthController();

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInBtn();
            }
        });

        signInWithGoogleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInWithGoogle();
            }
        });

        signInWithPhoneNumberImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInWithPhoneNumber();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SignIn.this, StartScreen.class);
        startActivity(intent);
        finish();
    }

    private void passwordCharLengthController() {
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 6)
                    passwordLayout.setHelperText("Parolanız minimum 6 karakter içermelidir");
                else
                    passwordLayout.setHelperText(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() < 6)
                    passwordLayout.setError("Parolanız minimum 6 karakter içermelidir");
                else
                    passwordLayout.setError(null);
            }


        });
    }

    private void signInBtn(){
        Toast.makeText(this, "Yedir'e Hoşgeldin", Toast.LENGTH_SHORT).show();
    }

    private void signInWithGoogle(){
        Toast.makeText(this, "Yedir'e Google ile giriş yapıldı.", Toast.LENGTH_SHORT).show();
    }

    private void signInWithPhoneNumber(){
        Toast.makeText(this, "Yedir'e telefon numarası ile giriş yapıldı", Toast.LENGTH_SHORT).show();
    }
}