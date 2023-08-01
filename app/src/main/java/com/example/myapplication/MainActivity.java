package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DataBase.NguoiDungDAO;
import com.example.myapplication.Doituong.Account;

public class MainActivity extends AppCompatActivity {

    EditText edtUser , edtPass ;
    NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPass = findViewById(R.id.edtPassword);
        edtUser = findViewById(R.id.edtUserName);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user = edtUser .getText().toString(), pass = edtPass.getText().toString();
                if (user.isEmpty() || pass.isEmpty()){

                    Toast.makeText(MainActivity.this, "Dữ liệu còn trống", Toast.LENGTH_SHORT).show();

                }else {


                    if (nguoiDungDAO.checkTK(user,pass)){
                        startActivity(new Intent(MainActivity.this,TrangChu.class));
                        Toast.makeText(MainActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();

                    }else {

                        Toast.makeText(MainActivity.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });


        findViewById(R.id.tvSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,DangKi.class));

            }
        });


    }
}