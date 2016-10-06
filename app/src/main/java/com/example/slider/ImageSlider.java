package com.example.slider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImageSlider extends ViewPager {

    private Context mContext;
    private List<String> mImageUrlList;

    public ImageSlider(Context context) {
        super(context);
        mContext = context;
    }

    public ImageSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        mImageUrlList = imageUrlList;
        setAdapter(new ImagePagerAdapter());
    }

    private class ImagePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mImageUrlList.size();
        }

        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(mContext);
            Glide.with(mContext)
                    .load(mImageUrlList.get(position))
                    .centerCrop()
                    .into(imageView);
//            Picasso.with(mContext)
//                    .load(mImageUrlList.get(position))
//                    .fit()
//                    .centerCrop()
//                    .into(imageView);

            container.addView(imageView);
            return imageView;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ImageView) object);
        }
    }

}
