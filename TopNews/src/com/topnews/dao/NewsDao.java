package com.topnews.dao;

import java.util.List;
import java.util.Map;

import org.json.JSONException;


import net.sf.json.JSONArray;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import android.content.ContentValues;
import android.util.Log;

import com.topnews.app.AppApplication;
import com.topnews.bean.NewsEntity;

public class NewsDao implements NewsDaoInface{

	List<NewsEntity> newsList;
	
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
		    		Log.e("GETUSER", t);
		    		JSONArray array=JSONArray.fromObject(t);
					NewsDao.this.newsList=(List<NewsEntity>) JSONArray.toCollection(array, NewsEntity.class);
		    }
		    @Override
		    public void onStart() {
		        //开始http请求的时候回调
		    }

		    @Override
			public void onFailure(Throwable t,int errorNo ,String strMsg){
		        //加载失败的时候回调
		    	Log.e("GETUSER"+strMsg, t.toString());
		    }
		    
		});
		return this.newsList;
	}

}
