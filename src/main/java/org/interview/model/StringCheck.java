package org.interview.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCheck {
    private boolean allowed = false;

    public StringCheck(String string) {
        Pattern pattern = Pattern.compile("(print|add|subtract|exit)");
        Matcher matcher = pattern.matcher(string);
        if(!matcher.find()) {
            this.allowed = true;
        }
    }

    public boolean isAllowed() {
        return this.allowed;
    }
}
