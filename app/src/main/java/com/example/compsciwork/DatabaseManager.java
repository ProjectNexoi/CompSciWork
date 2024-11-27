package com.example.compsciwork;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseManager {

    private Context context;

    private static FirebaseAuth mAuth;
    private static FirebaseDatabase database;
    private static DatabaseReference reference;

    DatabaseManager(Context context){
        this.context = context;
        this.setMAuth(FirebaseAuth.getInstance());
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
    public static FirebaseDatabase getDatabase() {
        if(database == null) {
            database = FirebaseDatabase.getInstance("https://compsciwork-2024-default-rtdb.europe-west1.firebasedatabase.app");
        }
        return database;
    }

    public static DatabaseReference getReference(String ref) {
        reference = getDatabase().getReference(ref);
        return reference;
    }

    public static void setDatabase(FirebaseDatabase database) {
        DatabaseManager.database = database;
    }

    public Boolean isLoggedIn() {
        return getMAuth().getCurrentUser() != null;
    }

    public void setMAuth(FirebaseAuth m) {
        mAuth = m;
    }
    public void makeUser(String email, String password, User user){
        mAuth.signOut();
        this.getMAuth().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(context.getApplicationContext(),"User Creation Successful.",Toast.LENGTH_SHORT).show();
                    user.setUId(task.getResult().getUser().getUid());
                    getReference("users").child(user.getUId()).setValue(user);
                    startActivity(context, new Intent(context, MainActivity.class), null);
                }
                else{
                    Toast.makeText(context.getApplicationContext(),"User Creation Failed: " + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void logIn(String email, String password){
        this.getMAuth().signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(context.getApplicationContext(),"Log In Successful.",Toast.LENGTH_SHORT).show();
                    startActivity(context, new Intent(context, MainActivity.class), null);
                }
                else{
                    Toast.makeText(context.getApplicationContext(),"Log In Failed: " + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void logOut() {
        this.getMAuth().signOut();
    }



}
