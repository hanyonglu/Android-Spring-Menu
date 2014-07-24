package com.spring.menu.utility;

import android.content.Context;
import android.view.WindowManager;

/**
 * 设备基本操作类
 * @Description: 设备基本操作类

 * @File: DeviceUtility.java

 * @Package com.spring.menu.utility

 * @Author Hanyonglu

 * @Date 2012-10-25 下午06:26:26

 * @Version V1.0
 */
public class DeviceUtility{
	/**
	 * 获取屏幕的尺寸
	 * @param context
	 * @return
	 */
	public static int[] getScreenSize(Context context){
		WindowManager wm = (WindowManager) context.getSystemService(
						    Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();//屏幕宽度
		int height = wm.getDefaultDisplay().getHeight();//屏幕高度
		int[] size = {width,height};
		
		return size;
	}
	
	/**
	 * 获取状态栏高度
	 * @param context
	 * @return
	 */
	public static int getStatusBarHeight(Context context){
		int statusBarHeight = 0;
		// 这里只需要获取屏幕高度
		int screenHeight = getScreenSize(context)[1];
		
		switch(screenHeight){
		case 240:
			statusBarHeight = 20;
			break;
		case 480:
			statusBarHeight = 25;
			break;
		case 800:
			statusBarHeight = 38;
			break;
		default:
			break;
		}
		
		return statusBarHeight;
	}
}
