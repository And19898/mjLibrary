package com.android.mj.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;

import com.android.mj.R;
import com.android.mj.databinding.ActivityGuideBinding;
import com.android.mj.tools.GuideTools;
import com.gyf.barlibrary.BarHide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

import static cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Default;

/**
 * author: Rea.X
 * date: 2017/12/2.
 */

public abstract class GuideBaseActivity extends UIActivity<ActivityGuideBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void init() {
        immersionBar.hideBar(BarHide.FLAG_HIDE_BAR).fitsSystemWindows(false).init();
        List<Integer> guideRess = Arrays.asList(getGuideRes());
        if (guideRess != null && guideRess.size() > 0) {
            List<View> views = new ArrayList<>();
            for (int resId : guideRess) {
                views.add(BGABannerUtil.getItemImageView(context, resId));
            }
            databinding.bannerGuideBackground.setData(views);
        }
        databinding.bannerGuideBackground.setEnterSkipViewIdAndDelegate(R.id.guide_btn_enter, R.id.guide_btn_skip, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                GuideTools.guideDismiss();
                skipToMain();
                finish();
            }
        });
        databinding.bannerGuideBackground.setTransitionEffect(Default);
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

    protected abstract Integer[] getGuideRes();

    protected abstract void skipToMain();
}
