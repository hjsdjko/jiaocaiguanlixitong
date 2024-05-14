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
 * 出入库
 *
 * @author 
 * @email
 */
@TableName("jiaocai_churu_inout")
public class JiaocaiChuruInoutEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaocaiChuruInoutEntity() {

	}

	public JiaocaiChuruInoutEntity(T t) {
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
     * 出入库流水号
     */
    @TableField(value = "jiaocai_churu_inout_uuid_number")

    private String jiaocaiChuruInoutUuidNumber;


    /**
     * 出入库名称
     */
    @TableField(value = "jiaocai_churu_inout_name")

    private String jiaocaiChuruInoutName;


    /**
     * 出入库类型
     */
    @TableField(value = "jiaocai_churu_inout_types")

    private Integer jiaocaiChuruInoutTypes;


    /**
     * 备注
     */
    @TableField(value = "jiaocai_churu_inout_content")

    private String jiaocaiChuruInoutContent;


    /**
     * 添加时间
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
	 * 设置：出入库流水号
	 */
    public String getJiaocaiChuruInoutUuidNumber() {
        return jiaocaiChuruInoutUuidNumber;
    }
    /**
	 * 获取：出入库流水号
	 */

    public void setJiaocaiChuruInoutUuidNumber(String jiaocaiChuruInoutUuidNumber) {
        this.jiaocaiChuruInoutUuidNumber = jiaocaiChuruInoutUuidNumber;
    }
    /**
	 * 设置：出入库名称
	 */
    public String getJiaocaiChuruInoutName() {
        return jiaocaiChuruInoutName;
    }
    /**
	 * 获取：出入库名称
	 */

    public void setJiaocaiChuruInoutName(String jiaocaiChuruInoutName) {
        this.jiaocaiChuruInoutName = jiaocaiChuruInoutName;
    }
    /**
	 * 设置：出入库类型
	 */
    public Integer getJiaocaiChuruInoutTypes() {
        return jiaocaiChuruInoutTypes;
    }
    /**
	 * 获取：出入库类型
	 */

    public void setJiaocaiChuruInoutTypes(Integer jiaocaiChuruInoutTypes) {
        this.jiaocaiChuruInoutTypes = jiaocaiChuruInoutTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getJiaocaiChuruInoutContent() {
        return jiaocaiChuruInoutContent;
    }
    /**
	 * 获取：备注
	 */

    public void setJiaocaiChuruInoutContent(String jiaocaiChuruInoutContent) {
        this.jiaocaiChuruInoutContent = jiaocaiChuruInoutContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：添加时间
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
        return "JiaocaiChuruInout{" +
            "id=" + id +
            ", jiaocaiChuruInoutUuidNumber=" + jiaocaiChuruInoutUuidNumber +
            ", jiaocaiChuruInoutName=" + jiaocaiChuruInoutName +
            ", jiaocaiChuruInoutTypes=" + jiaocaiChuruInoutTypes +
            ", jiaocaiChuruInoutContent=" + jiaocaiChuruInoutContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
