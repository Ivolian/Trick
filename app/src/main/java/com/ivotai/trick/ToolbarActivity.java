package com.ivotai.trick;

import android.widget.TextView;

import butterknife.BindView;

public abstract class ToolbarActivity extends ButterKnifeActivity {

    @BindView(R.id.tvToolbarTitle)
    TextView tvToolbarTitle;

    protected abstract  String toolbarTitle();

    @Override
    protected  void init() {
        String toolbarTitle = toolbarTitle();
        if (toolbarTitle != null) {
            tvToolbarTitle.setText(toolbarTitle);
        }
    }

}
