package com.example.carbook;

import android.graphics.Bitmap;

public class Singleton {

    private Bitmap chosenImage;
    public static Singleton singleton;

    private Singleton(){


    }

    public Bitmap getChosenImage() { return chosenImage; }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;
    }

    public static Singleton getInstance() { //Singleton object return.
        if(singleton==null){
            singleton =new Singleton();
        }
                 return singleton;

    }
}
