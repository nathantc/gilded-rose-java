package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void itemShouldHaveName() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void itemDegradesByOneEachDay(){
        Item[] items = new Item[] { new Item("foo", 6, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4,app.items[0].quality);
    }

    @Test
    void qualityDegradesTwiceAfterSellByDate() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8,app.items[0].quality);
    }

    @Test
    void qualityCanNeverBeNegative() {
        Item[] items = new Item[] { new Item("foo", 5, 0) };
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
    void qualityOfItemRemainsSameWhenOverFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 3,51)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2,app.items[0].sellIn);
    }


}