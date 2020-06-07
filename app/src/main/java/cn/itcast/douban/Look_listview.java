package cn.itcast.douban;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import cn.itcast.douban.site.Site;

public class Look_listview extends ListView {
	private Site site;

	public Look_listview(Context context) {
		super(context);
	}

	public Look_listview(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public Look_listview(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		LayoutInflater li=LayoutInflater.from(getContext());
		View headerView=li.inflate(R.layout.look_listheader, null);
		headerView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				refresh();
			}			
		});
		View footerView=li.inflate(R.layout.look_listfooter, null);
		footerView.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				more();
			}			
		});
		addHeaderView(headerView);
		addFooterView(footerView);
	}

	public void init(Site site){
		this.site=site;
		if (site!=null && site.getBlogsCount()>0){
			setAdapter(new Look_adapter(site.getBlogs(),getContext()));
		}
	}
	
	public void refresh() {
		//TODO:
	}

	public void more(){
		//TODO:
	}

	public Site getSite(){
		return site;
	}
}
