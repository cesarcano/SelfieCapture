package com.gmail.cesarcanojmz.selfiecapture.module.email;

import com.gmail.cesarcanojmz.selfiecapture.helper.Controls;

public class Presenter implements Contract.Presenter {

    private Contract.View view;

    public Presenter() {
    }

    @Override
    public void validarEmail(String email) {
        Controls controls = new Controls();
        view.loading();
        switch (controls.emailValidator(email)) {
            case 0:
                view.validationError();;
                view.message("Email incorrecto");
                view.loaded();
                break;
            case 1:
                view.validationError();
                view.message("Ingrese email");
                view.loaded();
                break;
            case 2:
                view.message("Email es valido");
                view.validationSuccess();
                view.loaded();
                break;
        }
    }

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
