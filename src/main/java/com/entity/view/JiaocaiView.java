package com.entity.view;

import com.entity.JiaocaiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 教材信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaocai")
public class JiaocaiView extends JiaocaiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 教材类型的值
		*/
		private String jiaocaiValue;



	public JiaocaiView() {

	}

	public JiaocaiView(JiaocaiEntity jiaocaiEntity) {
		try {
			BeanUtils.copyProperties(this, jiaocaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 教材类型的值
			*/
			public String getJiaocaiValue() {
				return jiaocaiValue;
			}
			/**
			* 设置： 教材类型的值
			*/
			public void setJiaocaiValue(String jiaocaiValue) {
				this.jiaocaiValue = jiaocaiValue;
			}













}
