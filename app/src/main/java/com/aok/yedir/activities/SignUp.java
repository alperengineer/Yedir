package com.aok.yedir.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.aok.yedir.R;
import com.aok.yedir.databinding.ActivitySignUpBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private TextInputEditText birthDateEditText, passwordEditText, phoneNumberEditText;
    private TextInputLayout passwordLayout, phoneNumberLayout;
    private AppCompatButton signUpBtn;
    private ImageView signUpWithGoogleImg, signUpWithPhoneNumberImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        EdgeToEdge.enable(this);
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signUp), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        phoneNumberEditText = binding.phoneNumberText;
        phoneNumberLayout = binding.phoneNumberLayout;
        birthDateEditText = binding.birthDateText;
        passwordEditText = binding.passwordText;
        passwordLayout = binding.passwordLayout;
        signUpBtn = binding.signUpBtn;
        signUpWithGoogleImg = binding.signUpWithGoogle;
        signUpWithPhoneNumberImg = binding.signUpWithPhoneNumber;

        setupPhoneNumberFormatting();
        passwordCharLengthController();

        birthDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birthDatePicker();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpBtn();
            }
        });

        signUpWithGoogleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpWithGoogle();
            }
        });

        signUpWithPhoneNumberImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpWithPhoneNumber();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SignUp.this, StartScreen.class);
        startActivity(intent);
        finish();
    }

    private void setupPhoneNumberFormatting() {
        phoneNumberEditText.setFilters(new InputFilter[]{
                new InputFilter.LengthFilter("05551112233".length())
        });
    }

    private void birthDatePicker() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(SignUp.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        birthDateEditText.setText(selectedDate);
                    }
                }, year, month, day);

        datePickerDialog.show();
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

    private void signUpBtn(){
        Toast.makeText(this, "Yedir'e kayıt olundu.", Toast.LENGTH_SHORT).show();
    }

    private void signUpWithGoogle(){
        Toast.makeText(this, "Google ile Yedir'e kayıt olundu.", Toast.LENGTH_SHORT).show();
    }

    private void signUpWithPhoneNumber(){
        Toast.makeText(this, "Telefon numarası ile Yedir'e kayıt olundu.", Toast.LENGTH_SHORT).show();
    }

}