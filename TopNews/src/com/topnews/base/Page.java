package com.topnews.base;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Page<T> implements Serializable {
	
	private static final long serialVersionUID = -5395997221963176643L;
	
	private List<T> list=new ArrayList<T>();	
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
	public Page(List<T> list, int pageNumber, int pageSize, int totalPage, int totalRow) {
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
	public List<T> getList() {
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
	
	
	public  Page<T> transferToObj(String json) {
		Page<T> page=new Page<T>();
		JSONObject obj=JSONObject.fromObject(json);
		page.pageNumber=obj.getInt("pageNumber");
		page.pageSize=obj.getInt("pageSize");
		page.totalPage=obj.getInt("totalPage");
		page.totalRow=obj.getInt("totalRow");
//		array=obj.getJSONArray("list");
		return page;
	}
}


