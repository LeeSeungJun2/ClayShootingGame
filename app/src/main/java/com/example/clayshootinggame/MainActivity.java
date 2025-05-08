package com.example.clayshootinggame;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv_gun;
    ImageView iv_clay;
    ImageView iv_bullet;

    int screen_width, screen_height;

    float gun_width, gun_height;
    float bullet_width, bullet_height;
    float clay_width, clay_height;

    float bullet_center_x, bullet_center_y;
    float clay_center_x, clay_center_y;

    float gun_x, gun_y;
    float gun_center_x;

    final int NO_OF_CLAYS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        ConstraintLayout layout = findViewById(R.id.main);
        iv_gun = new ImageView(this);
        iv_bullet = new ImageView(this);
        iv_clay = new ImageView(this);

        iv_gun.setImageResource(R.drawable.gun);
        iv_gun.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        gun_height = iv_gun.getMeasuredHeight();
        gun_width = iv_gun.getMeasuredWidth();
        layout.addView(iv_gun);

        iv_bullet.setImageResource(R.drawable.bullet);
        iv_bullet.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        bullet_height = iv_bullet.getMeasuredHeight();
        bullet_width = iv_bullet.getMeasuredWidth();
        iv_bullet.setVisibility(View.INVISIBLE);
        layout.addView(iv_bullet);

        iv_clay.setImageResource(R.drawable.clay);
        iv_clay.setScaleX(0.8f);
        iv_clay.setScaleY(0.8f);
        iv_clay.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        clay_height = iv_clay.getMeasuredHeight();
        clay_width = iv_clay.getMeasuredWidth();
        layout.addView(iv_clay);
        iv_clay.setX(0f);
        iv_clay.setY(0f);

        screen_height = Resources.getSystem().getDisplayMetrics().heightPixels;
        screen_width = Resources.getSystem().getDisplayMetrics().widthPixels;

        gun_center_x = screen_width * 0.7f;
        gun_x = gun_center_x - gun_width * 0.5f;
        gun_y = screen_height - gun_height;
        iv_gun.setX(gun_x);
        iv_gun.setY(gun_y);

        iv_gun.setClickable(true);
        iv_gun.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnStart)
            gameStart();
        else if (id == R.id.btnStop)
            gameStop();
        else if (v == iv_gun)
            shootingStart();

        }

    private void shootingStart() {
    }

    private void gameStop() {
        finish();
    }

    private void gameStart() {

    }

}
}