package com.example.slider;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class ImageIndicator extends LinearLayout implements OnPageChangeListener {

    private Context mContext;

//    private ImageSlider mImageSlider;

    private int mPreviousPosition = 0;

    public ImageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
    }

    public void setImageSlider(ImageSlider imageSlider) {
//        this.mImageSlider = imageSlider;

        int imageCount = imageSlider.getImageUrlList().size();

        imageSlider.addOnPageChangeListener(this);
        for (int i = 0; i < imageCount; i++) {
            View circleView = new View(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(8, 8);
            if (i == 0) {
                params.setMargins(8, 8, 4, 8);
            } else if (i == imageCount - 1) {
                params.setMargins(4, 8, 8, 8);
            } else {
                params.setMargins(4, 8, 4, 8);
            }
            circleView.setLayoutParams(params);

            if (i == imageSlider.getCurrentItem()) {
                circleView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.indicator_circle_selected));
            } else {
                circleView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.indicator_circle));
            }
            addView(circleView);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        getChildAt(position).setBackground(ContextCompat.getDrawable(mContext, R.drawable.indicator_circle_selected));
        getChildAt(mPreviousPosition).setBackground(ContextCompat.getDrawable(mContext, R.drawable.indicator_circle));
        mPreviousPosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
