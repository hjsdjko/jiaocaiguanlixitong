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
 * 教师申请
 *
 * @author 
 * @email
 */
@TableName("jiaoshishenqing")
public class JiaoshishenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaoshishenqingEntity() {

	}

	public JiaoshishenqingEntity(T t) {
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
     * 申请编号
     */
    @TableField(value = "jiaoshishenqing_uuid_number")

    private String jiaoshishenqingUuidNumber;


    /**
     * 教材
     */
    @TableField(value = "jiaocai_id")

    private Integer jiaocaiId;


    /**
     * 教师
     */
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 申请数量
     */
    @TableField(value = "jiaoshishenqing_number")

    private Integer jiaoshishenqingNumber;


    /**
     * 课程
     */
    @TableField(value = "kecheng_types")

    private Integer kechengTypes;


    /**
     * 班级
     */
    @TableField(value = "banji_types")

    private Integer banjiTypes;


    /**
     * 申请状态
     */
    @TableField(value = "jiaoshishenqing_yesno_types")

    private Integer jiaoshishenqingYesnoTypes;


    /**
     * 申请结果
     */
    @TableField(value = "jiaoshishenqing_yesno_text")

    private String jiaoshishenqingYesnoText;


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
	 * 设置：申请编号
	 */
    public String getJiaoshishenqingUuidNumber() {
        return jiaoshishenqingUuidNumber;
    }
    /**
	 * 获取：申请编号
	 */

    public void setJiaoshishenqingUuidNumber(String jiaoshishenqingUuidNumber) {
        this.jiaoshishenqingUuidNumber = jiaoshishenqingUuidNumber;
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
	 * 设置：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }
    /**
	 * 获取：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
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
	 * 设置：课程
	 */
    public Integer getKechengTypes() {
        return kechengTypes;
    }
    /**
	 * 获取：课程
	 */

    public void setKechengTypes(Integer kechengTypes) {
        this.kechengTypes = kechengTypes;
    }
    /**
	 * 设置：班级
	 */
    public Integer getBanjiTypes() {
        return banjiTypes;
    }
    /**
	 * 获取：班级
	 */

    public void setBanjiTypes(Integer banjiTypes) {
        this.banjiTypes = banjiTypes;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getJiaoshishenqingYesnoTypes() {
        return jiaoshishenqingYesnoTypes;
    }
    /**
	 * 获取：申请状态
	 */

    public void setJiaoshishenqingYesnoTypes(Integer jiaoshishenqingYesnoTypes) {
        this.jiaoshishenqingYesnoTypes = jiaoshishenqingYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getJiaoshishenqingYesnoText() {
        return jiaoshishenqingYesnoText;
    }
    /**
	 * 获取：申请结果
	 */

    public void setJiaoshishenqingYesnoText(String jiaoshishenqingYesnoText) {
        this.jiaoshishenqingYesnoText = jiaoshishenqingYesnoText;
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
        return "Jiaoshishenqing{" +
            "id=" + id +
            ", jiaoshishenqingUuidNumber=" + jiaoshishenqingUuidNumber +
            ", jiaocaiId=" + jiaocaiId +
            ", jiaoshiId=" + jiaoshiId +
            ", jiaoshishenqingNumber=" + jiaoshishenqingNumber +
            ", kechengTypes=" + kechengTypes +
            ", banjiTypes=" + banjiTypes +
            ", jiaoshishenqingYesnoTypes=" + jiaoshishenqingYesnoTypes +
            ", jiaoshishenqingYesnoText=" + jiaoshishenqingYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
