package com.gildedrose;

public class BackstageItem extends GildedRoseItem {

    public BackstageItem(Item item) {
        super(item);
    }


    @Override
    public void updateItemQuality() {
        increaseBackstagePassQuality();
        }

    public void increaseBackstagePassQuality() {
        increaseQualityByOne();

        if (sellIn < 11) {
            increaseQualityByOne();
        }

        if (sellIn < 6) {
            increaseQualityByOne();
        }
    }

    @Override
    public void checkForExpiredItem() {
        if (itemHasExpired()) {
            adjustQualityToZero();
        }
    }
}
