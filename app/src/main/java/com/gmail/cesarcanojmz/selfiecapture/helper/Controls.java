package com.gmail.cesarcanojmz.selfiecapture.helper;

import java.util.regex.Pattern;

public class Controls {

    public Controls() {
    }

    public int emailValidator(String email) {
        // Expresión regular
        String REGEX_EMAIL = "^([a-zA-Z0-9\\._-])+\\@(([a-zA-Z0-9-])+\\.)+([a-zA-Z0-9]{2,4})+$";
        Pattern exp_email = Pattern.compile(REGEX_EMAIL);
        if (email.isEmpty()) {
            return 1;
        }
        if (exp_email.matcher(email).matches()) {
            return 2;
        }
        return 0;
    }
}
