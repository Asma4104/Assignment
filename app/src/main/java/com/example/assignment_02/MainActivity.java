package com.example.assignment_02;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Show default fragment first
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new DepartmentFragment())
                .commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.nav_department) {
                selectedFragment = new DepartmentFragment();
            }
            else if (item.getItemId() == R.id.nav_teacher) {
                selectedFragment = new TeacherFragment();
            } else if (item.getItemId()== R.id.nav_course) {
                selectedFragment = new CourseFragment();
            }else
                selectedFragment = new StudentFragment();

            if (selectedFragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });
    }
}
