package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import com.gildedrose.strategy.AbstractUpdateSellInAndQualityStrategy;
import com.gildedrose.strategy.UpdateSellInAndQualityStrategy;

/**
 * @Author: xiaogang
 * @Description: 陈年布利奶酪修改策略
 * 随着销售时间推移而提升品质
 * @Date: Created in 17:56 2022/8/25
 */
public class UpdateSellInAndQualityAgedBrie extends AbstractUpdateSellInAndQualityStrategy implements UpdateSellInAndQualityStrategy {

    @Override
    protected void updateQuality(Item item) {
        super.addQualityLessEqualLimit(item);
    }

}
