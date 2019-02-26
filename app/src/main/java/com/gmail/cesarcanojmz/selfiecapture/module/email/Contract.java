package com.gmail.cesarcanojmz.selfiecapture.module.email;

import com.gmail.cesarcanojmz.selfiecapture.helper.BasePresenter;
import com.gmail.cesarcanojmz.selfiecapture.helper.BaseView;

public interface Contract {
    interface View extends BaseView {
        void validationSuccess();
        void validationError();
    }

    interface Presenter extends BasePresenter<View> {
        void validarEmail(String email);
    }
}
