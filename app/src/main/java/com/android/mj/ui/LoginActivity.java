package com.android.mj.ui;

import android.view.View;

import com.android.mj.R;
import com.android.mj.databinding.ActivityLoginBinding;

public class LoginActivity extends UIActivity<ActivityLoginBinding> implements View.OnClickListener{
    public static final String KEY_PWD = "pwd";

    private static final int CODE_SKIP_REG = 10;

    private boolean isShow = false;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {

    }





    @Override
    public void onClick(View view) {
//        Intent intent = new Intent();
//        switch (view.getId()) {
//            case R.id.iv_al_show:
//                if (isShow) {
//                    databinding.etAlPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                    isShow = false;
//                    databinding.ivAlShow.setImageResource(R.drawable.icon_login_normal);
//                } else {
//                    databinding.etAlPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                    isShow = true;
//                    databinding.ivAlShow.setImageResource(R.drawable.icon_login_click);
//                }
//                break;
//            case R.id.tv_al_forget:
//                intent.setClass(this, ForgetPwdActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.tv_al_register:
//                intent.setClass(this, RegisterActivity.class);
//                startActivityForResult(intent,CODE_SKIP_REG);
//                break;
//            case R.id.btn_summit:
//                postLogin();
//                break;
//            case R.id.iv_al_account:
//                etPhone.setText("");
//                break;
//        }
    }

}
