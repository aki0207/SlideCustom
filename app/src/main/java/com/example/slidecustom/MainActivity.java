package com.example.slidecustom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<LinearLayout> ls = new ArrayList<LinearLayout>();

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);

        PagerAdapter mPagerAdapter = new MyPagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);


    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            // レイアウトファイル名を配列で指定します。
            //int[] pages = {R.layout.page1, R.layout.page2, R.layout.page3};
            //ソースでつくったレイアウトを使用する

            Context context = getApplicationContext();
            LinearLayout l1 = new LinearLayout(context);
            LinearLayout l2 = new LinearLayout(context);
            LinearLayout l3 = new LinearLayout(context);

            TextView t1 = new TextView(context);
            TextView t11 = new TextView(context);
            TextView t2 = new TextView(context);
            TextView t3 = new TextView(context);

            //機種によってはテーマの兼ね合いで文字色が白になってしまうため明示的に色指定
            t1.setText("天才");
            t1.setTextColor(Color.BLACK);
            t11.setText("の遊び");
            t11.setTextColor(Color.BLACK);
            t2.setText("凡人");
            t2.setTextColor(Color.BLACK);
            t3.setText("無能");
            t3.setTextColor(Color.BLACK);
            l1.addView(t1);
            l1.addView(t11);
            l2.addView(t2);
            l3.addView(t3);

            //LinearLayout[] ls = {l1,l2,l3,l1};
            ls = new ArrayList<LinearLayout>();
            ls.add(l1);
            ls.add(l2);
            ls.add(l3);


            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View layout;

            //layout = inflater.inflate(page[position], null);
            layout = ls.get(position);


            ((ViewPager) container).addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }

        @Override
        public int getCount() {
            // ページ数を返します。
            int count = 0;
            if (ls.size() == 0) {

                count = 3;

            } else {

                count = ls.size();

            }
            return count;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }
    }
}