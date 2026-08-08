package com.katas.urlshortener;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.IntSupplier;

public class UrlShortener {


    private final Map<String, String> shortToLong;
    private final Map<String, String> longToShort;

    private final static String PREFIX = "https://sho.rt/";
    private final static int MAX_ATTEMPTS = 5000;
    private final static Random random = new Random();

    private final IntSupplier idSource = () -> random.nextInt(0, 1000);

    public UrlShortener() {
        shortToLong = new HashMap<>();
        longToShort = new HashMap<>();
    }

    public int size() {
        return shortToLong.size();
    }

    public String shorten(String longUrl) {
        if (longUrl.startsWith(PREFIX))
            throw new RuntimeException("Could not shorten an already shortened URL");

        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }

        String shortUrl = PREFIX + nextFreeId();
        if (!shortToLong.containsKey(shortUrl)) {
            shortToLong.put(shortUrl, longUrl);
            longToShort.put(longUrl, shortUrl);
        }
        return shortUrl;
    }

    public String unshorten(String shortUrl) {
        if (!shortToLong.containsKey(shortUrl))
            throw new RuntimeException("Unknown shortened URL");

        return shortToLong.get(shortUrl);
    }

    private String nextFreeId() {
        for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
            String id = String.format("%03d", idSource.getAsInt());
            if (!shortToLong.containsKey(PREFIX + id)) return id;
        }
        throw new IllegalStateException("no free id after " + MAX_ATTEMPTS + " attempts");
    }

}
