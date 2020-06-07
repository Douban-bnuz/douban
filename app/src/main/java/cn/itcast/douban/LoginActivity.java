package cn.itcast.douban;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText editPhone;
    private EditText editPwd;
    private Button btnLogin;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editPwd = (EditText) findViewById(R.id.editPwd);
        btnLogin = (Button) findViewById(R.id.btnLogin);


    }

    /**
     * Jump to the registration interface
     * @param v
     */
    public void OnMyRegistClick(View v)  {
        Intent intent=new Intent(LoginActivity.this,RegistActivity.class);
        //intent.putExtra("info", "No66778899");
        LoginActivity.this.startActivity(intent);
    }

    /**
     * Jump to reset password interface
     * @param v
     */
    public void OnMyResPwdClick(View v){

    }

    public void btnLogin(View view) {
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

}

