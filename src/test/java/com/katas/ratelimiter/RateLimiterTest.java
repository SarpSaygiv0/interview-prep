package com.katas.ratelimiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class RateLimiterTest {

    RateLimiter limiter;

    @BeforeEach
    void setRateLimiter() {
        limiter = new RateLimiter();
    }

    @Test
    void tokensComeBackAsTimePasses() {
        limiter.addMerchant("noisy", 3, 60, 0);      // 3 burst, 1 per second

        assertThat(limiter.allow("noisy", 0).allowed()).isTrue();
        assertThat(limiter.allow("noisy", 0).allowed()).isTrue();
        assertThat(limiter.allow("noisy", 0).allowed()).isTrue();
        assertThat(limiter.allow("noisy", 0).allowed()).isFalse();

        assertThat(limiter.allow("noisy", 1000).allowed()).isTrue();
    }

    @Test
    void aRefusedMerchantIsToldHowLongToWait() {
        limiter.addMerchant("small", 1, 60, 0);
        limiter.allow("small", 0);

        assertThat(limiter.allow("small", 400).retryAfterMillis()).isEqualTo(600);
    }

    @Test
    void aLongIdlePeriodDoesNotBankMoreThanTheBucketHolds() {
        limiter.addMerchant("seasonal", 3, 60, 0);          // 3 burst, one per second

        long aWeekLater = Duration.ofDays(7).toMillis();

        assertThat(limiter.allow("seasonal", aWeekLater).allowed()).isTrue();
        assertThat(limiter.allow("seasonal", aWeekLater).allowed()).isTrue();
        assertThat(limiter.allow("seasonal", aWeekLater).allowed()).isTrue();
        assertThat(limiter.allow("seasonal", aWeekLater).allowed()).isFalse();
    }

    @Test
    void theLeftoverFractionOfATokenIsNotThrownAway() {
        limiter.addMerchant("chatty", 3, 100, 0);           // one token every 600ms
        drain("chatty", 0);

        assertThat(limiter.allow("chatty", 1000).allowed()).isTrue();   // token due at 600ms
        assertThat(limiter.allow("chatty", 1200).allowed()).isTrue();   // the banked 400ms + 200 = 600
    }

    @Test
    void aMerchantStayingAtTheSustainableRateIsNeverRefused() {
        limiter.addMerchant("steady", 3, 60, 0);            // one per second

        for (long now = 0; now <= 600_000; now += 1000) {   // ten minutes of traffic
            assertThat(limiter.allow("steady", now).allowed())
                    .isTrue();
        }
    }

    private void drain(String merchantId, long now) {
        while (limiter.allow(merchantId, now).allowed()) {
        }
    }
}