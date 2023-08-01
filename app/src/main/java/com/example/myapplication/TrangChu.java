package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.FragmentPack.GioiThieuSanPhamFragment;
import com.example.myapplication.FragmentPack.QuanLiSanPhamFragment;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;

public class TrangChu extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navigation = findViewById(R.id.navigationView);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(TrangChu.this, drawerLayout, toolbar, R.string.opennav, R.string.closenav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

       // callFragment(new QuanLiSanPhamFragment());

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.quanlisanpham) {

                    callFragment(new QuanLiSanPhamFragment());

                }else if (item.getItemId() == R.id.gioithieu){

                    callFragment(new GioiThieuSanPhamFragment());

                }else if (item.getItemId() == R.id.dangxuat){
                    startActivity(new Intent(TrangChu.this,TestDB.class));
                }

                drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isOpen()) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else {

            super.onBackPressed();
        }
    }

    public void callFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();

    }
}