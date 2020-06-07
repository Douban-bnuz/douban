package cn.itcast.douban;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainFragment extends Fragment {
    //定义图片
    private int[] resId = new int[]{
            R.drawable.book1, R.drawable.book2, R.drawable.book3
    };
    //图片下标序号
    private int count = 0;
    //定义手势监听对象
    private GestureDetector gestureDetector;
    //定义ImageView对象
    private ImageView iv;
    //定义两个按钮
    Button Btn1;
    Button Btn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.home, null);

        iv = (ImageView) view.findViewById(R.id.iv1);             //获取ImageView控件id
        iv = (ImageView) view.findViewById(R.id.iv2);
        iv = (ImageView) view.findViewById(R.id.iv3);
        gestureDetector = new GestureDetector(onGestureListener);   //设置手势监听由onGestureListener处理
        return view;
    }


    //当Activity被触摸时回调
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    //自定义GestureDetector的手势识别监听器
    private GestureDetector.OnGestureListener onGestureListener
            = new GestureDetector.SimpleOnGestureListener() {
        //当识别的手势是滑动手势时回调onFinger方法
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //得到手触碰位置的起始点和结束点坐标 x , y ，并进行计算
            float x = e2.getX() - e1.getX();
            float y = e2.getY() - e1.getY();
            //通过计算判断是向左还是向右滑动
            if (x > 0) {
                count++;
                count %= (resId.length - 1);        //想显示多少图片，就把定义图片的数组长度-1
            } else if (x < 0) {
                count--;
                count = (count + (resId.length - 1)) % (resId.length - 1);
            }

            iv.setImageResource(resId[count]);  //切换imageView的图片
            return true;
        }
    };

}
