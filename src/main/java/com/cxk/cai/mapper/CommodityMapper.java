package com.cxk.cai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxk.cai.entity.Commodity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface CommodityMapper extends BaseMapper<Commodity> {
    /**
     * 降序获取新上市商品
     *
     * @param num 需要查询的条数
     * @return
     */
    @Select("select * from commodity order by createtime desc limit #{num};")
    List<Commodity> getNewCommodity(Integer num);
}
