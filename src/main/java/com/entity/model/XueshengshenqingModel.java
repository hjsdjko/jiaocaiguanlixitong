package com.entity.model;

import com.entity.XueshengshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueshengshenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 教材
     */
    private Integer jiaoshishenqingId;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 申请数量
     */
    private Integer jiaoshishenqingNumber;


    /**
     * 申请状态
     */
    private Integer xueshengshenqingYesnoTypes;


    /**
     * 申请结果
     */
    private String xueshengshenqingYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：教材
	 */
    public Integer getJiaoshishenqingId() {
        return jiaoshishenqingId;
    }


    /**
	 * 设置：教材
	 */
    public void setJiaoshishenqingId(Integer jiaoshishenqingId) {
        this.jiaoshishenqingId = jiaoshishenqingId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：申请数量
	 */
    public Integer getJiaoshishenqingNumber() {
        return jiaoshishenqingNumber;
    }


    /**
	 * 设置：申请数量
	 */
    public void setJiaoshishenqingNumber(Integer jiaoshishenqingNumber) {
        this.jiaoshishenqingNumber = jiaoshishenqingNumber;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getXueshengshenqingYesnoTypes() {
        return xueshengshenqingYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setXueshengshenqingYesnoTypes(Integer xueshengshenqingYesnoTypes) {
        this.xueshengshenqingYesnoTypes = xueshengshenqingYesnoTypes;
    }
    /**
	 * 获取：申请结果
	 */
    public String getXueshengshenqingYesnoText() {
        return xueshengshenqingYesnoText;
    }


    /**
	 * 设置：申请结果
	 */
    public void setXueshengshenqingYesnoText(String xueshengshenqingYesnoText) {
        this.xueshengshenqingYesnoText = xueshengshenqingYesnoText;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
