package com.gildedrose.strategy;

import com.gildedrose.Item;

/**
 * @Author: xiaogang
 * @Description: 更新策略的公共方法
 * @Date: Created in 17:56 2022/8/25
 */
public abstract class AbstractUpdateSellInAndQualityStrategy implements UpdateSellInAndQualityStrategy{

    /**
     * 降低品质,不小于0-指定步长
     * @param item
     * @param subtract
     */
    protected void subtractQualityGreatEqualZero(Item item,int subtract){
        int quality = item.quality - subtract;
        if (quality <= 0){
            item.quality = 0;
            return;
        }
        item.quality = quality;
    }

    /**
     * 降低品质,不小于0-默认步长
     * @param item
     */
    protected void subtractQualityGreatEqualZero(Item item){
        this.subtractQualityGreatEqualZero(item,CHANGE_QUALITY_STEP);
    }

    /**
     * 增加品质，不超过上限
     * @param item
     */
    protected void addQualityLessEqualLimit(Item item){
        this.addQualityLessEqualLimit(item,CHANGE_QUALITY_STEP);
    }

    /**
     * 增加品质，不超过上限。指定步长
     * @param item
     * @param increment 步长
     */
    protected void addQualityLessEqualLimit(Item item,int increment){
        int quality = item.quality + increment;
        if (quality >= DEFAULT_MAX_QUALITY){
            item.quality = DEFAULT_MAX_QUALITY;
            return;
        }

        item.quality = item.quality + increment;
    }

    /**
     * 扣减销售日期-指定减量
     * @param item
     * @param sellIn
     */
    protected void subtractSellIn(Item item,int sellIn){
        item.sellIn = item.sellIn - sellIn;
    }

    /**
     * 扣减销售日期-默认减量
     * @param item
     */
    protected void subtractSellIn(Item item){
        this.subtractSellIn(item,CHANGE_SELL_IN_STEP);
    }

    /**
     * 更新销售日期
     * @param item
     */
    protected void updateSellIn(Item item){
        this.subtractSellIn(item);
    }

    /**
     * 更新品质
     * @param item
     */
    protected void updateQuality(Item item){
        this.subtractQualityGreatEqualZero(item);
    }

    @Override
    public void updateSellInAndQuality(Item item) {
        if (item == null) {
            return;
        }
        this.updateSellIn(item);
        this.updateQuality(item);
    }

}
