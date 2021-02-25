package com.gildedrose;

import com.gildedrose.Item;

public class GildedRoseItem extends Item {
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
            this.quality++;
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
            this.sellIn--;
        }
        this.handleIfExpired();
    }

    void updateQuality() {
        if(notAgedBrieAndNotBackstage()) {
            this.hasQuality();
        } else {
            this.increaseQualityIncludingBackstage();
        }
    }

    private boolean notAgedBrieAndNotBackstage() {
        return !this.isAgedBrie() && !this.isBackstage();
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
