package com.realmucho.prokatproject.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.realmucho.prokatproject.fragments.add_fragments.GoodsFragment;
import com.realmucho.prokatproject.fragments.add_fragments.RealtyFragment;
import com.realmucho.prokatproject.fragments.add_fragments.ServiceFragment;
import com.realmucho.prokatproject.fragments.add_fragments.TransportFragment;
import com.realmucho.prokatproject.R;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();
        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();


    }


    /**Sets TabLayout's icons*/
    private void setupTabIcons() {
        mTabLayout.getTabAt(0).setIcon(R.drawable.goods_icon_change);
        mTabLayout.getTabAt(1).setIcon(R.drawable.transport_icon_change);
        mTabLayout.getTabAt(2).setIcon(R.drawable.realty_icon_change);
        mTabLayout.getTabAt(3).setIcon(R.drawable.service_icon_change);


    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.add_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
    }

/**Sets ViewPagers fragments*/
    private void setupViewPager(ViewPager viewPager) {
        AddPagerAdapter adapter = new AddPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GoodsFragment());
        adapter.addFragment(new TransportFragment());
        adapter.addFragment(new RealtyFragment());
        adapter.addFragment(new ServiceFragment());
        viewPager.setAdapter(adapter);
    }


    /**This is adapter for ViewPager*/
    class AddPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public AddPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);

        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


    }


}
