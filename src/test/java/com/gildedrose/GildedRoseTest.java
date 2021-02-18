package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void itemShouldHaveName() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void itemDegradesByOneEachDay() {
        Item[] items = new Item[]{new Item("foo", 6, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void qualityDegradesTwiceAfterSellByDate() {
        Item[] items = new Item[]{new Item("foo", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void qualityCanNeverBeNegative() {
        Item[] items = new Item[]{new Item("foo", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityIncreasesForAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void qualityOfItemRemainsSameWhenOverFifty() {
        Item[] items = new Item[]{new Item("Aged Brie", 3, 51)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void qualityNeverDecreasesWhenSulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 8, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, app.items[0].quality);

    }

    @Test
    void qualityWillIncreaseByOneMoreWhenTenDaysOrMoreForBackstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 20, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(26, app.items[0].quality);

    }

    @Test
    void qualityWillIncreaseByTwoMoreWhenLessThanTenDaysForBackstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(27, app.items[0].quality);

    }

    @Test
    void qualityWillDecreaseByZeroWhenZeroDaysForBackstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);

    }

    @Test
    void qualityWillIncreaseByThreeMoreWhenLessThanSixDaysForBackstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);

    }

    @Test
    void qualityOfItemIsNeverOverFifty() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void qualityWillIncreaseByTwoWithLessThanElevenDaysForBackstage() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 9)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);

    }

    @Test
    void qualityWillIncreasesForAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
}