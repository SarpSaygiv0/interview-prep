package com.katas.ratelimiter;

import java.util.HashMap;
import java.util.Map;


record Decision(boolean allowed, long retryAfterMillis) {

    static Decision allow() {
        return new Decision(true, 0);
    }

    static Decision retryIn(long millis) {
        return new Decision(false, millis);
    }
}

public class RateLimiter {

    private final Map<String, Bucket> buckets;

    RateLimiter() {
        buckets = new HashMap<>();
    }

    public void addMerchant(String merchantId, long capacity, long refillPerMinute, long now) {
        buckets.put(merchantId, new Bucket(capacity, refillPerMinute, now));
    }

    public Decision allow(String merchantId, long now) {
        Bucket bucket = buckets.get(merchantId);
        if (bucket == null) throw new RuntimeException("Merchant doesn't exist");

        return bucket.tryConsume(now);
    }

    static class Bucket {
        private final long capacity;
        private final long millisPerToken;
        private long tokens;
        private long lastRefill;

        private static final long MILLIS_PER_MINUTE = 60000;

        public Bucket(long capacity, long refillPerMinute, long now) {
            this.capacity = capacity;
            this.millisPerToken = MILLIS_PER_MINUTE / refillPerMinute;
            this.tokens = capacity;
            this.lastRefill = now;
        }

        Decision tryConsume(long now) {
            refill(now);
            if (tokens == 0)
                return Decision.retryIn(lastRefill + millisPerToken - now);

            tokens--;
            return Decision.allow();
        }

        void refill(long now) {
            long earned = (now - lastRefill) / millisPerToken;
            if (earned <= 0) return;
            if (tokens + earned >= capacity) {
                tokens = capacity;
                lastRefill = now;
            } else {
                tokens += earned;
                lastRefill -= earned * millisPerToken;
            }
        }
    }
}
