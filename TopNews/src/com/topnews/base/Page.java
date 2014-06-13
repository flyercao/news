package com.topnews.base;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.topnews.bean.NewsEntity;



public class Page<T> implements Serializable {
	
	private static final long serialVersionUID = -5395997221963176643L;
	
	private List<NewsEntity> list=new ArrayList<NewsEntity>();	
//	private JSONArray array=new JSONArray();			// list result of this page
//	public JSONArray getArray() {
//		return array;
//	}
//
//	public void setArray(JSONArray array) {
//		this.array = array;
//	}


	private int pageNumber;				// page number
	private int pageSize;				// result amount of this page
	private int totalPage;				// total page
	private int totalRow;				// total row
	
	/**
	 * Constructor.
	 * @param list the list of paginate result
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @param totalPage the total page of paginate
	 * @param totalRow the total row of paginate
	 */
	public Page(List<NewsEntity> list, int pageNumber, int pageSize, int totalPage, int totalRow) {
		this.list = list;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalRow = totalRow;
	}
	
	public Page(){
		
	}
	
	/**
	 * Return list of this page.
	 */
	public List<NewsEntity> getList() {
		return list;
	}
	
	/**
	 * Return page number.
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	
	/**
	 * Return page size.
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * Return total page.
	 */
	public int getTotalPage() {
		return totalPage;
	}
	
	/**
	 * Return total row.
	 */
	public int getTotalRow() {
		return totalRow;
	}
	
	
	public  Page transferToObj(String json) {
		Page page=(Page) JSON.parseObject(json, Page.class);
//		page.pageNumber=obj.getInt("pageNumber");
//		page.pageSize=obj.getInt("pageSize");
//		page.totalPage=obj.getInt("totalPage");
//		page.totalRow=obj.getInt("totalRow");
//		array=obj.getJSONArray("list");
		return page;
	}
}


