package com.katas.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void legacyUpdateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie"))
                processAgedBrie(item);

            else if (item.name.equals("Sulfuras, Hand of Ragnaros"))
                processSulfuras(item);

            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                processBackstage(item);

            else if (item.name.startsWith("Conjured"))
                processConjuredItem(item);

            else
                processOrdinaryItem(item);
        }
    }

    public Item processConjuredItem(Item item) {
        int qualityDegrade = 2;
        if (item.sellIn <= 0)
            qualityDegrade = 4;
        if (item.quality > 0)
            item.quality -= qualityDegrade;

        item.sellIn -= 1;
        return item;
    }

    public Item processOrdinaryItem(Item item) {
        int qualityDegrade = 1;
        if (item.sellIn <= 0)
            qualityDegrade = 2;

        item.quality -= qualityDegrade;
        if (item.quality <= 0)
            item.quality = 0;

        item.sellIn -= 1;
        return item;
    }

    public Item processAgedBrie(Item item) {
        if (item.quality > 50) {
            item.sellIn -= 1;
            return item;
        }
        int qualityUpgrade = 1;
        if (item.sellIn <= 0)
            qualityUpgrade = 2;

        item.quality += qualityUpgrade;

        if (item.quality >= 50)
            item.quality = 50;

        item.sellIn -= 1;
        return item;
    }

    public Item processSulfuras(Item item) {
        return item;
    }

    public Item processBackstage(Item item) {
        if (item.quality < 50) {
            if (item.sellIn <= 5)
                item.quality += 3;
            else if (item.sellIn <= 10)
                item.quality += 2;
            else
                item.quality += 1;

            if (item.quality >= 50)
                item.quality = 50;
        }
        if (item.sellIn <= 0)
            item.quality = 0;

        item.sellIn -= 1;
        return item;
    }

}