package com.spring.menu.animation;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;

public class EnlargeAnimationIn extends ZoomAnimation {
	public EnlargeAnimationIn(int i) {
		super(ZoomAnimation.Direction.HIDE, i, new View[0]);
	}

	@Override
	protected void addShrinkAnimation(View[] views) {
		// TODO Auto-generated method stub
		addAnimation(new ScaleAnimation(0F, 1F, 0F, 1F, 1, 0.5F, 1, 0.5F));
		addAnimation(new AlphaAnimation(0F, 1F));
	}

	@Override
	protected void addEnlargeAnimation(View[] views) {
		// TODO Auto-generated method stub
		
	}
}
