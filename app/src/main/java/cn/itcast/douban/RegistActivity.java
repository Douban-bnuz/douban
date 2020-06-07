package cn.itcast.douban;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity {
    private EditText editPhone;
    private EditText editPwd;
    private Button btnRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editPwd = (EditText) findViewById(R.id.editPwd);
        btnRegist = (Button) findViewById(R.id.btnRegist);
    }

    public void OnMyRegistClick(View v)
    {
        ContentValues values= new ContentValues();
        values.put("userID",editPhone.getText().toString());
        values.put("pwd",editPwd.getText().toString());


        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
