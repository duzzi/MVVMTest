package com.duzzi.xtest.ui;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.duzzi.xtest.R;
import com.duzzi.xtest.bean.ArticleBean;

import org.jetbrains.annotations.NotNull;

/**
 * 文件名: HomeAdapter
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2020/6/4
 */
public class HomeAdapter extends BaseQuickAdapter<ArticleBean, BaseViewHolder> {
    public HomeAdapter() {
        super(R.layout.item_article);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, ArticleBean articleBean) {
        holder.setText(R.id.title, articleBean.getTitle());
    }
}
