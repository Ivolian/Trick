/*
 * Copyright (C) 2015 Karumi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    public ItemBookViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        AppComponentHolder.getAppComponent().inject(this);
    }

    public void render(Book book) {
        renderCover(book);
        tvTitle.setText(book.getTitle());
        tvIntro.setText(book.getIntro());

    }

    private void renderCover(Book book) {
        int bid = book.getBid();
        String coverUrl = BookCoverHelper.coverUrl(bid);
        Glide.with(mContext).load(coverUrl).into(ivCover);
    }


}
