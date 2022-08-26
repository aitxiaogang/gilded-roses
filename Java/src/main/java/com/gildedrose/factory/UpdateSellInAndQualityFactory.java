package com.gildedrose.factory;

import com.gildedrose.strategy.UpdateSellInAndQualityStrategy;
import com.gildedrose.strategy.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaogang
 * @Description: 修改物品销售期限和品质-工厂类
 * 通过物品名称获取对应修改品质和质量的算法策略实现类
 * @Date: Created in 17:12 2022/8/25
 */
public class UpdateSellInAndQualityFactory {

    /**
     * 物品名称和对应算法策略的映射
     */
    private static Map<String,UpdateSellInAndQualityStrategy> itemNameUpdateSellInAndQualityStrategyMap;

    static {
        itemNameUpdateSellInAndQualityStrategyMap = new HashMap<>();
        itemNameUpdateSellInAndQualityStrategyMap.put("Aged Brie",new UpdateSellInAndQualityAgedBrie());
        itemNameUpdateSellInAndQualityStrategyMap.put("Sulfuras, Hand of Ragnaros",new UpdateSellInAndQualitySulfuras());
        itemNameUpdateSellInAndQualityStrategyMap.put("Backstage passes to a TAFKAL80ETC concert",new UpdateSellInAndQualityBackstagePasses());
        itemNameUpdateSellInAndQualityStrategyMap.put("Conjured Mana Cake",new UpdateSellInAndQualityConjuredManaCake());
    }

    /**
     * 通过物品名称获取对应修改品质和质量的算法策略实现类，如果没有配置特殊算法实现，返回常规/默认的算法策略
     * @param itemName 物品名称
     * @return 更新物品售卖日期和质量的算法示例
     */
    public static UpdateSellInAndQualityStrategy getUpdateSellInAndQualityStrategy(String itemName) {
        if (itemName == null) {
            throw new IllegalArgumentException("物品名称不能为null");
        }
        UpdateSellInAndQualityStrategy updateSellInAndQualityStrategy = itemNameUpdateSellInAndQualityStrategyMap.get(itemName);
        if (updateSellInAndQualityStrategy != null) {
            return updateSellInAndQualityStrategy;
        }

        //没有配置指定处理策略，使用常规处理策略
        updateSellInAndQualityStrategy = new UpdateSellInAndQualityGeneral();
        return updateSellInAndQualityStrategy;
    }

    private UpdateSellInAndQualityFactory() {
        throw new UnsupportedOperationException("不要创建此工厂实例");
    }
}
