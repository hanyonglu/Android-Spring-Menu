package com.spring.menu.control;

import com.spring.menu.animation.ZoomAnimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

/**
 * 实现动画的RelativeLayout
 * @Description: 实现动画的RelativeLayout

 * @File: ShrinkRelativeLayout.java

 * @Package com.spring.menu.control

 * @Author Hanyonglu

 * @Date 2012-10-24 下午10:17:54

 * @Version V1.0
 */
public class ShrinkRelativeLayout extends RelativeLayout {
	private Animation animation;

	public ShrinkRelativeLayout(Context context) {
		super(context);
	}
	
	public ShrinkRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public ShrinkRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	@Override
	public void startAnimation(Animation animation) {
		super.startAnimation(animation);
		this.animation = animation;
		getRootView().postInvalidate();
	}

	@Override
	protected void onAnimationEnd() {
		super.onAnimationEnd();
		
		if (this.animation instanceof ZoomAnimation) {
			setVisibility(((ZoomAnimation) animation).direction 
					!= ZoomAnimation.Direction.SHOW ? View.VISIBLE : View.GONE);
		}
	}

	@Override
	protected void onAnimationStart() {
		super.onAnimationStart();
		
		if (this.animation instanceof ZoomAnimation) {
			setVisibility(View.VISIBLE);
		}
	}
}