package com.gildedrose;

/*
    Things that have been refactored:
    1. Extracted method with logical and meaningful name
    2. Extracted constants
    3. Inversed if-else logic for simplier comprehension
    4. Changed updateQuality from if-else to switch for more structural conditional statements
    5. Use simpler operator. E.g. quality++ isntead of quality = quality +1
    6. Test cases have been covered >90% before changes were made.
*/

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQuality(items[i]);
            updateSellin(items[i]);
        }
    }
    private void updateQuality(Item item) {
        switch(item.name) {
            case AGED_BRIE:
                appreciateQuality(item);
                break;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                appreciateQuality(item);
                if (item.sellIn < 11) {
                    appreciateQuality(item);
                }
                if (item.sellIn < 6) {
                    appreciateQuality(item);
                }
                break;
            default:
                depreciateQuality(item);
        }
    }
    private void updateSellin(Item item) {
        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn--;
        }

        if (item.sellIn < 0) {
            if (item.name.equals(AGED_BRIE)) {
                appreciateQuality(item);
            } else {
                depreciateQuality(item);
            }
        }
    }

    private void appreciateQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void depreciateQuality(Item item) {
        if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            item.quality -= item.quality;
        } else if (item.quality > 0 && !item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            item.quality--;
        }
    }
}
