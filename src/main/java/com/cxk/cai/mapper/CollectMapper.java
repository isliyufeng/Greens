package com.cxk.cai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxk.cai.entity.Collect;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectMapper extends BaseMapper<Collect> {

    @Select("select cc.*, co.name, co.oldprice from cai.collect cc left join cai.commodity co on cc.cid = co.id where cc.uid = #{uid}")
    List<Collect> SelectUserCollect(Integer uid);


    @Select("insert into cai.collect(uid,cid) values(#{uid},#{cid});")
    List<Collect> userCollect(Collect collect);
}
