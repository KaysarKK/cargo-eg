package kz.tech.cargoeg.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Locale;

public class LanguageUtils {

    private LanguageUtils() {
    }

    public static String getMessage(String valueRu, String valueEn, String valueKz, String valueCh) {

        switch (getLocale().getLanguage()) {
            case "ru":
                return valueRu;
            case "en":
                return valueEn;
            case "kz":
                return valueKz;
            case "ch":
                return valueCh;
            default:
                return valueRu;
        }

    }

    public static Locale getLocale() {
        Locale locale = Locale.getDefault();
        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();
            if (request.getLocale() != null) {
                locale = request.getLocale();
            }
        }
        return locale;
    }
}
