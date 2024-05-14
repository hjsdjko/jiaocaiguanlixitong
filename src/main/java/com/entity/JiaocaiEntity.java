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
 * 教材信息
 *
 * @author 
 * @email
 */
@TableName("jiaocai")
public class JiaocaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaocaiEntity() {

	}

	public JiaocaiEntity(T t) {
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
     * 教材编号
     */
    @TableField(value = "jiaocai_order_uuid_number")

    private String jiaocaiOrderUuidNumber;


    /**
     * 教材类型
     */
    @TableField(value = "jiaocai_types")

    private Integer jiaocaiTypes;


    /**
     * 教材库存
     */
    @TableField(value = "jiaocai_kucun_number")

    private Integer jiaocaiKucunNumber;


    /**
     * 教材价格
     */
    @TableField(value = "jiaocai_new_money")

    private Double jiaocaiNewMoney;


    /**
     * 发布时间
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
	 * 设置：教材编号
	 */
    public String getJiaocaiOrderUuidNumber() {
        return jiaocaiOrderUuidNumber;
    }
    /**
	 * 获取：教材编号
	 */

    public void setJiaocaiOrderUuidNumber(String jiaocaiOrderUuidNumber) {
        this.jiaocaiOrderUuidNumber = jiaocaiOrderUuidNumber;
    }
    /**
	 * 设置：教材类型
	 */
    public Integer getJiaocaiTypes() {
        return jiaocaiTypes;
    }
    /**
	 * 获取：教材类型
	 */

    public void setJiaocaiTypes(Integer jiaocaiTypes) {
        this.jiaocaiTypes = jiaocaiTypes;
    }
    /**
	 * 设置：教材库存
	 */
    public Integer getJiaocaiKucunNumber() {
        return jiaocaiKucunNumber;
    }
    /**
	 * 获取：教材库存
	 */

    public void setJiaocaiKucunNumber(Integer jiaocaiKucunNumber) {
        this.jiaocaiKucunNumber = jiaocaiKucunNumber;
    }
    /**
	 * 设置：教材价格
	 */
    public Double getJiaocaiNewMoney() {
        return jiaocaiNewMoney;
    }
    /**
	 * 获取：教材价格
	 */

    public void setJiaocaiNewMoney(Double jiaocaiNewMoney) {
        this.jiaocaiNewMoney = jiaocaiNewMoney;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：发布时间
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
        return "Jiaocai{" +
            "id=" + id +
            ", jiaocaiOrderUuidNumber=" + jiaocaiOrderUuidNumber +
            ", jiaocaiTypes=" + jiaocaiTypes +
            ", jiaocaiKucunNumber=" + jiaocaiKucunNumber +
            ", jiaocaiNewMoney=" + jiaocaiNewMoney +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
