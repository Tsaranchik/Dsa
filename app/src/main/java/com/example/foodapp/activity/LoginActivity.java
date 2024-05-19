package com.example.foodapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();

    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(v -> {
            String email = binding.emailEdit.getText().toString();
            String password = binding.passwordEdit.getText().toString();

            if (!email.isEmpty() && !password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                        LoginActivity.this, task -> {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(
                                        LoginActivity.this, "Authentication failed",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }
                        });
            }
            else {
                Toast.makeText(
                        LoginActivity.this, "Please fill all fields",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}