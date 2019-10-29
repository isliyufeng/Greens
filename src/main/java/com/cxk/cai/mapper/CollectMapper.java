package com.cxk.cai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxk.cai.entity.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectMapper extends BaseMapper<Collect> {

    /**
     * 查询用户收藏
     * @param uid
     * @return
     */
    @Select("select cc.*, co.name, co.oldprice from cai.collect cc left join cai.commodity co on cc.cid = co.id where cc.uid = #{uid}")
    List<Collect> SelectUserCollect(Integer uid);


    /**
     * 用户添加收藏
     * @param collect
     * @return
     */
    @Select("insert into cai.collect(uid,cid) values(#{uid},#{cid});")
    List<Collect> userCollect(Collect collect);

    /**
     * 查询用户是否收藏过
     * @param collect
     * @return
     */
    @Select("select count(1) from cai.collect where uid = #{uid} and cid = #{cid}")
    int selectCollect(Collect collect);

    /**
     * 取消用户收藏
     * @param collect
     * @return
     */
    @Select("delete from cai.collect where uid = #{uid} and cid = #{cid}")
    Object delUserCollect(Collect collect);
}
