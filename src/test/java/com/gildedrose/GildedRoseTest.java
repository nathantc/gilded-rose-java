package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void itemShouldHaveName() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
    }

   /* @Test
    void itemDegradesByOneEachDay(){
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4,app.items[0].quality);
    }*/

 /*   @Test
    void qualityDegradesTwiceAfterSellByDate() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8,app.items[0].quality);
    }*/

    @Test
    void qualityCanNeverBeNegative() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void qualityIncreasesForAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6,app.items[0].quality);
    }

    @Test
    void qualityIncreasesByOneWhenLessThanFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }

    @Test
    void qualityRemainsSameWhenGreaterThanFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 51) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(51,app.items[0].quality);
    }

    @Test
    void sellInDecreasesWhenNameIsOtherThanSulfuras() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4,app.items[0].sellIn);
    }

    @Test
    void qualityRemainsSameWhenSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49,app.items[0].quality);
    }

    @Test
    void qualityIncreasesTwiceWhenSellInZeroForAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }

    @Test
    void qualityIncreasesByOneWhenSellInMoreThanTenDaysForBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31,app.items[0].quality);
    }

    @Test
    void qualityIncreasesByTwoWhenSellInLessThanElevenDaysForBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32,app.items[0].quality);
    }

    @Test
    void qualityIncreasesByThreeWhenSellInLessThanSixDaysForBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(33,app.items[0].quality);
    }

    @Test
    void qualityDecreasesByZeroWhenSellInZeroForBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }
}