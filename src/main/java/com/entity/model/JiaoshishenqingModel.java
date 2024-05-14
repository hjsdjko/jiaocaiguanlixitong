package com.entity.model;

import com.entity.JiaoshishenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教师申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaoshishenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请编号
     */
    private String jiaoshishenqingUuidNumber;


    /**
     * 教材
     */
    private Integer jiaocaiId;


    /**
     * 教师
     */
    private Integer jiaoshiId;


    /**
     * 申请数量
     */
    private Integer jiaoshishenqingNumber;


    /**
     * 课程
     */
    private Integer kechengTypes;


    /**
     * 班级
     */
    private Integer banjiTypes;


    /**
     * 申请状态
     */
    private Integer jiaoshishenqingYesnoTypes;


    /**
     * 申请结果
     */
    private String jiaoshishenqingYesnoText;


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
	 * 获取：申请编号
	 */
    public String getJiaoshishenqingUuidNumber() {
        return jiaoshishenqingUuidNumber;
    }


    /**
	 * 设置：申请编号
	 */
    public void setJiaoshishenqingUuidNumber(String jiaoshishenqingUuidNumber) {
        this.jiaoshishenqingUuidNumber = jiaoshishenqingUuidNumber;
    }
    /**
	 * 获取：教材
	 */
    public Integer getJiaocaiId() {
        return jiaocaiId;
    }


    /**
	 * 设置：教材
	 */
    public void setJiaocaiId(Integer jiaocaiId) {
        this.jiaocaiId = jiaocaiId;
    }
    /**
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
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
	 * 获取：课程
	 */
    public Integer getKechengTypes() {
        return kechengTypes;
    }


    /**
	 * 设置：课程
	 */
    public void setKechengTypes(Integer kechengTypes) {
        this.kechengTypes = kechengTypes;
    }
    /**
	 * 获取：班级
	 */
    public Integer getBanjiTypes() {
        return banjiTypes;
    }


    /**
	 * 设置：班级
	 */
    public void setBanjiTypes(Integer banjiTypes) {
        this.banjiTypes = banjiTypes;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getJiaoshishenqingYesnoTypes() {
        return jiaoshishenqingYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setJiaoshishenqingYesnoTypes(Integer jiaoshishenqingYesnoTypes) {
        this.jiaoshishenqingYesnoTypes = jiaoshishenqingYesnoTypes;
    }
    /**
	 * 获取：申请结果
	 */
    public String getJiaoshishenqingYesnoText() {
        return jiaoshishenqingYesnoText;
    }


    /**
	 * 设置：申请结果
	 */
    public void setJiaoshishenqingYesnoText(String jiaoshishenqingYesnoText) {
        this.jiaoshishenqingYesnoText = jiaoshishenqingYesnoText;
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
