package com.katas.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    GildedRose gildedRose;

    @BeforeEach
    void setGildedRose() {
        gildedRose = new GildedRose(getInventory());
    }


    @Test
    void updateQualityTestWorksAsBefore() {
        gildedRose.legacyUpdateQuality();
        GildedRose gildedRoseWithNewUpdate = new GildedRose(getInventory());
        gildedRoseWithNewUpdate.updateQuality();
        assertThat(gildedRoseWithNewUpdate.items)
                .usingRecursiveComparison()
                .isEqualTo(gildedRose.items);
    }


    @Test
    void checkOrdinaryItem() {
        Item input = gildedRose.processOrdinaryItem(
                new Item("+5 Dexterity Vest", 1, 20)
        );
        Item expected = new Item("+5 Dexterity Vest", 0, 19);
        assertThat(input).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void checkAgedBrie() {
        Item input = gildedRose.processAgedBrie(
                new Item("Aged Brie", 0, 10)
        );
        Item expected = new Item("Aged Brie", -1, 12);
        assertThat(input).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void checkSulfuras() {
        Item input = gildedRose.processSulfuras(
                new Item("Sulfuras, Hand of Ragnaros", 0, 80)
        );
        Item expected = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        assertThat(input).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void checkBackstageWhenFewerThanTenDays() {
        Item input = gildedRose.processBackstage(
                new Item("Backstage passes to a TAFKAL80ETC concert", 8, 20)
        );
        Item expected = new Item(
                "Backstage passes to a TAFKAL80ETC concert", 7, 22);
        assertThat(input).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void checkBackstageWhenFewerThanFiveDays() {
        Item input = gildedRose.processBackstage(
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)
        );
        Item expected = new Item(
                "Backstage passes to a TAFKAL80ETC concert", 4, 13);
        assertThat(input).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void checkFiftyCapOnBackstage() {
        Item input = gildedRose.processBackstage(
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)
        );
        Item expected = new Item(
                "Backstage passes to a TAFKAL80ETC concert", 9, 50);
        assertThat(input).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void checkConjuredItem() {
        Item input = gildedRose.processConjuredItem(
                new Item("Conjured Mana Cake", 3, 6)
        );
        Item expected = new Item("Conjured Mana Cake", 2, 4);
        assertThat(input).usingRecursiveComparison().isEqualTo(expected);
    }

    static Item[] getInventory() {
        return List.of(
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        ).toArray(Item[]::new);
    }
}
