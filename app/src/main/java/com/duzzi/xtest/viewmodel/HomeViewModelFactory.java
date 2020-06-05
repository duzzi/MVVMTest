package com.duzzi.xtest.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * 文件名: HomeViewholderFactory
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2020/6/4
 */
public class HomeViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeViewModel();
    }
}
