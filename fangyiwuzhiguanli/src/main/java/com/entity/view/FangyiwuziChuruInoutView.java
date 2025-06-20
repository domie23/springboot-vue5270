package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangyiwuziChuruInoutEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 出入库
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangyiwuzi_churu_inout")
public class FangyiwuziChuruInoutView extends FangyiwuziChuruInoutEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 出入库类型的值
	*/
	@ColumnInfo(comment="出入库类型的字典表值",type="varchar(200)")
	private String fangyiwuziChuruInoutValue;




	public FangyiwuziChuruInoutView() {

	}

	public FangyiwuziChuruInoutView(FangyiwuziChuruInoutEntity fangyiwuziChuruInoutEntity) {
		try {
			BeanUtils.copyProperties(this, fangyiwuziChuruInoutEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 出入库类型的值
	*/
	public String getFangyiwuziChuruInoutValue() {
		return fangyiwuziChuruInoutValue;
	}
	/**
	* 设置： 出入库类型的值
	*/
	public void setFangyiwuziChuruInoutValue(String fangyiwuziChuruInoutValue) {
		this.fangyiwuziChuruInoutValue = fangyiwuziChuruInoutValue;
	}




	@Override
	public String toString() {
		return "FangyiwuziChuruInoutView{" +
			", fangyiwuziChuruInoutValue=" + fangyiwuziChuruInoutValue +
			"} " + super.toString();
	}
}
