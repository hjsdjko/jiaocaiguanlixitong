package com.entity.vo;

import com.entity.JiaocaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 教材信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaocai")
public class JiaocaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
