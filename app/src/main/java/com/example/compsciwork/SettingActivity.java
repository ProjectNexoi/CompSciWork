package com.example.compsciwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class
SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_nav_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID= item.getItemId();
        if (itemID==R.id.nav_home)
            openHome();
        if (itemID==R.id.nav_settings)
            openSettings();
        if(itemID==R.id.nav_selection)
            openSelection();
        if(itemID==R.id.nav_logout)
            logOut();
        return super.onOptionsItemSelected(item);
    }

    private void openHome() {
        Intent i;
        i=new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void openSettings() {
        Intent i;
        i=new Intent(this, SettingActivity.class);
        startActivity(i);
    }

    private void openSelection() {
        Intent i;
        i=new Intent(this, SelectionActivity.class);
        startActivity(i);
    }

    private void logOut() {

    }
}