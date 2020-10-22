package com.epic.fooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Address extends AppCompatActivity {

    private Button mAddBtn;
    private EditText mAddressLane1;
    private EditText mAddressLane2;
    private EditText mCity;
    private EditText mState;
    private EditText mCountry;
    private EditText mPincode;

    private FirebaseFirestore mFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        mFirestore = FirebaseFirestore.getInstance();

        mAddressLane1 = (EditText) findViewById(R.id.AddressLane1);
        mAddressLane2 = (EditText) findViewById(R.id.AddressLane2);
        mCity = (EditText) findViewById(R.id.City);
        mState = (EditText) findViewById(R.id.State);
        mCountry = (EditText) findViewById(R.id.Country);
        mPincode = (EditText) findViewById(R.id.Pincode);
        mAddBtn = (Button) findViewById(R.id.AddBtn);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String AddressLane1 = mAddressLane1.getText().toString();
                String AddressLane2 = mAddressLane2.getText().toString();
                String City = mCity.getText().toString();
                String State = mState.getText().toString();
                String Country = mCountry.getText().toString();
                String Pincode = mPincode.getText().toString();
                Map<String, String> userMap = new HashMap<>();

                userMap.put("AddressLane1", AddressLane1);
                userMap.put("AddressLane2", AddressLane2);
                userMap.put("City", City);
                userMap.put("State", State);
                userMap.put("Country", Country);
                userMap.put("Pincode", Pincode);

                mFirestore.collection("Address").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Address.this, "Address Added to Firestore", Toast.LENGTH_SHORT).show();
                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(Address.this, "Error :" + error, Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }


}

