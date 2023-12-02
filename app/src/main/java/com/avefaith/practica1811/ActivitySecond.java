package com.avefaith.practica1811;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.avefaith.practica1811.databinding.ActivityMainBinding;
import com.avefaith.practica1811.databinding.ActivitySecondBinding;

public class ActivitySecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.BT21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySecond.this, MainActivity.class);
                startActivityForResult(intent, MainActivity.REQUESTCODE);
            }
        });

        binding.BT22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySecond.this, ActivityThird.class);
                startActivityForResult(intent, MainActivity.REQUESTCODE);
            }
        });

        binding.BACK2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.key, "from Activity second");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String str = data.getStringExtra(MainActivity.key);
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}