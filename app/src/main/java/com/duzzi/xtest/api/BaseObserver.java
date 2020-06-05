package com.duzzi.xtest.api;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 文件名: BaseObserver
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2020/6/4
 */

public abstract class BaseObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}
