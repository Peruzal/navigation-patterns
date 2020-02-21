package com.example.fragmentsnavigation.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummySong> ITEMS = new ArrayList<DummySong>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummySong> ITEM_MAP = new HashMap<String, DummySong>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummySong item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.title, item);
    }

    private static DummySong createDummyItem(int position) {
        return new DummySong("Song " + position, "artist " + position, "album" + 1);
    }

    /**
     * A dummy item representing a piece of song.
     */
    public static class DummySong {
        public final String title;
        public final String artist;
        public final String album;

        public DummySong(String id, String content, String details) {
            this.title = id;
            this.artist = content;
            this.album = details;
        }

        @Override
        public String toString() {
            return artist;
        }
    }
}
