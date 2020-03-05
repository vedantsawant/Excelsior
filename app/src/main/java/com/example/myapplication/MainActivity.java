package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(btmnavListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MapFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener btmnavListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selected = new InputFragment();
            switch (menuItem.getItemId()){
                case R.id.report:
                    selected= new InputFragment();
                    break;
                case R.id.records:
                    selected= new DataFragment();
                    break;
                case R.id.location:
                    selected= new MapFragment();
                    break;
                case R.id.graph:
                    selected= new GraphFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                    ,selected).commit();
            return true;
        }
    };
}