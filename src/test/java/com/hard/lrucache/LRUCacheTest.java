package com.hard.lrucache;

import com.hard.LRUCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LRUCacheTest {

    LRUCache lru;

    @BeforeEach
    void setLru() {
        lru = new LRUCache(3);
    }

    @Test
    void getMostRecentKeyReturnsMostRecentKey() {
        lru.insertKeyValuePair("b", 2);
        lru.insertKeyValuePair("a", 1);
        lru.insertKeyValuePair("c", 3);
        assertThat(lru.getMostRecentKey()).isEqualTo("c");
    }

    @Test
    void getValueFromKeyReturnsNullForAKeyDoesntExist() {
        lru.insertKeyValuePair("b", 2);
        lru.insertKeyValuePair("a", 1);
        lru.insertKeyValuePair("c", 3);
        lru.getMostRecentKey();
        LRUCache.LRUResult expected = lru.getValueFromKey("x");
        assertThat(expected).isNull();
    }

    @Test
    void getValueFromKeyReturns() {
        lru.insertKeyValuePair("b", 2);
        lru.insertKeyValuePair("a", 1);
        lru.insertKeyValuePair("c", 3);
        lru.getMostRecentKey();
        lru.getValueFromKey("a");
        assertThat(lru.getMostRecentKey()).isEqualTo("a");
    }

    @Test
    void getValueEvictsLeastRecentEntry() {
        lru.insertKeyValuePair("b", 2);
        lru.insertKeyValuePair("a", 1);
        lru.insertKeyValuePair("c", 3);
        lru.getMostRecentKey();
        lru.getValueFromKey("a");
        lru.getMostRecentKey();
        lru.insertKeyValuePair("d", 4);
        assertThat(lru.getValueFromKey("b")).isNull();
    }

    @Test
    void getValueReturnsExisting() {
        lru.insertKeyValuePair("b", 2);
        lru.insertKeyValuePair("a", 1);
        lru.insertKeyValuePair("c", 3);
        lru.getMostRecentKey();
        lru.getValueFromKey("a");
        lru.getMostRecentKey();
        lru.insertKeyValuePair("d", 4);
        lru.getValueFromKey("b");
        lru.insertKeyValuePair("a", 5);
        LRUCache.LRUResult expected = lru.getValueFromKey("a");
        assertThat(expected.value).isEqualTo(5);
    }
    
}
