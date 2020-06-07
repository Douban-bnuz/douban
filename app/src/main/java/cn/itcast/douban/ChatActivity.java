package cn.itcast.douban;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private List<Chat> chatList=new ArrayList<>();//存放Chat对象
    private View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        //聊天对话框列表的适配
        Chat_adapter adapter=new Chat_adapter(view.getContext(),R.layout.chat_listview,chatList);//实例化适配器
        final ListView listView=(ListView)view.findViewById(R.id.chat_listview);//获取ListView
        listView.setAdapter(adapter);//适配

        //为ListView添加上下文菜单
        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {

            @Override
            public void onCreateContextMenu(android.view.ContextMenu menu, View v,
                                            ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(0, 0, 0, "标为未读");
                menu.add(0, 1, 0, "置顶聊天");
                menu.add(0,2,0,"删除聊天");

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent(view.getContext(), Chat_view.class);//启动聊天
                    startActivity(intent);
                }
                if(position>=1) {
                    LinearLayout layout = (LinearLayout) listView.getChildAt(position);
                    TextView textView = (TextView) layout.findViewById(R.id.chat_name);//获取ListView中显示姓名的TextView
                    String s = textView.getText().toString();//获取TextView的值
                    Intent intent = new Intent(view.getContext(), Chat_view.class);//启动聊天界面
                    intent.putExtra("username", s);//将TextView的值传递给聊天界面
                    startActivity(intent);
                }
            }
        });
        init();
    }
    //初始化参数
    private void init(){
        Chat wzy=new Chat(R.drawable.wzy,"王震尧 Lue","世间所有的相遇都是久别重逢","1.03");
        chatList.add(wzy);
        Chat zsw=new Chat(R.drawable.zsw,"赵世文","6月22号交Android课设","1.27");
        chatList.add(zsw);
        Chat wyy=new Chat(R.drawable.wyy,"汪严逸","凌晨四点见","4.00");
        chatList.add(wyy);
        Chat wqj=new Chat(R.drawable.wqj ,"吴乔杰","我喜欢唱，跳，rap，篮球","7.30");
        chatList.add(wqj);
        Chat dx=new Chat(R.drawable.dx, "丁鑫","排队给我道歉","8.30");
        chatList.add(dx);
        Chat xbt =new Chat(R.drawable.xbt ,"许柏涛","该充钱了","8.52");
        chatList.add(xbt);
        Chat glm=new Chat(R.drawable.glm ,"关力铭","该充钱了","8.52");
        chatList.add(glm);



    }



    public class Chat_adapter extends ArrayAdapter<Chat> {

        private Chat_adapter(Context context, int textViewResourceID, List<Chat> objects){
            super(context,textViewResourceID,objects);

        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent) {
            View view=View.inflate(ChatActivity.this,R.layout.chat_listview,null);
            Chat chat=getItem(position);
            ImageView imageView=(ImageView)view.findViewById(R.id.chat_img);//头像ImageView
            TextView textView1=(TextView)view.findViewById(R.id.chat_name);//名字TextView
            TextView textView2=(TextView)view.findViewById(R.id.chat_text);//聊天TextView
            TextView textView3=(TextView)view.findViewById(R.id.chat_time);//时间TextView
            imageView.setImageResource(chat.getChatImg());//获取头像
            textView1.setText(chat.getChatName());//获取名字
            textView2.setText(chat.getChatText());//获取聊天记录
            textView3.setText(chat.getChatTime());//获取时间
            return view;
        }
    }
}
