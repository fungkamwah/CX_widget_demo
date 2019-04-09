## 1 Fragment
如果说一般认为Activity为界面组件的话，那么Fragment就是子界面的组件。


MainActivity.java
```
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
```


layout_main.xml
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <FrameLayout
        android:id="@+id/contentLayout"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"/>

    <android.support.v4.app.FragmentTabHost
        android:id="@android:id/tabhost"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#F6F6F6">

        <FrameLayout
            android:id="@android:id/tabcontent"
            android:layout_width="0dp"
            android:layout_height="0dp" />
    </android.support.v4.app.FragmentTabHost>
</LinearLayout>
```



footer_tabs.xml
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content"
    android:background="#F6F6F6"
    android:gravity="center"
    android:padding="5dp">

    <TextView
        android:id="@+id/tvTab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:layout_marginTop="2dp"
        android:textColor="#AEAEAE" />

</RelativeLayout>
```

BannerFragment.java
```
package net.gzchunxiang.cx_widget_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BannerFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        TextView tvTitle=new TextView(super.getActivity());
        tvTitle.setText("Banner");
        tvTitle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tvTitle.setGravity(Gravity.CENTER);
        tvTitle.setTextSize(30);
        return tvTitle;
    }
    @Override
    public void setArguments(Bundle args) {
        // TODO Auto-generated method stub
        super.setArguments(args);
    }
}

```


ListFragment.java
```
package net.gzchunxiang.cx_widget_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        TextView tvTitle=new TextView(super.getActivity());
        tvTitle.setText("List");
        tvTitle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tvTitle.setGravity(Gravity.CENTER);
        tvTitle.setTextSize(30);
        return tvTitle;
    }
    @Override
    public void setArguments(Bundle args) {
        // TODO Auto-generated method stub
        super.setArguments(args);
    }
}

```


GridFragment.java
```
package net.gzchunxiang.cx_widget_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GridFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        TextView tvTitle=new TextView(super.getActivity());
        tvTitle.setText("Grid");
        tvTitle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tvTitle.setGravity(Gravity.CENTER);
        tvTitle.setTextSize(30);
        return tvTitle;
    }
    @Override
    public void setArguments(Bundle args) {
        // TODO Auto-generated method stub
        super.setArguments(args);
    }
}

```

一个Activity中管理3个Fragment，运行效果。

![image](http://youdao.mikezz.cn/QQ20190322-160359.png-wardo)
![image](http://youdao.mikezz.cn/QQ20190322-160533.png-wardo)

## 2 Banner（ViewPager实现）

BannerFragment用来展示Banner

```
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

```

layout_fragment_banner.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.v4.view.ViewPager
        android:id="@+id/vp"
        android:layout_width="match_parent"
        android:background="#cccccc"
        android:layout_height="200dp">

    </android.support.v4.view.ViewPager>

</LinearLayout>
```

item_pager.xml
```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:background="#ff0000"
    android:layout_width="match_parent" android:layout_height="match_parent">
    <ImageView
        android:id="@+id/iv"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</FrameLayout>
```

## 3 RecyclerView实现List

build.gradle文件中添加库依赖
```
apply plugin: 'com.android.application'

android {
    compileSdkVersion 28
    defaultConfig {
        applicationId "net.gzchunxiang.cx_widget_demo"
        minSdkVersion 21
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    //添加recyclerview依赖
    implementation 'com.android.support:recyclerview-v7:28.0.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
}

```

ListFragment.java
```
package net.gzchunxiang.cx_widget_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Item> items = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.layout_fragment_list, container, false);
        recyclerView = view.findViewById(R.id.rv);

        for (int i = 0; i < 20; i++) {
            Item item = new Item();
            item.imgId = R.mipmap.ic_launcher;
            item.string = "list item " + i;
            items.add(item);
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ListAdapter());

        return view;
    }

    class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.item_list, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            Item item = items.get(i);
            viewHolder.iv.setImageResource(item.imgId);
            viewHolder.tv.setText(item.string);

        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            TextView tv;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                iv = itemView.findViewById(R.id.iv);
                tv = itemView.findViewById(R.id.tv);
            }
        }
    }

    @Override
    public void setArguments(Bundle args) {
        // TODO Auto-generated method stub
        super.setArguments(args);
    }

    class Item {
        int imgId;
        String string;
    }
}

```
layout_fragment_list.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/rv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>



</LinearLayout>
```
item_list.xml
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="100dp">

    <ImageView
        android:id="@+id/iv"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:layout_centerVertical="true"
        android:src="@mipmap/ic_launcher"/>

    <TextView
        android:id="@+id/tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        android:text="text"
        android:layout_toRightOf="@id/iv"/>

    <ImageView
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:src="@color/colorAccent"
        android:layout_alignParentBottom="true"/>

</RelativeLayout>
```

运行效果。

![image](http://youdao.mikezz.cn/QQ20190322-171621.png-wardo)

## 4 RecyclerView 实现Grid网格

GridFragment.java
```
package net.gzchunxiang.cx_widget_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Item> items = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.layout_fragment_list, container, false);
        recyclerView = view.findViewById(R.id.rv);

        for (int i = 0; i < 50; i++) {
            Item item = new Item();
            item.imgId = R.mipmap.ic_launcher;
            item.string = "list item " + i;
            items.add(item);
        }
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ListAdapter());

        return view;
    }

    class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.item_grid, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            Item item = items.get(i);
            viewHolder.iv.setImageResource(item.imgId);
            viewHolder.tv.setText(item.string);

        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            TextView tv;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                iv = itemView.findViewById(R.id.iv);
                tv = itemView.findViewById(R.id.tv);
            }
        }
    }

    @Override
    public void setArguments(Bundle args) {
        // TODO Auto-generated method stub
        super.setArguments(args);
    }

    class Item {
        int imgId;
        String string;
    }
}

```

layout_fragment_grid.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/rv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>



</LinearLayout>
```


item_grid.xml
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="120dp"
    android:layout_height="120dp">

    <ImageView
        android:id="@+id/iv"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:layout_centerInParent="true"
        android:src="@mipmap/ic_launcher"/>

    <TextView
        android:id="@+id/tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:text="text"
        android:layout_below="@id/iv"/>



</RelativeLayout>
```

运行效果。

![image](http://youdao.mikezz.cn/QQ20190322-173508.png-wardo)
