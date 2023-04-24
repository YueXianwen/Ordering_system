package com.example.orderingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    private Spinner mspi;
    private String[] strs = {"1号桌", "2号桌", "3号桌", "4号桌", "5号桌", "6号桌", "7号桌", "8号桌", "9号桌", "10号桌"};
    private ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setIcon(R.mipmap.ic_coffee);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        Button btn_order = findViewById(R.id.btn_order1);
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mspi = findViewById(R.id.spi);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, strs);
        mspi.setAdapter(arrayAdapter);
        mspi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(OrderActivity.this,"您选择了"+strs[i],Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                this.finish();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}