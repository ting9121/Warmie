package com.example.bluetooth.le;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ImageAdapter extends PagerAdapter 
	{
		Context context;
		private int[] GalImages = new int[] 
				{
		R.drawable.slideshow_1,
		R.drawable.slideshow_2,
		R.drawable.slideshow_3
	};
		
	ImageAdapter(Context context)
	{
		this.context=context;
	}
	
	@Override
	public int getCount() 
	{
		return GalImages.length;
	}
	 
	@Override
	public boolean isViewFromObject(View view, Object object) 
	{
		return view == ((ImageView) object);
	}
	 
	@Override
	public Object instantiateItem(ViewGroup container, int position) 
	{
		ImageView imageView = new ImageView(context);
		int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
		//imageView.setPadding(padding, padding, padding, padding);
		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		imageView.setImageResource(GalImages[position]);
		((ViewPager) container).addView(imageView, 0);
		return imageView;
	}
	 
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) 
	{
		((ViewPager) container).removeView((ImageView) object);
	}
}
