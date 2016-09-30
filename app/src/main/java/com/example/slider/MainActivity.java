package com.example.slider;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

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

        final ImageSlider imageSlider = (ImageSlider) findViewById(R.id.image_slider);
        imageSlider.setImageUrlList(imageUrlList);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(8, 8);
        params.setMargins(4, 8, 4, 8);
        for (int i = 0; i < imageUrlList.size(); i++) {
            View circleView = new View(MainActivity.this);
            if (i == imageSlider.getCurrentItem()) {
                circleView.setBackground(getResources().getDrawable(R.drawable.indicator_circle_selected));
            } else {
                circleView.setBackground(getResources().getDrawable(R.drawable.indicator_circle));
            }
            circleView.setLayoutParams(params);
            linearLayout.addView(circleView);
        }
        imageSlider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                linearLayout.removeAllViews();
                for (int i = 0; i < imageUrlList.size(); i++) {
                    View circleView = new View(MainActivity.this);
                    if (i == imageSlider.getCurrentItem()) {
                        circleView.setBackground(getResources().getDrawable(R.drawable.indicator_circle_selected));
                    } else {
                        circleView.setBackground(getResources().getDrawable(R.drawable.indicator_circle));
                    }
                    circleView.setLayoutParams(params);
                    linearLayout.addView(circleView);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
