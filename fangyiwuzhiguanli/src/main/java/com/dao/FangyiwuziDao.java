package com.dao;

import com.entity.FangyiwuziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangyiwuziView;

/**
 * 物资 Dao 接口
 *
 * @author 
 */
public interface FangyiwuziDao extends BaseMapper<FangyiwuziEntity> {

   List<FangyiwuziView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
