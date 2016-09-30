package com.example.slider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> imageUrlList = new ArrayList<>();
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");

        ImageSlider imageSlider = (ImageSlider) findViewById(R.id.image_slider);
        imageSlider.setImageUrlList(imageUrlList);

    }

}
