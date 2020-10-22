package com.epic.fooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpenningPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openning_page);

    }

    public void Register(View view) {
        Intent LoginRegisterIntent = new Intent(OpenningPage.this, Register.class);
        startActivity(LoginRegisterIntent);

    }

}

