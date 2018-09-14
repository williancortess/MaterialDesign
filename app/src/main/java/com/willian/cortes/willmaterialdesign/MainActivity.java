package com.willian.cortes.willmaterialdesign;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;

            case R.id.text_menu:{
                Intent intent = new Intent(this, TextFieldActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_menu:{
                Intent intent = new Intent(this, ButtonsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_dialog:{
                Intent intent = new Intent(this, DialogActivity.class);
                startActivity(intent);
                break;
            }

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_text:{
                Intent intent = new Intent(this, TextFieldActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_button:{
                Intent intent = new Intent(this, ButtonsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_dialog:{
                Intent intent = new Intent(this, DialogActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_controls:{
                Intent intent = new Intent(this, SelectionControlsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_snack:{
                Intent intent = new Intent(this, SnackActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_progress:{
                Intent intent = new Intent(this, ProgressActivity.class);
                startActivity(intent);
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
