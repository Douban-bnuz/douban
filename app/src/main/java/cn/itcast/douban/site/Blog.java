package cn.itcast.douban.site;

import java.util.Date;

public class Blog implements Comparable<Blog>{

	private Date createAt=new Date(System.currentTimeMillis());
	private Blog retweetedBlog;
	private String text="就算把我打的遍体鳞伤也见不得会[泪]？https://book.douban.com/";
	private String smallPic="";
	private String source="IE9";
	private User user;
	private Site site;

	public Blog(){

	}
	
	public Blog(Site site){
		this.site=site;
	}

	public boolean isHaveRetweetedBlog(){
		return retweetedBlog!=null;
	}
	
	public Blog getRetweetedBlog(){
		return retweetedBlog;
	}


	public String getText(){
		return text;
	}

	public User getUser(){
		return user;
	}
	
	public String getSmallPic(){
		return smallPic;
	}

	public void setRetweetedBlog(Blog retweetedBlog) {
		this.retweetedBlog = retweetedBlog;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getInReplyUserScreenName(){
		if (retweetedBlog!=null && retweetedBlog.getUser()!=null)
			return retweetedBlog.getUser().getScreenName();
		else
			return "";		
	}
	
	public String getInReplyBlogText(){
		if (retweetedBlog!=null)
			return retweetedBlog.getText();
		else
			return "";	
	}
	
	public void setPic(String smallPic){
		this.smallPic=smallPic;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int compareTo(Blog another) {
		int ret=0;

		if (this.createAt.before(another.createAt)){
			ret=-1;
		}
		else if (this.createAt.after(another.createAt)){
			ret=1;
		}
		else{
			ret=0;	
		}

		return ret;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Site getSite() {
		return site;
	}

}