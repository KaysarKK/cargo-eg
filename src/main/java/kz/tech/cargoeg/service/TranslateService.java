package kz.tech.cargoeg.service;

import kz.tech.cargoeg.model.entity.CustomerEntity;

import java.util.Locale;

public interface TranslateService {

    String translate(String originalValue, String targetLocale);
}
