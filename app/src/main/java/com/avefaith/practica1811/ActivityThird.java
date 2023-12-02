package com.avefaith.practica1811;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.avefaith.practica1811.databinding.ActivitySecondBinding;
import com.avefaith.practica1811.databinding.ActivityThirdBinding;

public class ActivityThird extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThirdBinding binding = ActivityThirdBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.BT31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThird.this, MainActivity.class);
                startActivityForResult(intent, MainActivity.REQUESTCODE);
            }
        });

        binding.BT32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThird.this, ActivitySecond.class);
                startActivityForResult(intent, MainActivity.REQUESTCODE);
            }
        });

        binding.BACK3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.key, "from Activity third");
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