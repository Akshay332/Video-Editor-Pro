package com.my_video_editor_pro.pro.ActivityMusicList;

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

public class ActivityMusicList extends AppCompatActivity {
    static final boolean BOOLEAN = true;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] ints = {R.mipmap.icon_music, R.mipmap.icon_music};

    class a extends FragmentPagerAdapter {
        private final List<Fragment> arrayList = new ArrayList();
        private final List<String> arrayList1 = new ArrayList();

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            return this.arrayList.get(i);
        }

        public int getCount() {
            return this.arrayList.size();
        }

        public void a(Fragment fragment, String str) {
            this.arrayList.add(fragment);
            this.arrayList1.add(str);
        }

        public CharSequence getPageTitle(int i) {
            return this.arrayList1.get(i);
        }
    }

    @Override public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView( R.layout.activity_status_list);
        Toolbar toolbar = findViewById(R.id.toolbar);


        TextView textView = toolbar.findViewById(R.id.toolbar_title);
        if (EditorHelper.ModuleId == 18) {
            textView.setText("Audio Compressor");
        } else if (EditorHelper.ModuleId == 19) {
            textView.setText("Audio Joiner");
        } else if (EditorHelper.ModuleId == 20) {
            textView.setText("Audio Cutter");
        }
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
        aVar.a(new FragmentSelectMusic(), "LIST MUSIC");
        aVar.a(new FragmentMyMusic(), "MY ALBUM");
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
