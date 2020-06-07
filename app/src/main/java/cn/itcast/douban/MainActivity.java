package cn.itcast.douban;

import android.content.Intent;
import android.content.Context;

import androidx.fragment.app.Fragment;;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import androidx.appcompat.widget.Toolbar;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{













    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
            public void Regist(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, RegistActivity.class);
                startActivity(intent);
            }
            public void Login(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }












}




