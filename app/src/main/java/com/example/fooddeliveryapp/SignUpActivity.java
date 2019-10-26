package com.example.fooddeliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class SignUpActivity extends AppCompatActivity {
    private Button signOut;
    private TextView email, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.email_text);
        username = findViewById(R.id.username_text);
        signOut = findViewById(R.id.sign_out_button);

        email.setText("Email");
        username.setText("Username");
        signOut.setText("Sign out");
    }

    @Override
    protected void onStart() {
        super.onStart();

        setDataOnView();
    }

    private void setDataOnView() {
        Intent data = getIntent();
        GoogleSignInAccount gso = data.getParcelableExtra("google_account");

        username.setText(gso.getDisplayName());
        email.setText(gso.getEmail());
    }
}
