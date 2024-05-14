package com.entity.view;

import com.entity.JiaocaiChuruInoutEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出入库
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaocai_churu_inout")
public class JiaocaiChuruInoutView extends JiaocaiChuruInoutEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 出入库类型的值
		*/
		private String jiaocaiChuruInoutValue;



	public JiaocaiChuruInoutView() {

	}

	public JiaocaiChuruInoutView(JiaocaiChuruInoutEntity jiaocaiChuruInoutEntity) {
		try {
			BeanUtils.copyProperties(this, jiaocaiChuruInoutEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 出入库类型的值
			*/
			public String getJiaocaiChuruInoutValue() {
				return jiaocaiChuruInoutValue;
			}
			/**
			* 设置： 出入库类型的值
			*/
			public void setJiaocaiChuruInoutValue(String jiaocaiChuruInoutValue) {
				this.jiaocaiChuruInoutValue = jiaocaiChuruInoutValue;
			}













}
