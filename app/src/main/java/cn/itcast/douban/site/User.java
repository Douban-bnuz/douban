package cn.itcast.douban.site;

public class User{
	private String profileImageUrl="http://tp3.sinaimg.cn/1500460450/50/1289923764/0";
	private String screenName="测试";
	private boolean verified=false;

	public User(){
		
	}

	public String getProfileImageUrl(){
		return profileImageUrl;
	}

	public String getScreenName(){
		return screenName;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isVerified(){
		return verified;
	}
}