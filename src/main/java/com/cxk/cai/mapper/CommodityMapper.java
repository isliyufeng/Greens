package com.cxk.cai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.CommodityVo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 根据商品二级分类id，查询商品信息
     *
     * @param id  二级分类id
     * @param num 需要查询的条数
     * @return
     */
    @Select("select * from commodity where type = #{id} limit #{num}")
    List<Commodity> getCommodity(Integer id, Integer num);

    /**
     * 查询商品
     * @param name
     * @return
     */
    @Select("select * from cai.commodity where name like concat('%',#{name},'%')")
    List<Commodity> selectCommodityByName(String name);

    /**
     * 查询指定商品库存
     * @param cid
     * @return
     */
    @Select("select * from cai.commodity_inventory where cid = #{cid}")
    CommodityVo getInventory(Integer cid);

}
