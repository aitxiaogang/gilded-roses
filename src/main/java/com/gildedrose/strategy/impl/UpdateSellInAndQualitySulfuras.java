package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import com.gildedrose.strategy.AbstractUpdateSellInAndQualityStrategy;
import com.gildedrose.strategy.UpdateSellInAndQualityStrategy;

/**
 * @Author: xiaogang
 * @Description: 萨弗拉斯—炎魔拉格纳罗斯之手-修改策略
 * 售卖日期不过期，且品质不变
 * @Date: Created in 18:13 2022/8/25
 */
public class UpdateSellInAndQualitySulfuras extends AbstractUpdateSellInAndQualityStrategy implements UpdateSellInAndQualityStrategy {

    @Override
    protected void updateSellIn(Item item) {
        if(item.sellIn <= 0){
            return;
        }
        //扣减销售期限
        super.subtractSellIn(item);
    }

    @Override
    protected void updateQuality(Item item) {

    }

}
