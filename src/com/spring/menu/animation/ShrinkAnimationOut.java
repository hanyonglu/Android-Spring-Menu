package com.spring.menu.animation;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;

public class ShrinkAnimationOut extends ZoomAnimation {
	public ShrinkAnimationOut(int i) {
		super(ZoomAnimation.Direction.SHOW, i, new View[0]);
	}

	@Override
	protected void addShrinkAnimation(View[] views) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addEnlargeAnimation(View[] views) {
		// TODO Auto-generated method stub
		addAnimation(new ScaleAnimation(1F, 0F, 1F, 0F, 1, 0.5F, 1, 0.5F));
		addAnimation(new AlphaAnimation(1F, 0F));
	}
}
