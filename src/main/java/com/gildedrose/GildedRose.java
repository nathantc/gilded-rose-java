package com.gildedrose;

import java.util.List;

class GildedRose {
    List<GildedRoseItem> items;

    public GildedRose(Item[] items) {
        for (Item item: items) {
            this.items.add(new GildedRoseItem(item));
        }
    }

    public void updateQuality() {
        for (GildedRoseItem item : items) {
            item.updateQuality();
        }
    }

}