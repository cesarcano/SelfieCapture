package com.gmail.cesarcanojmz.selfiecapture.helper;

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
