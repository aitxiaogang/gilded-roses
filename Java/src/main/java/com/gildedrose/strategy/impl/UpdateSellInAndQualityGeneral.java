package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import com.gildedrose.strategy.AbstractUpdateSellInAndQualityStrategy;
import com.gildedrose.strategy.UpdateSellInAndQualityStrategy;

/**
 * @Author: xiaogang
 * @Description: 常规的修改策略
 * 每天降低1售卖期限和1品质
 * 超过销售期限之后，品质以2倍速度下降
 * 品质永远不会为负数
 * 品质永远不会超过50
 * @Date: Created in 17:13 2022/8/25
 */
public class UpdateSellInAndQualityGeneral extends AbstractUpdateSellInAndQualityStrategy implements UpdateSellInAndQualityStrategy {

    @Override
    protected void updateQuality(Item item) {
        //过期之后双倍下降
        if(item.sellIn < 0){
            super.subtractQualityGreatEqualZero(item,CHANGE_QUALITY_STEP * 2);
            return;
        }

        super.updateQuality(item);

    }

}
