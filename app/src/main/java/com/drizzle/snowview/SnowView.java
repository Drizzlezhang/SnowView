package com.drizzle.snowview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SnowView extends View {
	private static final int DELAY = 5;

	private SnowFlake[] snowflakes;

	private int HUGESNOW = 1;
	private int BIGSNOW = 2;
	private int MIDDLESNOW = 3;
	private int SMALLSNOW = 4;
	private int snowColor;
	private int snowLevel;

	public SnowView(Context context) {
		this(context, null);
	}

	public SnowView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public SnowView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SnowView, defStyleAttr, 0);
		snowLevel = array.getInt(R.styleable.SnowView_snow_level, BIGSNOW);
		snowColor = array.getColor(R.styleable.SnowView_snow_color, Color.WHITE);
		array.recycle();
	}

	protected void resize(int width, int height) {
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(snowColor);
		paint.setStyle(Paint.Style.FILL);
		snowflakes = new SnowFlake[getSnowNumber(snowLevel)];
		for (int i = 0; i < getSnowNumber(snowLevel); i++) {
			snowflakes[i] = SnowFlake.create(width, height, paint);
		}
	}

	@Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		if (w != oldw || h != oldh) {
			resize(w, h);
		}
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		setMeasuredDimension(widthSize, heightSize);
	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		for (SnowFlake snowFlake : snowflakes) {
			snowFlake.draw(canvas);
		}
		getHandler().postDelayed(runnable, DELAY);
	}

	public int getSnowLevel() {
		return snowLevel;
	}

	public void setSnowLevel(int snowLevel) {
		this.snowLevel = snowLevel;
		invalidate();
	}

	public int getSnowColor() {
		return snowColor;
	}

	public void setSnowColor(int snowColor) {
		this.snowColor = snowColor;
		invalidate();
	}

	private Runnable runnable = new Runnable() {
		@Override public void run() {
			invalidate();
		}
	};

	private int getSnowNumber(int snowlevel) {
		switch (snowlevel) {
			case 1:
				return 200;
			case 2:
				return 150;
			case 3:
				return 100;
			case 4:
				return 50;
		}
		return 150;
	}
}
