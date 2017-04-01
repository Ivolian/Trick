package com.ivotai.trick;

import com.ivotai.trick.base.BaseActivity;

import butterknife.OnClick;

/**
 * The type Main activity.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected final int layoutResID() {
        return R.layout.act_main;
    }

    @Override
    protected boolean hideStatusBar() {
        return true;
    }

    /**
     * Read novel.
     */
    @OnClick(R2.id.tvReadNovel)
    public final void readNovel() {
//  TODO Rx 压力
//        Intent intent = new Intent(this, NovelActivity.class);
//        startActivity(intent);
    }

}
