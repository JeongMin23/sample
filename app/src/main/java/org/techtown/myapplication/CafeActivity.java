package org.techtown.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CafeActivity extends AppCompatActivity {

    FragmentHome fragmenthome; //가게 홈 화면 프래그먼트 객체
    FragmentMenu fragmentmenu; //메뉴 화면 프래그먼트 객체
    ReviewFragment reviewFragment;
    BottomNavigationView bottomNavigation; //하단바 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        Intent intent = getIntent();
        Cafe cafe = (Cafe) intent.getSerializableExtra("cafe");

        fragmenthome = new FragmentHome();
        fragmentmenu = new FragmentMenu();
        reviewFragment = new ReviewFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmenthome).commit();

        bottomNavigation = findViewById(R.id.bottom_navigation); //하단바 객체
        bottomNavigation.setOnNavigationItemSelectedListener( //하단바 선택 시 각 프래그먼트 화면 띄우기
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.tab_home:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmenthome).commit();

                                return true;
                            case R.id.tab_menu:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentmenu).commit();
                                return true;

                            case R.id.tab_review:
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,reviewFragment).commit();
                                return true;
                        }


                        return false;
                    }
                }
        );

    }
}
