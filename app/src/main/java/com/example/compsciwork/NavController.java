package com.example.compsciwork;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

public class NavController {

    private Context context;
    private DatabaseManager dbm = new DatabaseManager(context);
    public NavController(Context context) {
        this.context = context;
    }

    public void NavAction(MenuItem item) {
        int itemID= item.getItemId();
        if (itemID==R.id.nav_home) { openHome(); }
        if (itemID==R.id.nav_settings) { openSettings(); }
        if (itemID==R.id.nav_selection) { openSelection(); }
        if (itemID==R.id.nav_logout) { logOut(); }
    }
    private void openHome() {
        startActivity(context, new Intent(context.getApplicationContext(), MainActivity.class), null);

    }

    private void openSettings() {
        startActivity(context, new Intent(context.getApplicationContext(), SettingActivity.class), null);
    }

    private void openSelection() {
        if(dbm.isLoggedIn()) {
            startActivity(context, new Intent(context.getApplicationContext(), SelectionActivity.class), null);
        }
        else {
            Toast.makeText(context, "You must be logged in to perform this function.", Toast.LENGTH_SHORT).show();
        }
    }

    private void logOut() {
        if(dbm.isLoggedIn()) {
            dbm.logOut();
            startActivity(context, new Intent(context.getApplicationContext(), MainActivity.class), null);
        }
        else {
            Toast.makeText(context, "You must be logged in to perform this function.", Toast.LENGTH_SHORT).show();
        }
    }
}
