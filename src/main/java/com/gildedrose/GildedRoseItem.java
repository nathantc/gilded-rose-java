package com.gildedrose;

public class GildedRoseItem extends Item {
    public GildedRoseItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public GildedRoseItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void updateQuality() {
        decreaseItemQuality();
        decreaseSellIn();
        decreaseExpiredItemQuality();
    }


    private void decreaseItemQuality() {
        if (itemIsNotSpecial()) {
            decreaseNormalItemQuality();
        }

        if (itemIsAgedBrie()) {
            increaseQualityByOne();
        }

        if (itemIsBackstagePass()) {
            increaseBackstagePassQuality();
        }
    }

    private void decreaseSellIn() {
        if (!itemIsLegendary()) {
            sellIn--;
        }
    }

    private void decreaseExpiredItemQuality() {
        if (!itemHasExpired()) return;

        if (itemIsNotSpecial()) {
            decreaseNormalItemQuality();
        }

        if (itemIsAgedBrie()) {
            increaseQualityByOne();
        }

        if (itemIsBackstagePass()) {
            adjustQualityToZero();
        }

    }

    private boolean itemIsAgedBrie() {
        return name.equals("Aged Brie");
    }

    private boolean itemHasExpired() {
        return sellIn < 0;
    }

    private boolean itemIsBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean itemIsNotSpecial() {
        return !itemIsAgedBrie()
                && !itemIsBackstagePass()
                && !itemIsLegendary();
    }

    private boolean itemIsLegendary() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void decreaseNormalItemQuality() {
        if (quality > 0) {
            quality--;
        }
    }

    private void increaseBackstagePassQuality() {
        increaseQualityByOne();

        if (sellIn < 11) {
            increaseQualityByOne();
        }

        if (sellIn < 6) {
            increaseQualityByOne();
        }
    }

    private void adjustQualityToZero() {
        quality = 0;
    }

    private void increaseQualityByOne() {
        if (quality < 50) {
            quality++;
        }
    }
}
