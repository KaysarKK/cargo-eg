package kz.tech.cargoeg.model;

import kz.tech.cargoeg.util.LanguageUtils;
import kz.tech.cargoeg.util.MessageSourceHelper;

public enum CustomerEventEnum {
    COMPLETE("CustomerEventEnum.COMPLETE", "complete"),
    ACTIVATE("CustomerEventEnum.ACTIVATE", "activate"),
    CANCEL("CustomerEventEnum.CANCEL", "cancel");

    private String name;;
    private String code;
    private String resourceKey;


    CustomerEventEnum(String resourceKey, String code) {
        this.resourceKey = resourceKey;
        this.code = code;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public String getCode() {
        return code;
    }

    public String getMessage(Object... objects) {
        return MessageSourceHelper.getMessage(getResourceKey(), LanguageUtils.getLocale(), objects);
    }
}
