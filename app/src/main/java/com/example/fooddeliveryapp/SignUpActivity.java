package com.example.fooddeliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class SignUpActivity extends AppCompatActivity {
    private EditText name, email, street_address, city, zip_code;
    private Button register;
    private RadioButton deliverer, customer, restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        street_address = findViewById(R.id.street_address);
        city = findViewById(R.id.city);
        zip_code = findViewById(R.id.zip_code);
        register = findViewById(R.id.button_register);
        deliverer = findViewById(R.id.radio_deliverer);
        customer = findViewById(R.id.radio_customer);
        restaurant = findViewById(R.id.radio_restaurant);
    }

    @Override
    protected void onStart() {
        super.onStart();

        customer.toggle();

        setDataOnView();
    }

    private void setDataOnView() {
        Intent data = getIntent();
        GoogleSignInAccount gso = data.getParcelableExtra("google_account");

        if (gso.getGivenName() != null && gso.getFamilyName() != null)
            name.setText(gso.getGivenName() + " " + gso.getFamilyName());

        email.setText(gso.getEmail());
    }
}
