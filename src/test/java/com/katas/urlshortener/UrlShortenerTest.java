package com.katas.urlshortener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UrlShortenerTest {

    UrlShortener urlShortener;
    private final static String PREFIX = "https://sho.rt/";
    private final static String BASE_URL = "https://www.google.com/";

    @BeforeEach
    void setUrlShortener() {
        urlShortener = new UrlShortener();
    }

    @Test
    void urlShortenerSizeIsEmptyAtInitialization() {
        assertThat(urlShortener.size()).isEqualTo(0);
    }

    @Test
    void shortenIncreasesSize() {
        urlShortener.shorten("");
        assertThat(urlShortener.size()).isEqualTo(1);
    }

    @Test
    void aShortenedUrlUnshortensBackToTheOriginal() {
        String shortUrl = urlShortener.shorten("https://www.google.com/");
        String longUrl = urlShortener.unshorten(shortUrl);
        assertThat(longUrl).isEqualTo("https://www.google.com/");
    }

    @Test
    void everyUrlGetsItsOwnDistinctShortUrl() {
        Set<String> shortUrls = Arrays.stream(generate1000Urls())
                .map(urlShortener::shorten)
                .collect(toSet());

        assertThat(shortUrls).hasSize(1000);
    }

    @Test
    void urlWithSamePrefixAsDomainShouldNotBeShortened() {
        assertThatThrownBy(() -> urlShortener.shorten(PREFIX))
                .isInstanceOf(RuntimeException.class).hasMessageContaining("Could not shorten an already shortened URL");
    }

    @Test
    void unknownUrlShouldNotBeShortened() {
        assertThatThrownBy(() -> urlShortener.unshorten("blabla"))
                .isInstanceOf(RuntimeException.class).hasMessageContaining("Unknown shortened URL");
    }

    @Test
    void shortenedShouldReturnSameUrlForSameLongUrl() {
        String shortUrl1 = urlShortener.shorten("https://www.google.com/");
        String shortUrl2 = urlShortener.shorten("https://www.google.com/");
        assertThat(shortUrl1).isEqualTo(shortUrl2);
        assertThat(urlShortener.size()).isEqualTo(1);
    }

    private static String[] generate1000Urls() {
        return IntStream.range(0, 1000)
                .mapToObj(value -> BASE_URL + value)
                .toArray(String[]::new);
    }
}
