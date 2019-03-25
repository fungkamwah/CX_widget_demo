package net.gzchunxiang.cx_widget_demo;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends FragmentActivity
        implements TabHost.OnTabChangeListener {
    private FragmentTabHost tabHost;

    String tabs[] = new String[]{"轮播", "列表", "宫格"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = (FragmentTabHost) super.findViewById(android.R.id.tabhost);
        tabHost.setup(this, super.getSupportFragmentManager()
                , R.id.contentLayout);
        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.setOnTabChangedListener(this);
        initTab();

    }

    private void initTab() {

        Class fragments[] = {BannerFragment.class, ListFragment.class, GridFragment.class};
        for (int i = 0; i < tabs.length; i++) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabs[i]).setIndicator(getTabView(i));
            tabHost.addTab(tabSpec, fragments[i], null);
            tabHost.setTag(i);
        }
    }

    private View getTabView(int idx) {
        View view = LayoutInflater.from(this).inflate(R.layout.footer_tabs, null);
        ((TextView) view.findViewById(R.id.tvTab)).setText(tabs[idx]);
        if (idx == 0) {
            ((TextView) view.findViewById(R.id.tvTab)).setTextColor(Color.RED);
        } else {
        }
        return view;
    }

    @Override
    public void onTabChanged(String tabId) {
        // TODO Auto-generated method stub
        updateTab();
    }

    private void updateTab() {
        TabWidget tabw = tabHost.getTabWidget();
        for (int i = 0; i < tabw.getChildCount(); i++) {
            View view = tabw.getChildAt(i);
            if (i == tabHost.getCurrentTab()) {
                ((TextView) view.findViewById(R.id.tvTab)).setTextColor(Color.RED);
            } else {
                ((TextView) view.findViewById(R.id.tvTab)).setTextColor(Color.parseColor("#aaaaaa"));
            }

        }
    }

}