package com.gmail.cesarcanojmz.selfiecapture.helper;

import android.content.Context;

public interface BaseView {
    Context getContext();
    void loading();
    void loaded();
    void message(String msg);
}
