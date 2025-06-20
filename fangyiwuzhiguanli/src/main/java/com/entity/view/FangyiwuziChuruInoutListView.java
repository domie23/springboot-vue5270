package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangyiwuziChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 出入库详情
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangyiwuzi_churu_inout_list")
public class FangyiwuziChuruInoutListView extends FangyiwuziChuruInoutListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

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
	//级联表 出入库
		/**
		* 出入库流水号
		*/

		@ColumnInfo(comment="出入库流水号",type="varchar(200)")
		private String fangyiwuziChuruInoutUuidNumber;
		/**
		* 出入库名称
		*/

		@ColumnInfo(comment="出入库名称",type="varchar(200)")
		private String fangyiwuziChuruInoutName;
		/**
		* 出入库类型
		*/
		@ColumnInfo(comment="出入库类型",type="int(11)")
		private Integer fangyiwuziChuruInoutTypes;
			/**
			* 出入库类型的值
			*/
			@ColumnInfo(comment="出入库类型的字典表值",type="varchar(200)")
			private String fangyiwuziChuruInoutValue;
		/**
		* 备注
		*/

		@ColumnInfo(comment="备注",type="text")
		private String fangyiwuziChuruInoutContent;



	public FangyiwuziChuruInoutListView() {

	}

	public FangyiwuziChuruInoutListView(FangyiwuziChuruInoutListEntity fangyiwuziChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, fangyiwuziChuruInoutListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	//级联表的get和set 出入库

		/**
		* 获取： 出入库流水号
		*/
		public String getFangyiwuziChuruInoutUuidNumber() {
			return fangyiwuziChuruInoutUuidNumber;
		}
		/**
		* 设置： 出入库流水号
		*/
		public void setFangyiwuziChuruInoutUuidNumber(String fangyiwuziChuruInoutUuidNumber) {
			this.fangyiwuziChuruInoutUuidNumber = fangyiwuziChuruInoutUuidNumber;
		}

		/**
		* 获取： 出入库名称
		*/
		public String getFangyiwuziChuruInoutName() {
			return fangyiwuziChuruInoutName;
		}
		/**
		* 设置： 出入库名称
		*/
		public void setFangyiwuziChuruInoutName(String fangyiwuziChuruInoutName) {
			this.fangyiwuziChuruInoutName = fangyiwuziChuruInoutName;
		}
		/**
		* 获取： 出入库类型
		*/
		public Integer getFangyiwuziChuruInoutTypes() {
			return fangyiwuziChuruInoutTypes;
		}
		/**
		* 设置： 出入库类型
		*/
		public void setFangyiwuziChuruInoutTypes(Integer fangyiwuziChuruInoutTypes) {
			this.fangyiwuziChuruInoutTypes = fangyiwuziChuruInoutTypes;
		}


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

		/**
		* 获取： 备注
		*/
		public String getFangyiwuziChuruInoutContent() {
			return fangyiwuziChuruInoutContent;
		}
		/**
		* 设置： 备注
		*/
		public void setFangyiwuziChuruInoutContent(String fangyiwuziChuruInoutContent) {
			this.fangyiwuziChuruInoutContent = fangyiwuziChuruInoutContent;
		}


	@Override
	public String toString() {
		return "FangyiwuziChuruInoutListView{" +
			", fangyiwuziChuruInoutUuidNumber=" + fangyiwuziChuruInoutUuidNumber +
			", fangyiwuziChuruInoutName=" + fangyiwuziChuruInoutName +
			", fangyiwuziChuruInoutContent=" + fangyiwuziChuruInoutContent +
			", fangyiwuziUuidNumber=" + fangyiwuziUuidNumber +
			", fangyiwuziName=" + fangyiwuziName +
			", fangyiwuziPhoto=" + fangyiwuziPhoto +
			", fangyiwuziKucunNumber=" + fangyiwuziKucunNumber +
			", fangyiwuziContent=" + fangyiwuziContent +
			", fangyiwuziDelete=" + fangyiwuziDelete +
			"} " + super.toString();
	}
}
