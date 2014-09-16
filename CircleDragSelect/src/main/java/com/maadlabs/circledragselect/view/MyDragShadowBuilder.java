package com.maadlabs.circledragselect.view;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;
import android.view.View;


public class MyDragShadowBuilder extends View.DragShadowBuilder {

	View v;
	public MyDragShadowBuilder(CircleView mCircleSelect) {

		super(mCircleSelect);
		v = mCircleSelect;
	}

	@Override
	public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
		// TODO Auto-generated method stub
		super.onProvideShadowMetrics(shadowSize, shadowTouchPoint);
		Log.i("shadow", shadowSize + "/" + shadowTouchPoint);
	}

	@Override
	public void onDrawShadow(Canvas canvas) {
		// TODO Auto-generated method stub
		Log.i("spos", v.getX() + "/" + v.getY());
		//super.onDrawShadow(canvas);
	}

	
}
