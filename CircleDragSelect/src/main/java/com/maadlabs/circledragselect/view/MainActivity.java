package com.maadlabs.circledragselect.view;

import android.app.Activity;
import android.os.Bundle;

import com.maadlabs.circledragselect.R;

public class MainActivity extends Activity {

	CirclesOptionView mCircleSelectView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
	}
	
	private void init() {
		
		mCircleSelectView = (CirclesOptionView) findViewById(R.id.circleSelectViewMain);
		
	}

}
