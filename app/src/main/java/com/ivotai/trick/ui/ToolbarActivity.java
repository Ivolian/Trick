package com.ivotai.trick.ui;

import android.widget.TextView;

import com.ivotai.trick.ButterKnifeActivity;
import com.ivotai.trick.R;

import butterknife.BindView;

public abstract class ToolbarActivity extends ButterKnifeActivity {

    @BindView(R.id.tvToolbarTitle)
    TextView tvToolbarTitle;

    protected abstract  String getToolbarTitle();

    @Override
    protected  void init() {
        String toolbarTitle = getToolbarTitle();
        if (toolbarTitle != null) {
            tvToolbarTitle.setText(toolbarTitle);
        }
    }

}
