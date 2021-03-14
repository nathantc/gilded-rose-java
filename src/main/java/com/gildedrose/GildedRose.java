package com.gildedrose;

class GildedRose {
    GildedRoseItem[] items;

    public GildedRose(Item[] items) {
        this.items = new GildedRoseItem[items.length];
        for (int i = 0; i < items.length; i++) {
            if(GildedRoseItem.LEGENDARYITEM.equals(items[i].name)){
                this.items[i] = new LegendaryItem(items[i]);
            } else if(GildedRoseItem.CONJUREDITEM.equals(items[i].name)) {
                this.items[i] = new ConjuredItem(items[i]);
            } else if(GildedRoseItem.BACKSTAGEPASSES.equals(items[i].name)){
                this.items[i] = new BackstageItem(items[i]);
            } else if(GildedRoseItem.AGEDBRIEITEM.equals(items[i].name)){
                this.items[i] = new AgedBrieItem(items[i]);
            }
            else {
                this.items[i] = new GildedRoseItem(items[i]);
            }
        }
    }

    public void updateQuality() {
        for (GildedRoseItem item : items) {
            item.ageItem();
        }
    }

}