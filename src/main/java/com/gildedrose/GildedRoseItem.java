package com.gildedrose;

public class GildedRoseItem extends Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY = 50;
    public static final int FARTHER_DAY = 11;
    public static final int CLOSER_DAY = 6;

    public GildedRoseItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    void increaseQuality() {
        if (this.quality < MAX_QUALITY) this.quality++;
    }

    void increaseQualityWhenSellInHasFartherDay() {
        if (this.sellIn < FARTHER_DAY) this.increaseQuality();
    }

    void increaseQualityWhenSellInHasCloserDay() {
        if (this.sellIn < CLOSER_DAY) {
            this.increaseQuality();
        }
    }

    void decreaseQuality() {
        if (this.quality > 0) {
            this.quality--;
        }
    }

    void increaseQualityForBackstage() {
        if (this.isBackstage()) {
            this.increaseQualityWhenSellInHasFartherDay();
            this.increaseQualityWhenSellInHasCloserDay();
        }
    }

    void increaseQualityIncludingBackstage() {
        if (this.quality < MAX_QUALITY) {
            this.quality++;
            this.increaseQualityForBackstage();
        }
    }

    void handleExpiredItem() {
        if (!this.isBackstage()) {
            this.decreaseQuality();
        } else {
            this.quality = 0;
        }
    }

    public void updateSellIn() {
        this.sellIn--;
        if (itemHasExpired()) {
            handleExpiredItem();
        }
    }

    protected boolean itemHasExpired() {
        return this.sellIn < 0;
    }

    public void updateQuality() {
        if(!isBackstage()) {
            this.decreaseQuality();
        } else {
            this.increaseQualityIncludingBackstage();
        }
    }

    boolean isBackstage(){
        return this.name.equals(BACKSTAGE);
    }

}
