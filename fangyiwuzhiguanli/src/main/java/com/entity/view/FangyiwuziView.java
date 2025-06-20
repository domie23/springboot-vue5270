package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangyiwuziEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 物资
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangyiwuzi")
public class FangyiwuziView extends FangyiwuziEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 物资类型的值
	*/
	@ColumnInfo(comment="物资类型的字典表值",type="varchar(200)")
	private String fangyiwuziValue;




	public FangyiwuziView() {

	}

	public FangyiwuziView(FangyiwuziEntity fangyiwuziEntity) {
		try {
			BeanUtils.copyProperties(this, fangyiwuziEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 物资类型的值
	*/
	public String getFangyiwuziValue() {
		return fangyiwuziValue;
	}
	/**
	* 设置： 物资类型的值
	*/
	public void setFangyiwuziValue(String fangyiwuziValue) {
		this.fangyiwuziValue = fangyiwuziValue;
	}




	@Override
	public String toString() {
		return "FangyiwuziView{" +
			", fangyiwuziValue=" + fangyiwuziValue +
			"} " + super.toString();
	}
}
