package com.gmail.cesarcanojmz.selfiecapture.module.camera;

import com.gmail.cesarcanojmz.selfiecapture.helper.BasePresenter;
import com.gmail.cesarcanojmz.selfiecapture.helper.BaseView;

public interface Contract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View>{

    }
}
