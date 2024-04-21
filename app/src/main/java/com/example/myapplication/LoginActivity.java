package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login);

        binding.LoginBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.editTextTextEmailAddress.getText().toString().isEmpty() || binding.editTextTextPassword.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"пожаулуйста заплните все поля",Toast.LENGTH_SHORT).show();
                }
                else{
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.editTextTextEmailAddress.getText().toString(),binding.editTextTextPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                    }
                                }
                            });
                }
            }
        }));
    }

    public  void startnewactivtysign(View v) {
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);
    }

}