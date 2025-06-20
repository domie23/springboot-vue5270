package com.entity.vo;

import com.entity.FangyiwuziEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangyiwuzi")
public class FangyiwuziVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物资编号
     */

    @TableField(value = "fangyiwuzi_uuid_number")
    private String fangyiwuziUuidNumber;


    /**
     * 物资名称
     */

    @TableField(value = "fangyiwuzi_name")
    private String fangyiwuziName;


    /**
     * 物资图片
     */

    @TableField(value = "fangyiwuzi_photo")
    private String fangyiwuziPhoto;


    /**
     * 物资类型
     */

    @TableField(value = "fangyiwuzi_types")
    private Integer fangyiwuziTypes;


    /**
     * 物资库存
     */

    @TableField(value = "fangyiwuzi_kucun_number")
    private Integer fangyiwuziKucunNumber;


    /**
     * 物资介绍
     */

    @TableField(value = "fangyiwuzi_content")
    private String fangyiwuziContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "fangyiwuzi_delete")
    private Integer fangyiwuziDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 设置：物资编号
	 */
    public String getFangyiwuziUuidNumber() {
        return fangyiwuziUuidNumber;
    }


    /**
	 * 获取：物资编号
	 */

    public void setFangyiwuziUuidNumber(String fangyiwuziUuidNumber) {
        this.fangyiwuziUuidNumber = fangyiwuziUuidNumber;
    }
    /**
	 * 设置：物资名称
	 */
    public String getFangyiwuziName() {
        return fangyiwuziName;
    }


    /**
	 * 获取：物资名称
	 */

    public void setFangyiwuziName(String fangyiwuziName) {
        this.fangyiwuziName = fangyiwuziName;
    }
    /**
	 * 设置：物资图片
	 */
    public String getFangyiwuziPhoto() {
        return fangyiwuziPhoto;
    }


    /**
	 * 获取：物资图片
	 */

    public void setFangyiwuziPhoto(String fangyiwuziPhoto) {
        this.fangyiwuziPhoto = fangyiwuziPhoto;
    }
    /**
	 * 设置：物资类型
	 */
    public Integer getFangyiwuziTypes() {
        return fangyiwuziTypes;
    }


    /**
	 * 获取：物资类型
	 */

    public void setFangyiwuziTypes(Integer fangyiwuziTypes) {
        this.fangyiwuziTypes = fangyiwuziTypes;
    }
    /**
	 * 设置：物资库存
	 */
    public Integer getFangyiwuziKucunNumber() {
        return fangyiwuziKucunNumber;
    }


    /**
	 * 获取：物资库存
	 */

    public void setFangyiwuziKucunNumber(Integer fangyiwuziKucunNumber) {
        this.fangyiwuziKucunNumber = fangyiwuziKucunNumber;
    }
    /**
	 * 设置：物资介绍
	 */
    public String getFangyiwuziContent() {
        return fangyiwuziContent;
    }


    /**
	 * 获取：物资介绍
	 */

    public void setFangyiwuziContent(String fangyiwuziContent) {
        this.fangyiwuziContent = fangyiwuziContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFangyiwuziDelete() {
        return fangyiwuziDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFangyiwuziDelete(Integer fangyiwuziDelete) {
        this.fangyiwuziDelete = fangyiwuziDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
