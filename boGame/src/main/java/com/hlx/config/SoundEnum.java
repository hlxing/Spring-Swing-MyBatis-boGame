package com.hlx.config;

/**
 * A code table that corresponds to the sound effect of bo game
 * @author hlx
 * @version 1.0 2018-3-28
 */
public enum SoundEnum {

    PAGE("page"),
    DECISION("decision"),
    HOVER("hover"),
    CHANGE("change"),
    BEGIN("begin"),
    END("end");

    private String value;

    SoundEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
