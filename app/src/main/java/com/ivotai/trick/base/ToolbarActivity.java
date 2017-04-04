package com.ivotai.trick.base;

import android.os.Bundle;
import android.widget.TextView;

import com.ivotai.trick.R;

import butterknife.BindView;

/**
 * The type Toolbar activity.
 */
public abstract class ToolbarActivity extends BaseActivity {

    @Override
    protected void initViews(Bundle savedInstanceState) {
        renderToolbar();
    }

    /**
     * The Tv toolbar title.
     */
    @BindView(R.id.tvToolbarTitle)
    TextView tvToolbarTitle;

    private void renderToolbar() {
        String toolbarTitle = toolbarTitle();
        if (toolbarTitle != null) {
            tvToolbarTitle.setText(toolbarTitle);
        }
    }

    /**
     * Toolbar title string.
     *
     * @return the string
     */
    protected abstract String toolbarTitle();

}
