package com.entity.vo;

import com.entity.FangyiwuziYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangyiwuzi_yuyue")
public class FangyiwuziYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物资
     */

    @TableField(value = "fangyiwuzi_id")
    private Integer fangyiwuziId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 申请数量
     */

    @TableField(value = "fangyiwuzi_yuyue_number")
    private Integer fangyiwuziYuyueNumber;


    /**
     * 申请状态
     */

    @TableField(value = "fangyiwuzi_yuyue_yesno_types")
    private Integer fangyiwuziYuyueYesnoTypes;


    /**
     * 申请结果
     */

    @TableField(value = "fangyiwuzi_yuyue_yesno_text")
    private String fangyiwuziYuyueYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：物资
	 */
    public Integer getFangyiwuziId() {
        return fangyiwuziId;
    }


    /**
	 * 获取：物资
	 */

    public void setFangyiwuziId(Integer fangyiwuziId) {
        this.fangyiwuziId = fangyiwuziId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：申请数量
	 */
    public Integer getFangyiwuziYuyueNumber() {
        return fangyiwuziYuyueNumber;
    }


    /**
	 * 获取：申请数量
	 */

    public void setFangyiwuziYuyueNumber(Integer fangyiwuziYuyueNumber) {
        this.fangyiwuziYuyueNumber = fangyiwuziYuyueNumber;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getFangyiwuziYuyueYesnoTypes() {
        return fangyiwuziYuyueYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setFangyiwuziYuyueYesnoTypes(Integer fangyiwuziYuyueYesnoTypes) {
        this.fangyiwuziYuyueYesnoTypes = fangyiwuziYuyueYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getFangyiwuziYuyueYesnoText() {
        return fangyiwuziYuyueYesnoText;
    }


    /**
	 * 获取：申请结果
	 */

    public void setFangyiwuziYuyueYesnoText(String fangyiwuziYuyueYesnoText) {
        this.fangyiwuziYuyueYesnoText = fangyiwuziYuyueYesnoText;
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
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
