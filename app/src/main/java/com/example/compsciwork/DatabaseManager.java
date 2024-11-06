package com.example.compsciwork;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DatabaseManager {
    public void MakeUser(Context c, User user){
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(c.getApplicationContext(),"User Creation Successful.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(c.getApplicationContext(),"User Creation Failed: " + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}