package com.drizzle.snowview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by drizzle on 16/1/8.
 */
public class SnowView extends View {

	public SnowView(Context context) {
		this(context, null);
	}

	public SnowView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public SnowView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}


}
