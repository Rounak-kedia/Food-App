package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.animation.ArgbEvaluator;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_category="com.example.food_app.EXTRA_category";
    ViewPager viewPager;
    ImageView pizza,pasta,burger,sides,dessert,beverages;
    Adapter adapter;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ArrayList<Integer> banner=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        pizza=findViewById(R.id.img_pizza);
        pasta=findViewById(R.id.img_pasta);
        burger=findViewById(R.id.img_burger);
        sides=findViewById(R.id.img_sides);
        dessert=findViewById(R.id.img_dessert);
        beverages=findViewById(R.id.img_beverages);

        banner.add(R.drawable.banner2);
        banner.add(R.drawable.banner8);
        banner.add(R.drawable.banner3);
        banner.add(R.drawable.banner4);
        banner.add(R.drawable.banner5);

        adapter = new Adapter(banner,this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50, 0, 50, 0);
        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(new CircularViewPagerHandler(viewPager));

        Integer[] colors_temp = {
                ContextCompat.getColor(this,R.color.color1),
                ContextCompat.getColor(this,R.color.color2),
                ContextCompat.getColor(this,R.color.color3),
                ContextCompat.getColor(this,R.color.color4)
                //getResources().getColor(R.color.color1),
                //getResources().getColor(R.color.color2),
                //getResources().getColor(R.color.color3),
                //getResources().getColor(R.color.color4)
        };


    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Dashboard.this,Menu.class);
        intent.putExtra("hello",123);
        startActivity(intent);
    }


    //For Circular ViewPager
    public class CircularViewPagerHandler implements ViewPager.OnPageChangeListener {
        private ViewPager   mViewPager;
        private int         mCurrentPosition;
        private int         mScrollState;

        public CircularViewPagerHandler(final ViewPager viewPager) {
            mViewPager = viewPager;
        }

        @Override
        public void onPageSelected(final int position) {
            mCurrentPosition = position;
        }

        @Override
        public void onPageScrollStateChanged(final int state) {
            handleScrollState(state);
            mScrollState = state;
        }

        private void handleScrollState(final int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE && mScrollState == ViewPager.SCROLL_STATE_DRAGGING) {
                setNextItemIfNeeded();
            }
        }

        private void setNextItemIfNeeded() {
            if (!isScrollStateSettling()) {
                handleSetNextItem();
            }
        }

        private boolean isScrollStateSettling() {
            return mScrollState == ViewPager.SCROLL_STATE_SETTLING;
        }

        private void handleSetNextItem() {
            final int lastPosition = mViewPager.getAdapter().getCount() - 1;
            if(mCurrentPosition == 0) {
                mViewPager.setCurrentItem(lastPosition, true);
            } else if(mCurrentPosition == lastPosition) {
                mViewPager.setCurrentItem(0, true);
            }
        }

        @Override
        public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
        }
    }
}


