package com.gildedrose;

public class GildedRoseItem extends Item {

    public static final String LEGENDARYITEM = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGEPASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGEDBRIEITEM = "Aged Brie";
    public static final String CONJUREDITEM = "Conjured Item";

    public GildedRoseItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public final void ageItem() {
        updateItemQuality();
        decreaseSellIn();
        checkForExpiredItem();
    }

    public void updateItemQuality() {
        decreaseNormalItemQuality();

    }

    public void decreaseSellIn() {
            sellIn--;
    }

    public void checkForExpiredItem() {
        if (!itemHasExpired()) return;

        decreaseNormalItemQuality();

    }

    protected boolean itemHasExpired() {
        return sellIn < 0;
    }

    private void decreaseNormalItemQuality() {
        if (quality > 0) {
            quality--;
        }
    }

    protected void decreaseQualityByTwo() {
        quality-=2;
    }

    protected void adjustQualityToZero() {
        quality = 0;
    }

    protected void increaseQualityByOne() {
        if (quality < 50) {
            quality++;
        }
    }
}