package net.gzchunxiang.cx_widget_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class BannerFragment extends Fragment {
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.layout_fragment_banner, container, false);
        viewPager = view.findViewById(R.id.vp);

        //搞三个子页
        ArrayList<View> vs = new ArrayList<>();
        View v1 = inflater.inflate(R.layout.item_pager, null);
        ImageView iv1 = v1.findViewById(R.id.iv);
        iv1.setImageResource(R.color.colorAccent);
        View v2 = inflater.inflate(R.layout.item_pager, null);
        ImageView iv2 = v2.findViewById(R.id.iv);
        iv2.setImageResource(R.color.colorPrimary);
        View v3 = inflater.inflate(R.layout.item_pager, null);
        ImageView iv3 = v3.findViewById(R.id.iv);
        iv3.setImageResource(R.color.colorPrimaryDark);
        vs.add(v1);
        vs.add(v2);
        vs.add(v3);

        MyAdapter adapter = new MyAdapter(vs);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(changeListener);
        return view;

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    class MyAdapter extends PagerAdapter {
        List<View> viewLists;

        @Override
        public int getCount() {
            return viewLists.size();
        }

        public MyAdapter() {

        }

        public MyAdapter(ArrayList<View> viewLists) {
            super();
            this.viewLists = viewLists;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewLists.get(position));
            return viewLists.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewLists.get(position));
        }
    }

    @Override
    public void setArguments(Bundle args) {
        // TODO Auto-generated method stub
        super.setArguments(args);
    }
}
