package com.entity.model;

import com.entity.FangyiwuziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangyiwuziModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物资编号
     */
    private String fangyiwuziUuidNumber;


    /**
     * 物资名称
     */
    private String fangyiwuziName;


    /**
     * 物资图片
     */
    private String fangyiwuziPhoto;


    /**
     * 物资类型
     */
    private Integer fangyiwuziTypes;


    /**
     * 物资库存
     */
    private Integer fangyiwuziKucunNumber;


    /**
     * 物资介绍
     */
    private String fangyiwuziContent;


    /**
     * 逻辑删除
     */
    private Integer fangyiwuziDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
