package com.gildedrose;

public class ConjuredItem extends GildedRoseItem {
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        decreaseConjuredItemByTwo();
    }

    public void decreaseConjuredItemByTwo() {
        decreaseQualityByTwo();

    }

}