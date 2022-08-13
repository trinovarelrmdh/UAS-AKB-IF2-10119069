package com.example.uas_akb_if2_10119069;
/**
 * Nama : Tri Novarel Rahmadhani
 * Kelas : IF2
 * NIM :10119069
 * Email : varelrahmadhani12@gmail.com
 * **/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import com.example.uas_akb_if2_10119069.mynote.FragmentMynote;
import com.example.uas_akb_if2_10119069.ui.AboutActivity;
import com.example.uas_akb_if2_10119069.ui.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomnavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize fragment
//        Fragment fragment = new MyLocationFragment();
//
//        //open Fragment
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_container,fragment)
//                .commit();

        bottomnavigation = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentMynote()).commit();
        bottomnavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        selectedFragment = new FragmentMynote();
                        break;
                    case R.id.profile:
                        selectedFragment = new ProfileActivity();
                        break;
                    case R.id.about:
                        selectedFragment = new AboutActivity();
                        break;
                    case R.id.logout:
                        selectedFragment = new LogoutActivity();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });


    }}
