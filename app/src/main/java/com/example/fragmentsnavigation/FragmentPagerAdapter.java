package com.example.fragmentsnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private Fragment[] fragments;
    private String[] tabTitles = new String[]{"Playlists", "Artists", "Albums", "Songs"};

    public FragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        fragments = new Fragment[] {
                new PlaylistsFragment(), new ArtistsFragment(), new AlbumsFragment(), SongFragment.newInstance(0)};
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
