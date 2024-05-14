package com.dao;

import com.entity.JiaoshishenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoshishenqingView;

/**
 * 教师申请 Dao 接口
 *
 * @author 
 */
public interface JiaoshishenqingDao extends BaseMapper<JiaoshishenqingEntity> {

   List<JiaoshishenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
