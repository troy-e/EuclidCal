package com.example.euclid;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.euclid.ui.profile.ProfileFragment;
import com.example.euclid.ui.three.ThreeFragment;
import com.example.euclid.ui.two.TwoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.navigation_two) {
                    selectedFragment = new TwoFragment();
                } else if (item.getItemId() == R.id.navigation_three) {
                    selectedFragment = new ThreeFragment();
                } else if (item.getItemId() == R.id.navigation_notifications) {
                    selectedFragment = new ProfileFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
                return true;
            }
        });

        // Set default selection
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_two);
        }
    }
}
