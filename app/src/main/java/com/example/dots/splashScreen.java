package com.example.dots;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class splashScreen extends AppCompatActivity {

    ImageView splash,splashBottom;
    Animation anim,animBottom;

    private static final int splash_screen = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        anim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        animBottom = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        splash = findViewById(R.id.imageViewSplash);
        splash.setAnimation(anim);
        splashBottom = findViewById(R.id.imageViewSplashBottom);
        splashBottom.setAnimation(animBottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splashScreen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },splash_screen);
    }
}
