package com.gildedrose;

public class AgedBrieItem extends GildedRoseItem {
    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
       increaseQuality();
    }

    @Override
    public void updateSellIn() {
        this.sellIn--;
        if(this.itemHasExpired()) increaseQuality();
    }
}
