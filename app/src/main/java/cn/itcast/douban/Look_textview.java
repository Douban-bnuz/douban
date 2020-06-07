package cn.itcast.douban;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

public class Look_textview extends TextView {
	private static final int NAMELENGTH=15; //假设昵称不超过15个字符
	private Map<String,String> faceMap;
	private CharSequence text;

	private ImageGetter imageGetter = new ImageGetter() {
        @Override
        public Drawable getDrawable(String source) {
              Drawable drawable = null;
              String sourceName=getContext().getPackageName()+":drawable/"+source;
              int id=getResources().getIdentifier(sourceName,null,null);
              if (id!=0){
	              drawable=getResources().getDrawable(id);
	              if (drawable!=null){
	            	  drawable.setBounds(0, 0,
	            			  drawable.getIntrinsicWidth(),
	            			  drawable.getIntrinsicHeight());
	              }
              }
              return drawable;
        }
	};

	public Look_textview(Context context) {
		super(context);
		setAutoLinkMask(Linkify.ALL);
	}

	public Look_textview(Context context, AttributeSet attrs) {
		super(context, attrs);
		setAutoLinkMask(Linkify.ALL);
	}

	public Look_textview(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setAutoLinkMask(Linkify.ALL);
	}
	
	public void setText(CharSequence text,Map<String,String> faceMap){
		this.faceMap=faceMap;
		setText(text);
	}

	@Override
	public CharSequence getText() {
		return text==null?"":text;
	}

	@Override
	public void setText(CharSequence text, BufferType type) {
		this.text=text;
		
		String cs=text.toString();
		String font1="<font color=#339966>";
		String font2="</font>";
		
		//找以'@'开头以':'或' '结尾的子串，将其使用font标记进行修饰
		int start=0;
		while(true){
			start=cs.indexOf('@',start);
			if (start<cs.length() && start>=0){
				int end=cs.indexOf(' ',start);
				if (end<cs.length() && end>0 && end-start<=NAMELENGTH){
					CharSequence subcs=new String(cs.subSequence(start, end).toString());
					cs=cs.replace(subcs,font1+subcs+font2 );
					start+=font1.length()+subcs.length()+font2.length();
				}
				else{
					end=cs.indexOf(':',start);
					if (end<cs.length() && end>0 && end-start<=NAMELENGTH){
						CharSequence subcs=new String(cs.subSequence(start, end).toString());
						cs=cs.replace(subcs,font1+subcs+font2 );
						start+=font1.length()+subcs.length()+font2.length();
					}
				}
				start+=1;
			}
			else{
				break;
			}
		}
		
		if (faceMap!=null){
			//对表情符以img标记进行修饰，改用drawable显示出来
			Set<String> keys=faceMap.keySet();
			for(String key:keys){
				if (cs.contains(key)){
					cs=cs.replace(key, "<img src='"+faceMap.get(key)+"'>");
				}
			}
		}
	
		super.setText(Html.fromHtml(cs,imageGetter,null), type);
	}
}
