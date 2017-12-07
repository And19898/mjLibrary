package module.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.mj.ui.LoginActivity;
import com.android.mj.ui.RegisterActivity;
import com.mj.protal.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View v){
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void reg(View v){
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
