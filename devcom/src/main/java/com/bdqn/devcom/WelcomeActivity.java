package com.bdqn.devcom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        RelativeLayout startView = (RelativeLayout) findViewById(R.id.startView);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f,1.0f);
        alphaAnimation.setDuration(800);
        startView.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                redirectTo();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void redirectTo() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
