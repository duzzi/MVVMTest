package com.duzzi.xtest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 文件名: TestViewModel
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2020/6/4
 */
public final class TestViewModel extends ViewModel {

    private MutableLiveData<Integer> count = new MutableLiveData<>();

    public TestViewModel(int count) {
        this.count.setValue(count);
    }

    public MutableLiveData<Integer> getCount() {
        return count;
    }

    public void setCount(MutableLiveData<Integer> count) {
        this.count = count;
    }
}
