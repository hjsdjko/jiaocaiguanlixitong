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
 * 出入库详情
 *
 * @author 
 * @email
 */
@TableName("jiaocai_churu_inout_list")
public class JiaocaiChuruInoutListEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaocaiChuruInoutListEntity() {

	}

	public JiaocaiChuruInoutListEntity(T t) {
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
     * 出入库
     */
    @TableField(value = "jiaocai_churu_inout_id")

    private Integer jiaocaiChuruInoutId;


    /**
     * 教材
     */
    @TableField(value = "jiaocai_id")

    private Integer jiaocaiId;


    /**
     * 操作数量
     */
    @TableField(value = "jiaocai_churu_inout_list_number")

    private Integer jiaocaiChuruInoutListNumber;


    /**
     * 操作时间
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
	 * 设置：出入库
	 */
    public Integer getJiaocaiChuruInoutId() {
        return jiaocaiChuruInoutId;
    }
    /**
	 * 获取：出入库
	 */

    public void setJiaocaiChuruInoutId(Integer jiaocaiChuruInoutId) {
        this.jiaocaiChuruInoutId = jiaocaiChuruInoutId;
    }
    /**
	 * 设置：教材
	 */
    public Integer getJiaocaiId() {
        return jiaocaiId;
    }
    /**
	 * 获取：教材
	 */

    public void setJiaocaiId(Integer jiaocaiId) {
        this.jiaocaiId = jiaocaiId;
    }
    /**
	 * 设置：操作数量
	 */
    public Integer getJiaocaiChuruInoutListNumber() {
        return jiaocaiChuruInoutListNumber;
    }
    /**
	 * 获取：操作数量
	 */

    public void setJiaocaiChuruInoutListNumber(Integer jiaocaiChuruInoutListNumber) {
        this.jiaocaiChuruInoutListNumber = jiaocaiChuruInoutListNumber;
    }
    /**
	 * 设置：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：操作时间
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
        return "JiaocaiChuruInoutList{" +
            "id=" + id +
            ", jiaocaiChuruInoutId=" + jiaocaiChuruInoutId +
            ", jiaocaiId=" + jiaocaiId +
            ", jiaocaiChuruInoutListNumber=" + jiaocaiChuruInoutListNumber +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
