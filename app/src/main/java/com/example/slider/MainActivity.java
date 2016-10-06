package com.example.slider;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");
        imageUrlList.add("http://assets.barcroftmedia.com.s3-website-eu-west-1.amazonaws.com/assets/images/recent-images-11.jpg");
        imageUrlList.add("http://kurld.com/images/wallpapers/images/images-22.jpg");
        imageUrlList.add("http://i164.photobucket.com/albums/u8/hemi1hemi/COLOR/COL9-6.jpg");

        final ImageSlider imageSlider = (ImageSlider) findViewById(R.id.image_slider);
        imageSlider.setImageUrlList(imageUrlList);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);

        for (int i = 0; i < imageUrlList.size(); i++) {
            View circleView = new View(MainActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(8, 8);
            if (i == 0) {
                params.setMargins(8, 8, 4, 8);
            } else if (i == imageUrlList.size() - 1) {
                params.setMargins(4, 8, 8, 8);
            } else {
                params.setMargins(4, 8, 4, 8);
            }
            circleView.setLayoutParams(params);
            if (i == imageSlider.getCurrentItem()) {
                circleView.setBackground(ContextCompat.getDrawable(this, R.drawable.indicator_circle_selected));
            } else {
                circleView.setBackground(ContextCompat.getDrawable(this, R.drawable.indicator_circle));
            }
            linearLayout.addView(circleView);
        }
        imageSlider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int previousPosition = 0;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d("TEST", String.valueOf(positionOffset));
//                Log.d("TEST", String.valueOf(positionOffsetPixels));
//                if (position == 2) {
//                    imageSlider.setCurrentItem(0, true);
//                }
            }

            @Override
            public void onPageSelected(int position) {
                linearLayout.getChildAt(position).setBackground(getResources().getDrawable(R.drawable.indicator_circle_selected));
                linearLayout.getChildAt(previousPosition).setBackground(getResources().getDrawable(R.drawable.indicator_circle));
                previousPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                if (state == 1 && previousPosition == 2) {
//                    imageSlider.setCurrentItem(0, false);
//                }
            }
        });

    }

}
