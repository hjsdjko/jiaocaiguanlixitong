package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 学生申请
 *
 * @author 
 * @email
 */
@TableName("xueshengshenqing")
public class XueshengshenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengshenqingEntity() {

	}

	public XueshengshenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 教材
     */
    @TableField(value = "jiaoshishenqing_id")

    private Integer jiaoshishenqingId;


    /**
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 申请数量
     */
    @TableField(value = "jiaoshishenqing_number")

    private Integer jiaoshishenqingNumber;


    /**
     * 申请状态
     */
    @TableField(value = "xueshengshenqing_yesno_types")

    private Integer xueshengshenqingYesnoTypes;


    /**
     * 申请结果
     */
    @TableField(value = "xueshengshenqing_yesno_text")

    private String xueshengshenqingYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：教材
	 */
    public Integer getJiaoshishenqingId() {
        return jiaoshishenqingId;
    }
    /**
	 * 获取：教材
	 */

    public void setJiaoshishenqingId(Integer jiaoshishenqingId) {
        this.jiaoshishenqingId = jiaoshishenqingId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：申请数量
	 */
    public Integer getJiaoshishenqingNumber() {
        return jiaoshishenqingNumber;
    }
    /**
	 * 获取：申请数量
	 */

    public void setJiaoshishenqingNumber(Integer jiaoshishenqingNumber) {
        this.jiaoshishenqingNumber = jiaoshishenqingNumber;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getXueshengshenqingYesnoTypes() {
        return xueshengshenqingYesnoTypes;
    }
    /**
	 * 获取：申请状态
	 */

    public void setXueshengshenqingYesnoTypes(Integer xueshengshenqingYesnoTypes) {
        this.xueshengshenqingYesnoTypes = xueshengshenqingYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getXueshengshenqingYesnoText() {
        return xueshengshenqingYesnoText;
    }
    /**
	 * 获取：申请结果
	 */

    public void setXueshengshenqingYesnoText(String xueshengshenqingYesnoText) {
        this.xueshengshenqingYesnoText = xueshengshenqingYesnoText;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xueshengshenqing{" +
            "id=" + id +
            ", jiaoshishenqingId=" + jiaoshishenqingId +
            ", yonghuId=" + yonghuId +
            ", jiaoshishenqingNumber=" + jiaoshishenqingNumber +
            ", xueshengshenqingYesnoTypes=" + xueshengshenqingYesnoTypes +
            ", xueshengshenqingYesnoText=" + xueshengshenqingYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
