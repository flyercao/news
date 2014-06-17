package com.topnews.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.tsz.afinal.FinalDb;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.topnews.app.AppApplication;
import com.topnews.base.BaseHttpClient;
import com.topnews.base.Page;
import com.topnews.bean.NewsEntity;

public class NewsDao implements NewsDaoInface{
	public static final String TAG="NewsDao";

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
	
	
	public static void getAllUser(final Context context,final Handler handler,int newsCategoryId){
		HttpPost postMethod = new HttpPost(AppApplication.getURL()+"/news/getRecentNews");  

        try {  
        	List<NameValuePair> params = new ArrayList<NameValuePair>();  
			params.add(new BasicNameValuePair("newsItem.newsCategoryId", newsCategoryId+"")); 
			params.add(new BasicNameValuePair("newsItem.publishTime", new Date().getTime()+""));  
		                //  设置HTTP POST请求参数  
			postMethod.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));  
        	HttpClient httpClient = BaseHttpClient.getHttpClient();  

        	HttpResponse response = httpClient.execute(postMethod); //发起GET请求  
        	int statusCode=response.getStatusLine().getStatusCode();
        	Log.e(TAG, "resCode = " + statusCode); //获取响应码  
        	if(statusCode==200){
            	String content=EntityUtils.toString(response.getEntity(),"utf-8");
            	final Page news  = new Page().transferToObj(content);
            	new Thread(){
            		public void run(){
            			FinalDb db=new AppApplication().getDb();
            			for(int i=0;i<news.getList().size();i++){
            				db.save(news.getList().get(i));
            			}
            		}
            	}.start();
            	handler.obtainMessage(AppApplication.LOAD_DATA_SUCCESS,news).sendToTarget();
            	return ;
        	}
        } catch (Exception e) {   
        }  
    	handler.obtainMessage(AppApplication.LOAD_DATA_FAILD).sendToTarget();
	}
	
	public  static void getAllUser(){
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
	}
}
