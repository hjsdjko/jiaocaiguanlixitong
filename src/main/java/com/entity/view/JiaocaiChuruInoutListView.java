package com.entity.view;

import com.entity.JiaocaiChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出入库详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaocai_churu_inout_list")
public class JiaocaiChuruInoutListView extends JiaocaiChuruInoutListEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 jiaocai
			/**
			* 教材编号
			*/
			private String jiaocaiOrderUuidNumber;
			/**
			* 教材类型
			*/
			private Integer jiaocaiTypes;
				/**
				* 教材类型的值
				*/
				private String jiaocaiValue;
			/**
			* 教材库存
			*/
			private Integer jiaocaiKucunNumber;
			/**
			* 教材价格
			*/
			private Double jiaocaiNewMoney;

		//级联表 jiaocai_churu_inout
			/**
			* 出入库流水号
			*/
			private String jiaocaiChuruInoutUuidNumber;
			/**
			* 出入库名称
			*/
			private String jiaocaiChuruInoutName;
			/**
			* 出入库类型
			*/
			private Integer jiaocaiChuruInoutTypes;
				/**
				* 出入库类型的值
				*/
				private String jiaocaiChuruInoutValue;
			/**
			* 备注
			*/
			private String jiaocaiChuruInoutContent;

	public JiaocaiChuruInoutListView() {

	}

	public JiaocaiChuruInoutListView(JiaocaiChuruInoutListEntity jiaocaiChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, jiaocaiChuruInoutListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}











				//级联表的get和set jiaocai

					/**
					* 获取： 教材编号
					*/
					public String getJiaocaiOrderUuidNumber() {
						return jiaocaiOrderUuidNumber;
					}
					/**
					* 设置： 教材编号
					*/
					public void setJiaocaiOrderUuidNumber(String jiaocaiOrderUuidNumber) {
						this.jiaocaiOrderUuidNumber = jiaocaiOrderUuidNumber;
					}

					/**
					* 获取： 教材类型
					*/
					public Integer getJiaocaiTypes() {
						return jiaocaiTypes;
					}
					/**
					* 设置： 教材类型
					*/
					public void setJiaocaiTypes(Integer jiaocaiTypes) {
						this.jiaocaiTypes = jiaocaiTypes;
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

					/**
					* 获取： 教材库存
					*/
					public Integer getJiaocaiKucunNumber() {
						return jiaocaiKucunNumber;
					}
					/**
					* 设置： 教材库存
					*/
					public void setJiaocaiKucunNumber(Integer jiaocaiKucunNumber) {
						this.jiaocaiKucunNumber = jiaocaiKucunNumber;
					}

					/**
					* 获取： 教材价格
					*/
					public Double getJiaocaiNewMoney() {
						return jiaocaiNewMoney;
					}
					/**
					* 设置： 教材价格
					*/
					public void setJiaocaiNewMoney(Double jiaocaiNewMoney) {
						this.jiaocaiNewMoney = jiaocaiNewMoney;
					}


				//级联表的get和set jiaocai_churu_inout

					/**
					* 获取： 出入库流水号
					*/
					public String getJiaocaiChuruInoutUuidNumber() {
						return jiaocaiChuruInoutUuidNumber;
					}
					/**
					* 设置： 出入库流水号
					*/
					public void setJiaocaiChuruInoutUuidNumber(String jiaocaiChuruInoutUuidNumber) {
						this.jiaocaiChuruInoutUuidNumber = jiaocaiChuruInoutUuidNumber;
					}

					/**
					* 获取： 出入库名称
					*/
					public String getJiaocaiChuruInoutName() {
						return jiaocaiChuruInoutName;
					}
					/**
					* 设置： 出入库名称
					*/
					public void setJiaocaiChuruInoutName(String jiaocaiChuruInoutName) {
						this.jiaocaiChuruInoutName = jiaocaiChuruInoutName;
					}

					/**
					* 获取： 出入库类型
					*/
					public Integer getJiaocaiChuruInoutTypes() {
						return jiaocaiChuruInoutTypes;
					}
					/**
					* 设置： 出入库类型
					*/
					public void setJiaocaiChuruInoutTypes(Integer jiaocaiChuruInoutTypes) {
						this.jiaocaiChuruInoutTypes = jiaocaiChuruInoutTypes;
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

					/**
					* 获取： 备注
					*/
					public String getJiaocaiChuruInoutContent() {
						return jiaocaiChuruInoutContent;
					}
					/**
					* 设置： 备注
					*/
					public void setJiaocaiChuruInoutContent(String jiaocaiChuruInoutContent) {
						this.jiaocaiChuruInoutContent = jiaocaiChuruInoutContent;
					}

























}
