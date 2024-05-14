package com.entity.vo;

import com.entity.XueshengshenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学生申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xueshengshenqing")
public class XueshengshenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
