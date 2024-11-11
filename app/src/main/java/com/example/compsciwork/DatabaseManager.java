package com.example.compsciwork;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DatabaseManager {

    private Context context;

    private FirebaseAuth mAuth;
    DatabaseManager(Context c){
        this.context = c;
        this.mAuth = FirebaseAuth.getInstance();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    public FirebaseAuth getMAuth() {
        if(mAuth == null){
            mAuth = FirebaseAuth.getInstance();
        }
        return mAuth;
    }

    public void setMAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }
    public void makeUser(User user){
        this.mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(context.getApplicationContext(),"User Creation Successful.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context.getApplicationContext(),"User Creation Failed: " + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void logIn(User user){
        this.mAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(context.getApplicationContext(),"Log In Successful.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context.getApplicationContext(),"Log In Failed: " + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
