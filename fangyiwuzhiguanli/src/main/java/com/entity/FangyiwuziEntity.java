package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 物资
 *
 * @author 
 * @email
 */
@TableName("fangyiwuzi")
public class FangyiwuziEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangyiwuziEntity() {

	}

	public FangyiwuziEntity(T t) {
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
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 物资编号
     */
    @ColumnInfo(comment="物资编号",type="varchar(200)")
    @TableField(value = "fangyiwuzi_uuid_number")

    private String fangyiwuziUuidNumber;


    /**
     * 物资名称
     */
    @ColumnInfo(comment="物资名称",type="varchar(200)")
    @TableField(value = "fangyiwuzi_name")

    private String fangyiwuziName;


    /**
     * 物资图片
     */
    @ColumnInfo(comment="物资图片",type="varchar(200)")
    @TableField(value = "fangyiwuzi_photo")

    private String fangyiwuziPhoto;


    /**
     * 物资类型
     */
    @ColumnInfo(comment="物资类型",type="int(11)")
    @TableField(value = "fangyiwuzi_types")

    private Integer fangyiwuziTypes;


    /**
     * 物资库存
     */
    @ColumnInfo(comment="物资库存",type="int(11)")
    @TableField(value = "fangyiwuzi_kucun_number")

    private Integer fangyiwuziKucunNumber;


    /**
     * 物资介绍
     */
    @ColumnInfo(comment="物资介绍",type="text")
    @TableField(value = "fangyiwuzi_content")

    private String fangyiwuziContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "fangyiwuzi_delete")

    private Integer fangyiwuziDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间     homeMain",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：物资编号
	 */
    public String getFangyiwuziUuidNumber() {
        return fangyiwuziUuidNumber;
    }
    /**
	 * 设置：物资编号
	 */

    public void setFangyiwuziUuidNumber(String fangyiwuziUuidNumber) {
        this.fangyiwuziUuidNumber = fangyiwuziUuidNumber;
    }
    /**
	 * 获取：物资名称
	 */
    public String getFangyiwuziName() {
        return fangyiwuziName;
    }
    /**
	 * 设置：物资名称
	 */

    public void setFangyiwuziName(String fangyiwuziName) {
        this.fangyiwuziName = fangyiwuziName;
    }
    /**
	 * 获取：物资图片
	 */
    public String getFangyiwuziPhoto() {
        return fangyiwuziPhoto;
    }
    /**
	 * 设置：物资图片
	 */

    public void setFangyiwuziPhoto(String fangyiwuziPhoto) {
        this.fangyiwuziPhoto = fangyiwuziPhoto;
    }
    /**
	 * 获取：物资类型
	 */
    public Integer getFangyiwuziTypes() {
        return fangyiwuziTypes;
    }
    /**
	 * 设置：物资类型
	 */

    public void setFangyiwuziTypes(Integer fangyiwuziTypes) {
        this.fangyiwuziTypes = fangyiwuziTypes;
    }
    /**
	 * 获取：物资库存
	 */
    public Integer getFangyiwuziKucunNumber() {
        return fangyiwuziKucunNumber;
    }
    /**
	 * 设置：物资库存
	 */

    public void setFangyiwuziKucunNumber(Integer fangyiwuziKucunNumber) {
        this.fangyiwuziKucunNumber = fangyiwuziKucunNumber;
    }
    /**
	 * 获取：物资介绍
	 */
    public String getFangyiwuziContent() {
        return fangyiwuziContent;
    }
    /**
	 * 设置：物资介绍
	 */

    public void setFangyiwuziContent(String fangyiwuziContent) {
        this.fangyiwuziContent = fangyiwuziContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangyiwuziDelete() {
        return fangyiwuziDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFangyiwuziDelete(Integer fangyiwuziDelete) {
        this.fangyiwuziDelete = fangyiwuziDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Fangyiwuzi{" +
            ", id=" + id +
            ", fangyiwuziUuidNumber=" + fangyiwuziUuidNumber +
            ", fangyiwuziName=" + fangyiwuziName +
            ", fangyiwuziPhoto=" + fangyiwuziPhoto +
            ", fangyiwuziTypes=" + fangyiwuziTypes +
            ", fangyiwuziKucunNumber=" + fangyiwuziKucunNumber +
            ", fangyiwuziContent=" + fangyiwuziContent +
            ", fangyiwuziDelete=" + fangyiwuziDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
