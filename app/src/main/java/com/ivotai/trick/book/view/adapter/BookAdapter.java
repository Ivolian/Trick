package com.ivotai.trick.book.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivotai.trick.R;
import com.ivotai.trick.book.view.viewholder.HeaderBookViewHolder;
import com.ivotai.trick.book.view.viewholder.ItemBookViewHolder;
import com.ivotai.trick.model.Book;
import com.karumi.headerrecyclerview.HeaderRecyclerViewAdapter;

public class BookAdapter extends HeaderRecyclerViewAdapter<RecyclerView.ViewHolder, Object, Book, Object> {

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = getLayoutInflater(parent);
        View headerView = inflater.inflate(R.layout.head_book, parent, false);
        return new HeaderBookViewHolder(headerView);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = getLayoutInflater(parent);
        View characterView = inflater.inflate(R.layout.item_book, parent, false);
        return new ItemBookViewHolder(characterView);
    }

//    @Override
//    protected RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater = getLayoutInflater(parent);
//        View footerView = inflater.inflate(R.layout.row_dragon_ball_footer, parent, false);
//        return new FooterViewHolder(footerView);
//    }

    @Override
    protected void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
//        DragonBallHeader header = getHeader();
//        HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
//        headerViewHolder.render(header);
    }

    @Override
    protected void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        Book book = getItem(position);
        ItemBookViewHolder itemBookViewHolder = (ItemBookViewHolder) holder;
        itemBookViewHolder.render(book);
//        CharacterViewHolder characterViewHolder = (CharacterViewHolder) holder;
//        characterViewHolder.render(character);
    }

//    @Override
//    protected void onBindFooterViewHolder(RecyclerView.ViewHolder holder, int position) {
//        DragonBallFooter footer = getFooter();
//        FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
//        footerViewHolder.render(footer);
//    }

    private LayoutInflater getLayoutInflater(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext());
    }

}
