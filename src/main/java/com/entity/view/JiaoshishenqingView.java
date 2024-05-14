package com.entity.view;

import com.entity.JiaoshishenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 教师申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaoshishenqing")
public class JiaoshishenqingView extends JiaoshishenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 课程的值
		*/
		private String kechengValue;
		/**
		* 班级的值
		*/
		private String banjiValue;
		/**
		* 申请状态的值
		*/
		private String jiaoshishenqingYesnoValue;



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

		//级联表 jiaoshi
			/**
			* 教师姓名
			*/
			private String jiaoshiName;
			/**
			* 头像
			*/
			private String jiaoshiPhoto;
			/**
			* 联系方式
			*/
			private String jiaoshiPhone;
			/**
			* 身份证号
			*/
			private String jiaoshiIdNumber;
			/**
			* 邮箱
			*/
			private String jiaoshiEmail;
			/**
			* 假删
			*/
			private Integer jiaoshiDelete;

	public JiaoshishenqingView() {

	}

	public JiaoshishenqingView(JiaoshishenqingEntity jiaoshishenqingEntity) {
		try {
			BeanUtils.copyProperties(this, jiaoshishenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 课程的值
			*/
			public String getKechengValue() {
				return kechengValue;
			}
			/**
			* 设置： 课程的值
			*/
			public void setKechengValue(String kechengValue) {
				this.kechengValue = kechengValue;
			}
			/**
			* 获取： 班级的值
			*/
			public String getBanjiValue() {
				return banjiValue;
			}
			/**
			* 设置： 班级的值
			*/
			public void setBanjiValue(String banjiValue) {
				this.banjiValue = banjiValue;
			}
			/**
			* 获取： 申请状态的值
			*/
			public String getJiaoshishenqingYesnoValue() {
				return jiaoshishenqingYesnoValue;
			}
			/**
			* 设置： 申请状态的值
			*/
			public void setJiaoshishenqingYesnoValue(String jiaoshishenqingYesnoValue) {
				this.jiaoshishenqingYesnoValue = jiaoshishenqingYesnoValue;
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













				//级联表的get和set jiaoshi

					/**
					* 获取： 教师姓名
					*/
					public String getJiaoshiName() {
						return jiaoshiName;
					}
					/**
					* 设置： 教师姓名
					*/
					public void setJiaoshiName(String jiaoshiName) {
						this.jiaoshiName = jiaoshiName;
					}

					/**
					* 获取： 头像
					*/
					public String getJiaoshiPhoto() {
						return jiaoshiPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setJiaoshiPhoto(String jiaoshiPhoto) {
						this.jiaoshiPhoto = jiaoshiPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getJiaoshiPhone() {
						return jiaoshiPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setJiaoshiPhone(String jiaoshiPhone) {
						this.jiaoshiPhone = jiaoshiPhone;
					}

					/**
					* 获取： 身份证号
					*/
					public String getJiaoshiIdNumber() {
						return jiaoshiIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setJiaoshiIdNumber(String jiaoshiIdNumber) {
						this.jiaoshiIdNumber = jiaoshiIdNumber;
					}

					/**
					* 获取： 邮箱
					*/
					public String getJiaoshiEmail() {
						return jiaoshiEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setJiaoshiEmail(String jiaoshiEmail) {
						this.jiaoshiEmail = jiaoshiEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getJiaoshiDelete() {
						return jiaoshiDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setJiaoshiDelete(Integer jiaoshiDelete) {
						this.jiaoshiDelete = jiaoshiDelete;
					}















}
