package com.example.fragmentsnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        final NavigationView navigationView = findViewById(R.id.navigation);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        navigationView.setCheckedItem(R.id.menu_item_playlists);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close );
        drawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.menu_item_albums:
                transaction.replace(R.id.content_frame, new AlbumFragment());
                break;
            case R.id.menu_item_playlists:
                transaction.replace(R.id.content_frame, new PlaylistsFragment());
                break;
            case R.id.menu_item_artists:
                transaction.replace(R.id.content_frame, new ArtistsFragment());
                break;
            case R.id.menu_item_songs:
                transaction.replace(R.id.content_frame, SongFragment.newInstance(0));
                break;
        }
        transaction.commit();
        drawerLayout.closeDrawer(Gravity.LEFT);
        return true;
    }
}
