package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DailyQualityCheckApprovalTest {

    private Item[] items;
    private GildedRose app;

    @BeforeEach
    public void beforeEach() {
        items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        app = new GildedRose(items);
    }

    private void updateQualityForNumberOfDays(int days) {
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }

        Approvals.verifyAll(items, item -> item.toString());
    }

    @Test
    public void twoDays() {
        updateQualityForNumberOfDays(2);
    }

    @Test
    public void fiveDays() {
        updateQualityForNumberOfDays(5);
    }

    @Test
    public void sevenDays() {
        updateQualityForNumberOfDays(7);
    }

}
