package com.gildedrose;

public class AgedBrieItem extends GildedRoseItem{

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        increaseQualityByOne();
    }

    @Override
    public void checkForExpiredItem() {
        if (itemHasExpired()) {
            increaseQualityByOne();
        }
    }

}
