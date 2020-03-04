package com.example.carbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.liste);

        //Data

        final ArrayList<String> carnames = new ArrayList<>();
        carnames.add("PORSCHE 911");
        carnames.add("MERCEDES S63");
        carnames.add("AUDİ RS7");
        carnames.add("BMW M5");

        final ArrayList<String> carinformation = new ArrayList<>();
        carinformation.add("450 bg \t 530 Nm \n 0-100: 3.4 sn \n Top Speed: 304 km/h");
        carinformation.add("612 bg \t 900 Nm \n 0-100: 3.5 sn \n Top Speed: 303 km/h");
        carinformation.add("591 bg \t 800 Nm \n 0-100: 3.6 sn \n Top Speed: 303 km/h");
        carinformation.add("600 bg \t 700 Nm \n 0-100: 3.5 sn \n Top Speed: 302 km/h");

        Bitmap porsche = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.porsche);
        Bitmap mercedes = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.mercedes);
        Bitmap audi = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.audi);
        Bitmap bmw = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.bmw);

        final ArrayList<Bitmap> carimages = new ArrayList<>();

        carimages.add(porsche);
        carimages.add(mercedes);
        carimages.add(audi);
        carimages.add(bmw);


        //Listview

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,carnames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //System.out.println(landmarknames.get(position));
                //System.out.println(countryNames.get(position));

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("CarModelText",carnames.get(position));
                intent.putExtra("CarDetailText",carinformation.get(position));

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(carimages.get(position));

                startActivity(intent);

            }
        });

    }
}
