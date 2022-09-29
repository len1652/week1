package com.ndphuc.dp.week2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtName,txtBirth,txtAbout,lblbar;
    private ImageView imgAvatar,btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        addConTrols();
        addEvents();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle extrasData = getIntent().getExtras();
        Log.i("Man Hinh 2", "Tên người nhập là: "+extrasData.getString("NAME","Name"));
    }

    private void addEvents() {
        thongbaotrenapptionbar();
        bamnutback();
        hienthimanhinh();

    }

    private void bamnutback() {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void thongbaotrenapptionbar() {
        lblbar.setText("Infomation");
    }

    private void hienthimanhinh() {
        Bundle extrasData = getIntent().getExtras();
        txtName.setText(extrasData.getString("NAME","Name"));
        txtBirth.setText(extrasData.getString("BIRTH","Birth"));
        int hinh =0 ;
        hinh = Integer.parseInt(extrasData.getString("AVATAR",String.valueOf(R.drawable.avatar)));
        if(hinh==1){
            imgAvatar.setImageResource(R.drawable.avatar);
        }
        else if(hinh==2){
            imgAvatar.setImageResource(R.drawable.avatargirl);
        }


        txtAbout.setText(extrasData.getString("ABOUT","About"));
    }

    private void addConTrols() {
        txtName = findViewById(R.id.txtName2);
        txtBirth = findViewById(R.id.txtBirth2);
        imgAvatar = findViewById(R.id.imgAvatar);
        txtAbout = findViewById(R.id.txtAbout2);

        lblbar = findViewById(R.id.lblBar);
        btnback = findViewById(R.id.btnBack);
    }
}