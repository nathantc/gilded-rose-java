package com.gildedrose;

class GildedRose {
    GildedRoseItem[] items;

    public GildedRose(Item[] items) {
        this.items = new GildedRoseItem[items.length];

        for(int i = 0; i < items.length; i++){
            this.items[i] = new GildedRoseItem(items[i]);
        }
    }

    public void updateQuality() {
        for (GildedRoseItem item : items) {
            item.updateQuality();
            item.updateSellIn();
        }
    }

}