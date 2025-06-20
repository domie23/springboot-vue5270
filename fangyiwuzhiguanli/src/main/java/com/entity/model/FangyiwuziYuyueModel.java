package com.entity.model;

import com.entity.FangyiwuziYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangyiwuziYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物资
     */
    private Integer fangyiwuziId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 申请数量
     */
    private Integer fangyiwuziYuyueNumber;


    /**
     * 申请状态
     */
    private Integer fangyiwuziYuyueYesnoTypes;


    /**
     * 申请结果
     */
    private String fangyiwuziYuyueYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：物资
	 */
    public Integer getFangyiwuziId() {
        return fangyiwuziId;
    }


    /**
	 * 设置：物资
	 */
    public void setFangyiwuziId(Integer fangyiwuziId) {
        this.fangyiwuziId = fangyiwuziId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：申请数量
	 */
    public Integer getFangyiwuziYuyueNumber() {
        return fangyiwuziYuyueNumber;
    }


    /**
	 * 设置：申请数量
	 */
    public void setFangyiwuziYuyueNumber(Integer fangyiwuziYuyueNumber) {
        this.fangyiwuziYuyueNumber = fangyiwuziYuyueNumber;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getFangyiwuziYuyueYesnoTypes() {
        return fangyiwuziYuyueYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setFangyiwuziYuyueYesnoTypes(Integer fangyiwuziYuyueYesnoTypes) {
        this.fangyiwuziYuyueYesnoTypes = fangyiwuziYuyueYesnoTypes;
    }
    /**
	 * 获取：申请结果
	 */
    public String getFangyiwuziYuyueYesnoText() {
        return fangyiwuziYuyueYesnoText;
    }


    /**
	 * 设置：申请结果
	 */
    public void setFangyiwuziYuyueYesnoText(String fangyiwuziYuyueYesnoText) {
        this.fangyiwuziYuyueYesnoText = fangyiwuziYuyueYesnoText;
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
