package com.example.food_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.animation.ArgbEvaluator;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    //--------------------------------Variable Declaration------------------------------
    public static final String EXTRA_category="com.example.food_app.EXTRA_category";
    ViewPager viewPager;    //for banner
    Adapter adapter;        //for viewpager
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ArrayList<Integer> banner=new ArrayList<>();
    //ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    //-------------------------------onCreate------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //---------------------------Hook--------------------------------
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        //--------------------------Toolbar-------------------------------
        setSupportActionBar(toolbar);
        //--------------------------Navigation View----------------------------------------------------
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);         //implemented later

        //----------banner array data----------------
        banner.add(R.drawable.banner1);
        banner.add(R.drawable.banner5);
        banner.add(R.drawable.banner2);
        banner.add(R.drawable.banner3);
        banner.add(R.drawable.banner4);

        adapter = new Adapter(banner,this);

        //-----------------View Pager---------------------------
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(50, 0, 50, 0);
        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(new CircularViewPagerHandler(viewPager));

    }


    //-----------To pressing back while Drawer is open ---------------------------------
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    //-----------------------Common Onclick Listener------------------------
    //-----------------------Redirects to Menu Activity---------------------
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Dashboard.this,Menu.class);
        intent.putExtra(EXTRA_category, v.getId());
        startActivity(intent);
    }

    //---------------------Nav Menu item selected----------------------------
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }


    //----------------------For Circular ViewPager-----------------------------
    public static class CircularViewPagerHandler implements ViewPager.OnPageChangeListener {
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


