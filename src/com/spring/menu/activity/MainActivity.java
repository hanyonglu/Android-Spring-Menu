package com.spring.menu.activity;

import com.spring.menu.R;
import com.spring.menu.animation.SpringAnimation;
import com.spring.menu.animation.EnlargeAnimationOut;
import com.spring.menu.animation.ShrinkAnimationOut;
import com.spring.menu.animation.ZoomAnimation;
import com.spring.menu.utility.DeviceUtility;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.widget.RelativeLayout;

/**
 * Android实现伸缩弹力分布菜单效果
 * @Description: Android实现伸缩弹力分布菜单效果

 * @File: MainActivity.java

 * @Package com.spring.menu.activity

 * @Author Hanyonglu

 * @Date 2012-10-25 下午09:41:31

 * @Version V1.0
 */
public class MainActivity extends Activity {
	private boolean	areMenusShowing;
	private ViewGroup menusWrapper;
	private View imageViewPlus;
	private View shrinkRelativeLayout;
	private RelativeLayout layoutMain;
	// 顺时针旋转动画
	private Animation animRotateClockwise;
	// 你试着旋转动画
	private Animation animRotateAntiClockwise;
	private Class<?>[] intentActivity = {
			SecondActivity.class,ThreeActivity.class,FourActivity.class,
			SecondActivity.class,ThreeActivity.class,FourActivity.class};
	private int[] mainResources = {
			R.drawable.bg_main_1,R.drawable.bg_main_2,
			R.drawable.bg_main_3,R.drawable.bg_main_4,
			R.drawable.bg_main_1,R.drawable.bg_main_4};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		// 初始化
		initViews();
	}
	
	// 初始化
	private void initViews(){
		imageViewPlus = findViewById(R.id.imageview_plus);
		menusWrapper = (ViewGroup) findViewById(R.id.menus_wrapper);
		shrinkRelativeLayout = findViewById(R.id.relativelayout_shrink);
		layoutMain = (RelativeLayout) findViewById(R.id.layout_content);
		
		animRotateClockwise = AnimationUtils.loadAnimation(
				this,R.anim.rotate_clockwise);
		animRotateAntiClockwise = AnimationUtils.loadAnimation(
				this,R.anim.rotate_anticlockwise);

		shrinkRelativeLayout.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				showLinearMenus();
			}
		});
		
		for (int i = 0; i < menusWrapper.getChildCount(); i++) {
			menusWrapper.getChildAt(i).setOnClickListener(
					new SpringMenuLauncher(null,mainResources[i]));
		}
	}

	/**
	 * 以直线型展开菜单
	 */
	private void showLinearMenus() {
		int[] size = DeviceUtility.getScreenSize(this);
		
		if (!areMenusShowing) {
			SpringAnimation.startAnimations(
					this.menusWrapper, ZoomAnimation.Direction.SHOW, size);
			this.imageViewPlus.startAnimation(this.animRotateClockwise);
		} else {
			SpringAnimation.startAnimations(
					this.menusWrapper, ZoomAnimation.Direction.HIDE, size);
			this.imageViewPlus.startAnimation(this.animRotateAntiClockwise);
		}
		
		areMenusShowing = !areMenusShowing;
	}

	// 分布菜单事件监听器
	private class SpringMenuLauncher implements OnClickListener {
		private final Class<?> cls;
		private int resource;

		private SpringMenuLauncher(Class<?> c,int resource) {
			this.cls = c;
			this.resource = resource;
		}

		public void onClick(View v) {
			// TODO Auto-generated method stub
			MainActivity.this.startSpringMenuAnimations(v);
			layoutMain.setBackgroundResource(resource);
			
//			MainActivity.this.startActivity(
//					new Intent(
//							MainActivity.this,
//							MainActivity.SpringMenuLauncher.this.cls));
		}
	}

	/**
	 * 展现菜单动画效果
	 * @param view
	 * @param runnable
	 */
	private void startSpringMenuAnimations(View view) {
		areMenusShowing = true;
		Animation shrinkOut1 = new ShrinkAnimationOut(300);
		Animation growOut = new EnlargeAnimationOut(300);
		shrinkOut1.setInterpolator(new AnticipateInterpolator(2.0F));
		shrinkOut1.setAnimationListener(new Animation.AnimationListener() {

			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				MainActivity.this.imageViewPlus.clearAnimation();
			}

			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
		});
		
		view.startAnimation(growOut);
	}
}