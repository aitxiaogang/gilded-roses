package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import com.gildedrose.strategy.AbstractUpdateSellInAndQualityStrategy;
import com.gildedrose.strategy.UpdateSellInAndQualityStrategy;

/**
 * @Author: xiaogang
 * @Description: 召唤物品-修改策略
 * 下降速度比正常物品快一倍
 * @Date: Created in 17:56 2022/8/25
 */
public class UpdateSellInAndQualityConjuredManaCake extends AbstractUpdateSellInAndQualityStrategy implements UpdateSellInAndQualityStrategy {

    @Override
    protected void updateQuality(Item item) {
        super.subtractQualityGreatEqualZero(item,CHANGE_QUALITY_STEP * 2);
    }

}
