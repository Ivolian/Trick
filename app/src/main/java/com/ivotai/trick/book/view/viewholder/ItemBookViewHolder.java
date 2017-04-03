

package com.ivotai.trick.book.view.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ivotai.trick.R;
import com.ivotai.trick.app.AppComponentHolder;
import com.ivotai.trick.book.BookCoverHelper;
import com.ivotai.trick.model.Book;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ItemBookViewHolder extends RecyclerView.ViewHolder {

    @Inject
    Context mContext;

    @BindView(R.id.ivCover)
    ImageView ivCover;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvIntro)
    TextView tvIntro;

    @BindView(R.id.tvAuthor)
    TextView tvAuthor;

    @BindView(R.id.tvRecTitle)
    TextView tvRecTitle;


    public ItemBookViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        AppComponentHolder.getAppComponent().inject(this);
    }

    public void render(Book book) {
        renderCover(book);
        tvTitle.setText(book.getTitle());
        tvIntro.setText(book.getIntro());
        tvAuthor.setText(book.getAuthor());
        tvRecTitle.setText(book.getExt().getRecTitle());
    }

    private void renderCover(Book book) {
        int bid = book.getBid();
        String coverUrl = BookCoverHelper.coverUrl(bid);
        Glide.with(mContext).load(coverUrl).into(ivCover);
    }


}
