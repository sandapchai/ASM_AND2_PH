package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DataBase.NguoiDungDAO;
import com.example.myapplication.Doituong.Account;

public class DangKi extends AppCompatActivity {

    EditText edtUser , edtPass ;
    NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(this);
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        
        edtUser = findViewById(R.id.edtUserNameSignUp);
        edtPass = findViewById(R.id.edtPasswordSignUp);
        
        findViewById(R.id.btnSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String user = edtUser .getText().toString(), pass = edtPass.getText().toString();
                
                if (user.isEmpty() || pass.isEmpty()){

                    Toast.makeText(DangKi.this, "Dữ liệu còn1 trống", Toast.LENGTH_SHORT).show();
                    
                }else {
                    
                    if (nguoiDungDAO.addNguoiDung(new Account(user,pass))){
                        startActivity(new Intent(DangKi.this, TrangChu.class));
                        Toast.makeText(DangKi.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                        
                    }else {

                        Toast.makeText(DangKi.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                    }
                    
                    
                }
                
                
            }
        });
        
    }
}