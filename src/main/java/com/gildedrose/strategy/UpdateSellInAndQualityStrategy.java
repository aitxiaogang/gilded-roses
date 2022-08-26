package com.gildedrose.strategy;

import com.gildedrose.Item;

/**
 * @Author: xiaogang
 * @Description: 修改物品销售期限和品质
 * @Date: Created in 17:12 2022/8/25
 */
public interface UpdateSellInAndQualityStrategy {
    /**
     * 默认品质上限
     */
    int DEFAULT_MAX_QUALITY = 50;

    /**
     * 修改销售日期步长
     */
    int CHANGE_SELL_IN_STEP = 1;

    /**
     * 修改品质步长
     */
    int CHANGE_QUALITY_STEP = 1;

    void updateSellInAndQuality(Item item);
}
