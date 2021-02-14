package com.gildedrose;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY = 50;
    public static final int FARTHER_DAY = 11;
    public static final int CLOSER_DAY = 6;

    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void increaseQualityByOne() {
        this.quality++;
    }

    void increaseQuality() {
        if (this.quality < MAX_QUALITY) this.increaseQualityByOne();
    }

    void increaseQualityWhenSellInHasFartherDay() {
        if (this.sellIn < FARTHER_DAY) this.increaseQuality();
    }

    void increaseQualityWhenSellInHasCloserDay() {
        if (this.sellIn < CLOSER_DAY) {
            this.increaseQuality();
        }
    }

    void decreaseQualityWhenNotSulfuras() {
        if (!this.isSulfuras()) {
            this.quality--;
        }
    }

    void hasQuality() {
        if (this.quality > 0) {
            this.decreaseQualityWhenNotSulfuras();
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
            this.increaseQualityByOne();
            this.increaseQualityForBackstage();
        }
    }

    void handleExpiredAgedBrie() {
        if (!this.isBackstage()) {
            this.hasQuality();
        } else {
            this.quality = 0;
        }
    }

    void handleExpired() {
        if (!this.isAgedBrie()) {
            this.handleExpiredAgedBrie();
        } else {
            this.increaseQuality();
        }
    }

    void handleIfExpired() {
        if (this.sellIn < 0) {
            this.handleExpired();
        }
    }

    void updateSellIn() {
        if (!this.isSulfuras()) {
            this.sellIn = this.sellIn - 1;
        }
        this.handleIfExpired();
    }

    void updateQuality() {
        if(!this.isAgedBrie() && !this.isBackstage()) {
            this.hasQuality();
        }
        else {
            this.increaseQualityIncludingBackstage();
        }
    }

    boolean isAgedBrie(){
        return this.name.equals(AGED_BRIE);
    }

    boolean isBackstage(){
        return this.name.equals(BACKSTAGE);
    }

    boolean isSulfuras(){
        return this.name.equals(SULFURAS);
    }
}