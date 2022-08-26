package com.gildedrose.strategy.impl;

import com.gildedrose.Item;
import com.gildedrose.strategy.AbstractUpdateSellInAndQualityStrategy;
import com.gildedrose.strategy.UpdateSellInAndQualityStrategy;

/**
 * @Author: xiaogang
 * @Description: 后台通行证修改策略
 * （后台通行证）与"Aged Brie"（陈年布利奶酪）类似，其品质`Quality`会随着时间推移而提高；
 * 当还剩10天或更少的时候，品质`Quality`每天提高2；当还剩5天或更少的时候，品质`Quality`每天提高3；
 * 但一旦过期，品质就会降为0
 * @Date: Created in 18:22 2022/8/25
 */
public class UpdateSellInAndQualityBackstagePasses extends AbstractUpdateSellInAndQualityStrategy implements UpdateSellInAndQualityStrategy {

    @Override
    protected void updateQuality(Item item) {
        if(item.sellIn <= 0){
            item.quality = 0;
            return;
        }

        //品质不能超过默认上限
        if(item.quality >= DEFAULT_MAX_QUALITY){
            return;
        }

        //当还剩5天或更少的时候，品质`Quality`每天提高3；
        if(item.sellIn <= 5){
            super.addQualityLessEqualLimit(item,3);
            return;
        }

        //当还剩10天或更少的时候，品质`Quality`每天提高2
        if(item.sellIn <= 10){
            super.addQualityLessEqualLimit(item,2);
            return;
        }

        super.addQualityLessEqualLimit(item);
    }

}
