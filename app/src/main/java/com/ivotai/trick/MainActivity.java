package com.ivotai.trick;

import android.content.Intent;

import com.ivotai.trick.base.ToolbarActivity;
import com.ivotai.trick.ui.NovelActivity;

import butterknife.OnClick;

/**
 * The type Main activity.
 */
public class MainActivity extends ToolbarActivity {

    @Override
    protected final int layoutResID() {
        return R.layout.act_main;
    }

    @Override
    protected String toolbarTitle() {
        return "主界面";
    }

    /**
     * Read novel.
     */
    @OnClick(R2.id.tvReadNovel)
    public final void readNovel() {
//  TODO Rx 压力
        Intent intent = new Intent(this, NovelActivity.class);
        startActivity(intent);
    }

}
