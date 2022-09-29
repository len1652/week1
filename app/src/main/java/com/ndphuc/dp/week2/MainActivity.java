package com.ndphuc.dp.week2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtName,edtBirth,edtAbout,edtAvatar;
    private Button btnShow;

    String chuoi="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //action bar
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();




        //Remove notification bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }
    @Override
    protected void onPause() { // tat phan mem thi luu trang thai
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences(chuoi,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name",edtName.getText().toString());
        editor.putString("Birth",edtBirth.getText().toString());
        editor.putString("Avatar",edtAvatar.getText().toString());
        editor.putString("About",edtAbout.getText().toString());

        editor.commit();
    }

    @Override
    protected void onResume() { //bat dau phan mem thi phuc hoi trang thai
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences(chuoi,MODE_PRIVATE);
        String name = sharedPreferences.getString("Name","");
        String birth = sharedPreferences.getString("Birth","");
        String avtar = sharedPreferences.getString("Avatar","");
        String about = sharedPreferences.getString("About","");
        edtName.setText(name);
        edtBirth.setText(birth);
        edtAvatar.setText(avtar);
        edtAbout.setText(about);

    }
    private void addEvents() {
        bamnutshow();
    }

    private void bamnutshow() {
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"da bam nut", Toast.LENGTH_SHORT).show();
                boolean check ;
                check = kiemtra();
                if(check==false){
                    Toast.makeText(MainActivity.this,"Chua nhap du thong tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    chuyenmanhinh();
                }

            }
        });
    }

    private void chuyenmanhinh() {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("NAME",edtName.getText().toString());
        intent.putExtra("BIRTH",edtBirth.getText().toString());
        intent.putExtra("AVATAR",edtAvatar.getText().toString());
        intent.putExtra("ABOUT",edtAbout.getText().toString());
        startActivity(intent);
    }

    private boolean kiemtra() {
        if(edtName.getText().toString().equals("")||
                edtBirth.getText().toString().equals("")||
                edtAvatar.getText().toString().equals("")){
            return false;
        }else{
            return true;
        }
    }

    private void addControls() {
        edtName = findViewById(R.id.txtName);
        edtBirth = findViewById(R.id.txtBirth);
        edtAvatar = findViewById(R.id.txtAvatar);
        edtAbout = findViewById(R.id.txtAbout);
        btnShow = findViewById(R.id.btnShow);
    }
}