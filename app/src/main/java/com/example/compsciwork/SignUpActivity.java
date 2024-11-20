package com.example.compsciwork;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        InfoValidator validator = new InfoValidator();
        TextView errorReturn = findViewById(R.id.ErrorReturn);
        TextInputEditText username = findViewById(R.id.SUUsernameField);
        TextInputEditText password = findViewById(R.id.SUPasswordField);
        TextInputEditText email = findViewById(R.id.SUEmailField);

        Button signup = findViewById(R.id.SUButton);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorReturn.setVisibility(View.GONE);
                if(!validator.CheckUsername(username.getText().toString())){
                    errorReturn.setText("Username length must be greater or equal to five.");
                    errorReturn.setVisibility(View.VISIBLE);
                } else if(!validator.CheckPassword(password.getText().toString())){
                    errorReturn.setText("Password length must be greater or equal to eight.");
                    errorReturn.setVisibility(View.VISIBLE);
                } else if(!validator.CheckEmail(email.getText().toString())){
                    errorReturn.setText("Provided Email is not valid.");
                    errorReturn.setVisibility(View.VISIBLE);
                } else {
                    //Toast toast = Toast.makeText(SignUpActivity.this,"All inputs validated.",Toast.LENGTH_SHORT).show();
                    User user = new User(username.getText().toString(),email.getText().toString());
                    DatabaseManager dbm = new DatabaseManager(SignUpActivity.this);
                    dbm.makeUser(email.getText().toString(),password.getText().toString(), user);
                }
            }
        });

        Button login = findViewById(R.id.LIButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
            }
        });
    }

    public void GotoLogIn(View view) {
        startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_nav_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        NavController nc = new NavController(this);
        nc.NavAction(item);
        return super.onOptionsItemSelected(item);
    }
}