package com.entity.view;

import com.entity.XueshengshenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xueshengshenqing")
public class XueshengshenqingView extends XueshengshenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请状态的值
		*/
		private String xueshengshenqingYesnoValue;



		//级联表 jiaoshishenqing
			/**
			* 申请编号
			*/
			private String jiaoshishenqingUuidNumber;
			/**
			* 教师申请 的 教师
			*/
			private Integer jiaoshishenqingJiaoshiId;
			/**
			* 申请数量
			*/
			private Integer jiaoshishenqingNumber;
			/**
			* 课程
			*/
			private Integer kechengTypes;
				/**
				* 课程的值
				*/
				private String kechengValue;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;
			/**
			* 申请状态
			*/
			private Integer jiaoshishenqingYesnoTypes;
				/**
				* 申请状态的值
				*/
				private String jiaoshishenqingYesnoValue;
			/**
			* 申请结果
			*/
			private String jiaoshishenqingYesnoText;

		//级联表 yonghu
			/**
			* 学生姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public XueshengshenqingView() {

	}

	public XueshengshenqingView(XueshengshenqingEntity xueshengshenqingEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 申请状态的值
			*/
			public String getXueshengshenqingYesnoValue() {
				return xueshengshenqingYesnoValue;
			}
			/**
			* 设置： 申请状态的值
			*/
			public void setXueshengshenqingYesnoValue(String xueshengshenqingYesnoValue) {
				this.xueshengshenqingYesnoValue = xueshengshenqingYesnoValue;
			}






















				//级联表的get和set jiaoshishenqing

					/**
					* 获取： 申请编号
					*/
					public String getJiaoshishenqingUuidNumber() {
						return jiaoshishenqingUuidNumber;
					}
					/**
					* 设置： 申请编号
					*/
					public void setJiaoshishenqingUuidNumber(String jiaoshishenqingUuidNumber) {
						this.jiaoshishenqingUuidNumber = jiaoshishenqingUuidNumber;
					}


					/**
					* 获取：教师申请 的 教师
					*/
					public Integer getJiaoshishenqingJiaoshiId() {
						return jiaoshishenqingJiaoshiId;
					}
					/**
					* 设置：教师申请 的 教师
					*/
					public void setJiaoshishenqingJiaoshiId(Integer jiaoshishenqingJiaoshiId) {
						this.jiaoshishenqingJiaoshiId = jiaoshishenqingJiaoshiId;
					}


					/**
					* 获取： 申请数量
					*/
					public Integer getJiaoshishenqingNumber() {
						return jiaoshishenqingNumber;
					}
					/**
					* 设置： 申请数量
					*/
					public void setJiaoshishenqingNumber(Integer jiaoshishenqingNumber) {
						this.jiaoshishenqingNumber = jiaoshishenqingNumber;
					}

					/**
					* 获取： 课程
					*/
					public Integer getKechengTypes() {
						return kechengTypes;
					}
					/**
					* 设置： 课程
					*/
					public void setKechengTypes(Integer kechengTypes) {
						this.kechengTypes = kechengTypes;
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
					* 获取： 申请状态
					*/
					public Integer getJiaoshishenqingYesnoTypes() {
						return jiaoshishenqingYesnoTypes;
					}
					/**
					* 设置： 申请状态
					*/
					public void setJiaoshishenqingYesnoTypes(Integer jiaoshishenqingYesnoTypes) {
						this.jiaoshishenqingYesnoTypes = jiaoshishenqingYesnoTypes;
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

					/**
					* 获取： 申请结果
					*/
					public String getJiaoshishenqingYesnoText() {
						return jiaoshishenqingYesnoText;
					}
					/**
					* 设置： 申请结果
					*/
					public void setJiaoshishenqingYesnoText(String jiaoshishenqingYesnoText) {
						this.jiaoshishenqingYesnoText = jiaoshishenqingYesnoText;
					}










				//级联表的get和set yonghu

					/**
					* 获取： 学生姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
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
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
