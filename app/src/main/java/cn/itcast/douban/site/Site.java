package cn.itcast.douban.site;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public abstract class Site{

	protected Set<Blog> blogs=new TreeSet<Blog>();
	protected String name;
	protected Map<String,String> faceMap=new HashMap<String,String>();

	public Site() {
		onConstruct();
	}

	protected abstract void onConstruct();
	
	public Map<String, String> getFaceMap() {
		return faceMap;
	}
	
	public Set<Blog> getBlogs(){
		return blogs;
	}
	
	public long getBlogsCount(){
		return blogs.size();
	}
	
	public void addBlog(Blog blog){
		blogs.add(blog);
	}
	
	public void removeBlog(Blog blog){
		blogs.remove(blog);
	}
	
	public Iterator<Blog> getBlogsIterator(){
		return blogs.iterator();
	}
	
	public void clearBlogs(){
		blogs.clear();
	}

	public String getName(){
		return name;
	}
}