package com.my_video_editor_pro.pro.ActivityPhotoVideo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.my_video_editor_pro.pro.UtilsAndAdapters.EditorHelper;
import com.my_video_editor_pro.pro.ActivityMain.ActivityMain;
import com.my_video_editor_pro.pro.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelectImageAndVideo extends AppCompatActivity {
    static final boolean BOOLEAN = true;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] ints = {R.mipmap.icon_video, R.mipmap.icon_myalbum};

    class a extends FragmentPagerAdapter {
        private final List<Fragment> b = new ArrayList();
        private final List<String> c = new ArrayList();

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            return this.b.get(i);
        }

        public int getCount() {
            return this.b.size();
        }

        public void a(Fragment fragment, String str) {
            this.b.add(fragment);
            this.c.add(str);
        }

        public CharSequence getPageTitle(int i) {
            return this.c.get(i);
        }
    }

    @Override public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView( R.layout.activity_status_list);



        Toolbar toolbar = findViewById(R.id.toolbar);
        ((TextView) toolbar.findViewById(R.id.toolbar_title)).setText("Photo To Video Maker");
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (BOOLEAN || supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(BOOLEAN);
            supportActionBar.setDisplayShowTitleEnabled(false);
            this.viewPager = findViewById(R.id.viewpager);
            a(this.viewPager);
            this.tabLayout = findViewById(R.id.tabs);

            this.tabLayout.setupWithViewPager(this.viewPager);
            a();
            return;
        }
        throw new AssertionError();
    }

    private void a() {
        this.tabLayout.getTabAt(0).setIcon(this.ints[0]);
        this.tabLayout.getTabAt(1).setIcon(this.ints[1]);
    }

    private void a(ViewPager viewPager) {
        a aVar = new a(getSupportFragmentManager());
        aVar.a(new FragmentSelectImage(), "CREATE STORY");
        aVar.a(new FragmentMyPhotoToVideo(), "MY ALBUM");
        viewPager.setAdapter(aVar);
    }

    @Override public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return BOOLEAN;
    }

   @Override public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return BOOLEAN;
        }
        if (itemId == R.id.shareapp) {
            StringBuilder sb = new StringBuilder();
            sb.append(EditorHelper.share_string);
            sb.append(EditorHelper.package_name);
            String sb2 = sb.toString();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", sb2);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting()) {
            return false;
        }
        return BOOLEAN;
    }
}
