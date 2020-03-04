package com.example.carbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView landmarkNameText = findViewById(R.id.CarModelText);
        TextView countryNameText =findViewById(R.id.CarDetailText);

        Intent intent =getIntent();
        String CarModelText= intent.getStringExtra("CarModelText");
        landmarkNameText.setText(CarModelText);


        String CarDetailText=intent.getStringExtra("CarDetailText");
        countryNameText.setText(CarDetailText);

       Singleton singleton =Singleton.getInstance();
       imageView.setImageBitmap(singleton.getChosenImage());








    }
}
