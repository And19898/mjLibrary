package com.android.mj.ui;

import android.support.annotation.DrawableRes;
import android.view.KeyEvent;

import com.android.mj.R;
import com.android.mj.databinding.ActivityAplshBinding;
import com.gyf.barlibrary.BarHide;


public abstract class SplashBaseActivity extends UIActivity<ActivityAplshBinding>  {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_aplsh;
    }

    @Override
    protected void init() {
        immersionBar.hideBar(BarHide.FLAG_HIDE_BAR).fitsSystemWindows(false).init();
        handler.postDelayed(this, 2000);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
            immersionBar.hideBar(BarHide.FLAG_HIDE_BAR).init();
    }

    /**
     * 检查跳转
     */
    protected abstract void needCheck();

    /**
     * 获取启动页图片
     * @return
     */
    protected abstract
    @DrawableRes
    int getSplashRes();


}
