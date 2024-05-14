package com.dao;

import com.entity.JiaocaiChuruInoutEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaocaiChuruInoutView;

/**
 * 出入库 Dao 接口
 *
 * @author 
 */
public interface JiaocaiChuruInoutDao extends BaseMapper<JiaocaiChuruInoutEntity> {

   List<JiaocaiChuruInoutView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
