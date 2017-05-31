package com.iebm.aid.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页参数")
public class PageParam {

	@ApiModelProperty("页码,第一页为1")
	protected int page = 1;
	
	@ApiModelProperty("每页显示数量,默认10")
	protected int rows = 10;
	
	@ApiModelProperty("要排序的字段")
	protected String sort;
	
	@ApiModelProperty("desc,asc")
	protected String order;
	
	public int getPage() {
		page--;
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
}
