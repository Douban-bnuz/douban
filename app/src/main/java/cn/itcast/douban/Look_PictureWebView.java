package cn.itcast.douban;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;

public class Look_PictureWebView extends WebView implements PictureListener {
	private Picture picture;

	public Look_PictureWebView(Context context) {
		super(context);
		setPictureListener(this);
	}

	public Look_PictureWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setPictureListener(this);
	}

	public Look_PictureWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setPictureListener(this);
	}

	@Override
	public void onNewPicture(WebView view, Picture picture) {
		if (picture!=null){
			this.picture=picture;
			ViewGroup.LayoutParams lp=this.getLayoutParams();
			lp.width=picture.getWidth();
			lp.height=picture.getHeight();
			view.setLayoutParams(lp);
		}	
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (picture!=null){
			canvas.drawPicture(picture);
		}
		else{
			Drawable background=this.getBackground();
			if (background!=null){
				background.setBounds(0,0,background.getIntrinsicWidth(),background.getIntrinsicHeight());
				background.draw(canvas);
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		return true;
	}

}
