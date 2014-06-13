package com.topnews.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.tsz.afinal.FinalDb;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import org.json.JSONException;

import android.content.ContentValues;
import android.util.Log;

import com.topnews.app.AppApplication;
import com.topnews.base.Page;
import com.topnews.bean.NewsEntity;

public class NewsDao implements NewsDaoInface{
	private final String TAG="NewsDao";

	List<NewsEntity> newsList=new ArrayList<NewsEntity>();
	
	@Override
	public boolean addCache(NewsEntity item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCache(String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCache(ContentValues values, String whereClause,
			String[] whereArgs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, String> viewCache(String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> listCache(String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearFeedTable() {
		// TODO Auto-generated method stub
		
	}
	
	
	public List<NewsEntity> getAllUser(){
		FinalHttp fh = new FinalHttp();
		fh.get(AppApplication.getURL()+"/news/getRecentNews", new AjaxCallBack<String>(){

		    @Override
		    public void onLoading(long count, long current) { //每1秒钟自动被回调一次
		            Log.e("GETUSER", "loading "+current+"/"+count);
		    }

		    @Override
					public void onSuccess(String t) {
						Log.e(TAG, t);
						Page news  = new Page().transferToObj(t);
						NewsDao.this.newsList=news.getList();
						Log.e(TAG, "pageSize=====" + news.getPageSize());
					}
		    @Override
		    public void onStart() {
		    }

		    @Override
			public void onFailure(Throwable t,int errorNo ,String strMsg){
		        //加载失败的时候回调
		    	Log.e("GETUSER"+strMsg, t.toString());
		    }
		    
		});
		return this.newsList;
	}

//	public static void main(String args[]){
//		String t="{'pageSize':10,'pageNumber':1,'list':[{'summary':'','newsAbstract':null,'publishTime':'2014-06-11 11:04:18','picListString':null,'source_url':'f1176.html','isLarge':1,'picThr':null,'newsCategoryId':'1','mark':0,'picOne':'http:0','id':'bgdfngfm24jmh','commentNum':5,'title':'IPO温室中重启 A股难成大器','source':'腾讯','local':null,'comment':'实际上，IPO重启意味着A股市场一个正常的恢复融资功能的举措，对于资本市场而言长远来看是利好，但为何需要精心\u201C呵护\u201D？','picTwo':null}],'totalRow':1,'totalPage':1}";
//		Map classMap = new HashMap();
//        classMap.put("list", NewsEntity.class);
//		Page<NewsEntity> diyBean = (Page<NewsEntity>)JSONObject.toBean(JSONObject.fromObject(t),Page.class , classMap);
//		for(NewsEntity news : diyBean.getList()){
//			System.out.println("GETUSER-----"+ news.getTitle());
//		}
//	}
//	
//	
}
