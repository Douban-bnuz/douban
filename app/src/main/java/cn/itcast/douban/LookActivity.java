package cn.itcast.douban;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import cn.itcast.douban.site.Blog;
import cn.itcast.douban.site.SinaSite;
import cn.itcast.douban.site.Site;
import cn.itcast.douban.site.User;

public class LookActivity extends Activity implements OnItemClickListener {
    private TextView usernameTextview;
    private Site site;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.look);

        initSite();

        usernameTextview=(TextView)findViewById(R.id.TextViewUsername);
        Look_listview sinaListView=(Look_listview) findViewById(R.id.sinaList);
        sinaListView.setOnItemClickListener(this);
        sinaListView.init(site);

        findViewById(R.id.BtnWrite).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:
            }
        });

        findViewById(R.id.BtnRefresh).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:
            }
        });

        updateUserNameTextView();
    }

    private void updateUserNameTextView() {
        usernameTextview.setText(R.string.unAuthUser);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        //TODO:
    }

    private void initSite(){
        site=new SinaSite();

        Blog blog=new Blog(site);
        blog.setPic("http://ww3.sinaimg.cn/thumbnail/6b8527b3jw6dbydoikpzuj.jpg");
        User user=new User();
        user.setVerified(true);
        blog.setUser(user);
        site.addBlog(blog);

        blog=new Blog(site);
        user=new User();
        user.setVerified(true);
        blog.setUser(user);
        Blog retBlog=new Blog();
        user=new User();
        user.setProfileImageUrl("");
        user.setScreenName("reply");
        retBlog.setUser(user);
        retBlog.setText("[爱你]求喜欢");
        //retBlog.setPic("http://tp4.sinaimg.cn/1658122963/50/1282754213");
        retBlog.setPic("http://hi.csdn.net/attachment/201105/16/0_1305537432v7zz.gif");
        blog.setRetweetedBlog(retBlog);
        site.addBlog(blog);

        for(int i=0;i<5;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            user=new User();
            blog=new Blog(site);
            blog.setUser(user);
            site.addBlog(blog);
        }
    }




}
