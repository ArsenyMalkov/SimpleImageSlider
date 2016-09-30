package com.example.slider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

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

//        addOnPageChangeListener(new OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

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
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.view_image, container, false);

            ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
            Picasso.with(mContext)
                    .load(mImageUrlList.get(position))
                    .fit()
                    .centerCrop()
                    .into(imageView);

            container.addView(view);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
