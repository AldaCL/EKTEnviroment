package com.aladar.ektenviroment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //getSupportFragmentManager().beginTransaction().replace(R.id.freim_fragment_container, new ScanFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.nav_scan:
                    selectedFragment = new ScanFragment();
                    break;

                case R.id.nav_profile:
                    selectedFragment = new FAvoritesFragment();
                    break;

                case R.id.nav_ofertas:
                    selectedFragment = new OfersFragment();
                    break;



            }
            getSupportFragmentManager().beginTransaction().replace(R.id.freim_fragment_container, selectedFragment).commit();

            return true;
        }
    };
}
