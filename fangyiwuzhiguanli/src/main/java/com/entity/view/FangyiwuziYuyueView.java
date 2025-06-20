package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangyiwuziYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 物资申请
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangyiwuzi_yuyue")
public class FangyiwuziYuyueView extends FangyiwuziYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String fangyiwuziYuyueYesnoValue;

	//级联表 物资
		/**
		* 物资编号
		*/

		@ColumnInfo(comment="物资编号",type="varchar(200)")
		private String fangyiwuziUuidNumber;
		/**
		* 物资名称
		*/

		@ColumnInfo(comment="物资名称",type="varchar(200)")
		private String fangyiwuziName;
		/**
		* 物资图片
		*/

		@ColumnInfo(comment="物资图片",type="varchar(200)")
		private String fangyiwuziPhoto;
		/**
		* 物资类型
		*/
		@ColumnInfo(comment="物资类型",type="int(11)")
		private Integer fangyiwuziTypes;
			/**
			* 物资类型的值
			*/
			@ColumnInfo(comment="物资类型的字典表值",type="varchar(200)")
			private String fangyiwuziValue;
		/**
		* 物资库存
		*/

		@ColumnInfo(comment="物资库存",type="int(11)")
		private Integer fangyiwuziKucunNumber;
		/**
		* 物资介绍
		*/

		@ColumnInfo(comment="物资介绍",type="text")
		private String fangyiwuziContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer fangyiwuziDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 地址
		*/

		@ColumnInfo(comment="地址",type="varchar(200)")
		private String yonghuAddress;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public FangyiwuziYuyueView() {

	}

	public FangyiwuziYuyueView(FangyiwuziYuyueEntity fangyiwuziYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, fangyiwuziYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getFangyiwuziYuyueYesnoValue() {
		return fangyiwuziYuyueYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setFangyiwuziYuyueYesnoValue(String fangyiwuziYuyueYesnoValue) {
		this.fangyiwuziYuyueYesnoValue = fangyiwuziYuyueYesnoValue;
	}


	//级联表的get和set 物资

		/**
		* 获取： 物资编号
		*/
		public String getFangyiwuziUuidNumber() {
			return fangyiwuziUuidNumber;
		}
		/**
		* 设置： 物资编号
		*/
		public void setFangyiwuziUuidNumber(String fangyiwuziUuidNumber) {
			this.fangyiwuziUuidNumber = fangyiwuziUuidNumber;
		}

		/**
		* 获取： 物资名称
		*/
		public String getFangyiwuziName() {
			return fangyiwuziName;
		}
		/**
		* 设置： 物资名称
		*/
		public void setFangyiwuziName(String fangyiwuziName) {
			this.fangyiwuziName = fangyiwuziName;
		}

		/**
		* 获取： 物资图片
		*/
		public String getFangyiwuziPhoto() {
			return fangyiwuziPhoto;
		}
		/**
		* 设置： 物资图片
		*/
		public void setFangyiwuziPhoto(String fangyiwuziPhoto) {
			this.fangyiwuziPhoto = fangyiwuziPhoto;
		}
		/**
		* 获取： 物资类型
		*/
		public Integer getFangyiwuziTypes() {
			return fangyiwuziTypes;
		}
		/**
		* 设置： 物资类型
		*/
		public void setFangyiwuziTypes(Integer fangyiwuziTypes) {
			this.fangyiwuziTypes = fangyiwuziTypes;
		}


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

		/**
		* 获取： 物资库存
		*/
		public Integer getFangyiwuziKucunNumber() {
			return fangyiwuziKucunNumber;
		}
		/**
		* 设置： 物资库存
		*/
		public void setFangyiwuziKucunNumber(Integer fangyiwuziKucunNumber) {
			this.fangyiwuziKucunNumber = fangyiwuziKucunNumber;
		}

		/**
		* 获取： 物资介绍
		*/
		public String getFangyiwuziContent() {
			return fangyiwuziContent;
		}
		/**
		* 设置： 物资介绍
		*/
		public void setFangyiwuziContent(String fangyiwuziContent) {
			this.fangyiwuziContent = fangyiwuziContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getFangyiwuziDelete() {
			return fangyiwuziDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setFangyiwuziDelete(Integer fangyiwuziDelete) {
			this.fangyiwuziDelete = fangyiwuziDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 地址
		*/
		public String getYonghuAddress() {
			return yonghuAddress;
		}
		/**
		* 设置： 地址
		*/
		public void setYonghuAddress(String yonghuAddress) {
			this.yonghuAddress = yonghuAddress;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "FangyiwuziYuyueView{" +
			", fangyiwuziYuyueYesnoValue=" + fangyiwuziYuyueYesnoValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuAddress=" + yonghuAddress +
			", yonghuDelete=" + yonghuDelete +
			", fangyiwuziUuidNumber=" + fangyiwuziUuidNumber +
			", fangyiwuziName=" + fangyiwuziName +
			", fangyiwuziPhoto=" + fangyiwuziPhoto +
			", fangyiwuziKucunNumber=" + fangyiwuziKucunNumber +
			", fangyiwuziContent=" + fangyiwuziContent +
			", fangyiwuziDelete=" + fangyiwuziDelete +
			"} " + super.toString();
	}
}
