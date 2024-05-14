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
 * 教材管理员
 *
 * @author 
 * @email
 */
@TableName("jiaocaiguanli")
public class JiaocaiguanliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaocaiguanliEntity() {

	}

	public JiaocaiguanliEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 教材管理员姓名
     */
    @TableField(value = "jiaocaiguanli_name")

    private String jiaocaiguanliName;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 联系方式
     */
    @TableField(value = "jiaocaiguanli_phone")

    private String jiaocaiguanliPhone;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：教材管理员姓名
	 */
    public String getJiaocaiguanliName() {
        return jiaocaiguanliName;
    }
    /**
	 * 获取：教材管理员姓名
	 */

    public void setJiaocaiguanliName(String jiaocaiguanliName) {
        this.jiaocaiguanliName = jiaocaiguanliName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getJiaocaiguanliPhone() {
        return jiaocaiguanliPhone;
    }
    /**
	 * 获取：联系方式
	 */

    public void setJiaocaiguanliPhone(String jiaocaiguanliPhone) {
        this.jiaocaiguanliPhone = jiaocaiguanliPhone;
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
        return "Jiaocaiguanli{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", jiaocaiguanliName=" + jiaocaiguanliName +
            ", sexTypes=" + sexTypes +
            ", jiaocaiguanliPhone=" + jiaocaiguanliPhone +
            ", createTime=" + createTime +
        "}";
    }
}
