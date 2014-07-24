package com.spring.menu.animation;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;

public class EnlargeAnimationOut extends ZoomAnimation {
	public EnlargeAnimationOut(int i) {
		super(ZoomAnimation.Direction.HIDE, i, new View[0]);
	}

	@Override
	protected void addShrinkAnimation(View[] views) {
		// TODO Auto-generated method stub
		addAnimation(new ScaleAnimation(1F, 5F, 1F, 5F, 1, 0.5F, 1, 0.5F));
		addAnimation(new AlphaAnimation(1F, 0F));
	}

	@Override
	protected void addEnlargeAnimation(View[] views) {
		// TODO Auto-generated method stub
		
	}
}
