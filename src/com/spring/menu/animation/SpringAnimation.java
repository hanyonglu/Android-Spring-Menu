package com.spring.menu.animation;

import com.spring.menu.control.ImageButtonExtend;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * 分布菜单加载和伸缩动画
 * @Description: 分布菜单加载和伸缩动画

 * @File: SpringAnimation.java

 * @Package com.spring.menu.animation

 * @Author Hanyonglu

 * @Date 2012-10-25 下午12:18:39

 * @Version V1.0
 */
public class SpringAnimation extends ZoomAnimation {
	private static int[] size;
	private static int xOffset = 210;
	private static int yOffset = -15;
	public static final int	DURATION = 300;
	
	/**
	 * 构造器
	 * @param direction
	 * @param duration
	 * @param view
	 */
	public SpringAnimation(Direction direction, long duration, View view) {
		super(direction, duration, new View[] { view });
		SpringAnimation.xOffset = SpringAnimation.size[0] / 2 - 30;
	}

	/**
	 * 开始显示动画效果
	 * @param viewgroup
	 * @param direction
	 * @param size
	 */
	public static void startAnimations(ViewGroup viewgroup,
			ZoomAnimation.Direction direction, int[] size) {
		SpringAnimation.size = size;
		
		switch (direction) {
		case HIDE:
			startShrinkAnimations(viewgroup);
			break;
		case SHOW:
			startEnlargeAnimations(viewgroup);
			break;
		}
	}

	/**
	 * 开始呈现菜单
	 * @param viewgroup
	 */
	private static void startEnlargeAnimations(ViewGroup viewgroup) {
		for (int i = 0; i < viewgroup.getChildCount(); i++) {
			if (viewgroup.getChildAt(i) instanceof ImageButtonExtend) {
				ImageButtonExtend inoutimagebutton = (ImageButtonExtend) viewgroup
						.getChildAt(i);
				SpringAnimation animation = new SpringAnimation(
						ZoomAnimation.Direction.HIDE, DURATION, inoutimagebutton);
				animation.setStartOffset((i * 200)
						/ (-1 + viewgroup.getChildCount()));
				animation.setInterpolator(new OvershootInterpolator(4F));
				inoutimagebutton.startAnimation(animation);
			}
		}
	}

	/**
	 * 开始隐藏菜单
	 * @param viewgroup
	 */
	private static void startShrinkAnimations(ViewGroup viewgroup) {
		for (int i = 0; i < viewgroup.getChildCount(); i++) {
			if (viewgroup.getChildAt(i) instanceof ImageButtonExtend) {
				ImageButtonExtend inoutimagebutton = (ImageButtonExtend) viewgroup
						.getChildAt(i);
				SpringAnimation animation = new SpringAnimation(
						ZoomAnimation.Direction.SHOW, DURATION,
						inoutimagebutton);
				animation.setStartOffset((100 * ((-1 + viewgroup
						.getChildCount()) - i))
						/ (-1 + viewgroup.getChildCount()));
				animation.setInterpolator(new AnticipateOvershootInterpolator(2F));
				inoutimagebutton.startAnimation(animation);
			}
		}
	}

	@Override
	protected void addShrinkAnimation(View[] views) {
		// TODO Auto-generated method stub
		MarginLayoutParams mlp = (MarginLayoutParams) views[0].
				getLayoutParams();
		addAnimation(new TranslateAnimation(
				xOffset + -mlp.leftMargin, 
				0F,yOffset + mlp.bottomMargin, 0F));
	}

	@Override
	protected void addEnlargeAnimation(View[] views) {
		// TODO Auto-generated method stub
		MarginLayoutParams mlp = (MarginLayoutParams) views[0].
				getLayoutParams();
		addAnimation(new TranslateAnimation(
				0F, xOffset + -mlp.leftMargin, 
				0F,yOffset + mlp.bottomMargin));
	}
}
