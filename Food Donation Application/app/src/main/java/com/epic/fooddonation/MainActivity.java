package com.epic.fooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Address(View view) {
        Intent AddressIntent = new Intent(this, Address.class);
        startActivity(AddressIntent);
    }

    public void location(View view) {
        Intent locationIntent = new Intent(this, location.class);
        startActivity(locationIntent);
    }

    public void profile(View view) {
        Intent locationIntent = new Intent(this, profile.class);
        startActivity(locationIntent);
    }

    public void ItemDetails(View view) {
        Intent ItemDetailsIntent = new Intent(this, ItemDetails.class);
        startActivity(ItemDetailsIntent);
    }
}
