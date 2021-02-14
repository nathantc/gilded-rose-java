package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item);
            updateSellIn(item);
        }
    }

    private void updateQuality(Item item) {
        if(!isAgedBrie(item) && !isBackstage(item)) {
            hasQuality(item);
        }
         else {
            increaseQualityIncludingBackstage(item);
        }
    }

    private void hasQuality(Item item) {
        if (item.quality > 0) {
            decreaseQualityWhenNotSulfuras(item);
        }
    }

    private void decreaseQualityWhenNotSulfuras(Item item) {
        if (!isSulfuras(item)) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQualityIncludingBackstage(Item item) {
        if (item.quality < 50) {
            increaseQualityByOne(item);
            increaseQualityForBackstage(item);
        }
    }

    private void increaseQualityForBackstage(Item item) {
        if (isBackstage(item)) {
            increaseQualityWhenSellInHasFartherDate(item);
            increaseQualityWhenSellInHasCloserDate(item);
        }
    }

    private void increaseQualityByOne(Item item) {
        item.quality = item.quality + 1;
    }

    private void increaseQualityWhenSellInHasFartherDate(Item item) {
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
    }

    private void increaseQualityWhenSellInHasCloserDate(Item item) {
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            increaseQualityByOne(item);
        }
    }

    private void updateSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }
        handleIfExpired(item);
    }

    private void handleIfExpired(Item item) {
        if (item.sellIn < 0) {
            handleExpired(item);
        }
    }

    private void handleExpired(Item item) {
        if (!isAgedBrie(item)) {
            handleExpiredAgedBrie(item);
        } else {
            increaseQuality(item);
        }
    }

    private void handleExpiredAgedBrie(Item item) {
        if (!isBackstage(item)) {
            hasQuality(item);
        } else {
            item.quality = item.quality - item.quality;
        }
    }

    private boolean isAgedBrie(Item item){
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstage(Item item){
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item){
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}