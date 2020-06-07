package cn.itcast.douban;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Set;

import cn.itcast.douban.site.Blog;

public class Look_adapter implements ListAdapter {
	private Set<Blog> blogs;
	private Context context;

	public Look_adapter(Set<Blog> blogs, Context context){
		this.blogs=blogs;
		this.context=context;
	}

	@Override
	public boolean areAllItemsEnabled() {
		return true;
	}

	@Override
	public boolean isEnabled(int arg0) {
		return true;
	}

	@Override
	public int getCount() {
		return blogs.size();
	}

	@Override
	public Blog getItem(int position) {
		if (position<0 || position>=getCount())
			return null;
	
		if (blogs!=null){
			Iterator<Blog> iterator=blogs.iterator();
			int i=0;
			while(iterator.hasNext()){
				if (i==position){
					return iterator.next();
				}
				else{
					iterator.next();
					i++;
				}
			}
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public int getItemViewType(int position) {
		return Adapter.IGNORE_ITEM_VIEW_TYPE;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=null;
		if (convertView==null){
			LayoutInflater li=LayoutInflater.from(context);
			view=li.inflate(R.layout.look_view, null);
		}
		else{
			view=convertView;
		}

		Blog blog=getItem(position);
		if (blog!=null){
			updateBlogView(view, blog);
			
			if (blog.isHaveRetweetedBlog()&& blog.getInReplyBlogText().length()>0){
				updateRetweeteBlogView(view, blog);
			}
			else{
				view.findViewById(R.id.reBlog).setVisibility(View.GONE);
				view.findViewById(R.id.reImage).setVisibility(View.GONE);
			}
		}
		view.setTag(blog);
		return view;
	}

	/**
	 * @param view
	 * @param blog
	 */
	private void updateBlogView(View view, Blog blog) {
		TextView userName=(TextView)view.findViewById(R.id.userName);
		Look_textview blogText=(Look_textview) view.findViewById(R.id.blogText);
		WebView profileImage=(WebView)view.findViewById(R.id.profileImage);
		ImageView vImage=(ImageView)view.findViewById(R.id.vImage);
		WebView smallImage=(WebView)view.findViewById(R.id.smallImage);
		TextView sourceText=(TextView)view.findViewById(R.id.sourceText);

		userName.setText(blog.getUser().getScreenName());
		sourceText.setText("来自"+blog.getSource());
			
		blogText.setText(blog.getText(),blog.getSite().getFaceMap());
		profileImage.loadUrl(blog.getUser().getProfileImageUrl());
		
		if (!blog.getUser().isVerified())
			vImage.setVisibility(View.INVISIBLE);
		if (blog.getSmallPic().length()>0){
			smallImage.loadUrl(blog.getSmallPic());
		}
		else{
			smallImage.setVisibility(View.GONE);
		}
	}

	/**
	 * @param view
	 * @param blog
	 */
	private void updateRetweeteBlogView(View view, Blog blog) {
		Look_textview reBlogText=(Look_textview) view.findViewById(R.id.reBlogText);
		WebView reImage=(WebView)view.findViewById(R.id.reImage);
		
		if (blog.getInReplyBlogText().length()>0){
			if (blog.getInReplyUserScreenName().length()>0){
				reBlogText.setText("@"+blog.getInReplyUserScreenName()+": "+blog.getInReplyBlogText(),
					blog.getSite().getFaceMap());
			}
			else{
				reBlogText.setText(blog.getInReplyBlogText(),
					blog.getSite().getFaceMap());
			}
		}
		else{
			reBlogText.setVisibility(View.GONE);
		}
		
		if (blog.getRetweetedBlog().getSmallPic().length()>0){
			reImage.loadUrl(blog.getRetweetedBlog().getSmallPic());
		}
		else{
			reImage.setVisibility(View.GONE);
		}
	}

	@Override
	public int getViewTypeCount() {
		return 1;  //Only One type of view
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {

	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {

	}

}
