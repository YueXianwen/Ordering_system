package com.example.orderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LandingActivity extends AppCompatActivity {

    private EditText mEtname;
    private EditText mEtpass;
    private Button mBtnLand;
    private Button mBtnCan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        mEtname = findViewById(R.id.name);
        mEtpass = findViewById(R.id.password);
        mBtnLand = findViewById(R.id.btn_land);
        mBtnCan = findViewById(R.id.btn_cancel_1);
        mBtnLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEtname.getText().toString().trim();
                String pass = mEtpass.getText().toString().trim();
                Intent intent = new Intent(LandingActivity.this, MainActivity.class);
                if ((name.length() != 0) && (pass.length() != 0)) {
                    if (name.equals("admin") && pass.equals("123456")) {
                        Toast.makeText(LandingActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LandingActivity.this, "请输入正确的用户名和密码！！", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LandingActivity.this, "请输入！！！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBtnCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LandingActivity.this, "已退出", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}