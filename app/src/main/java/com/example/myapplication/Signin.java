package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivitySigninBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Signin extends AppCompatActivity {
    private ActivitySigninBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.editTextTextEmailAddress4.getText().toString().isEmpty() || binding.editTextTextPassword4.getText().toString().isEmpty() || binding.editTextTextPassword5.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "поля заполнены не правильно", Toast.LENGTH_SHORT).show();
                }
                else {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.editTextTextEmailAddress4.getText().toString(),binding.editTextTextPassword4.getText().toString());
                    HashMap<String,String> userInfo = new HashMap<>();
                    userInfo.put("email",binding.editTextTextEmailAddress4.getText().toString());
                    userInfo.put("password",binding.editTextTextPassword4.getText().toString());
                    FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(userInfo);
                    startActivity(new Intent(Signin.this,MainActivity.class));
                }
            }
        });
    }
}