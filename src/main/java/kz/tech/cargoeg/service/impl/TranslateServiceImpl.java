package kz.tech.cargoeg.service.impl;

import kz.tech.cargoeg.client.TranslateApiClient;
import kz.tech.cargoeg.model.entity.CustomerEntity;
import kz.tech.cargoeg.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TranslateServiceImpl implements TranslateService {


    private TranslateApiClient translateApiClient;

    @Override
    public String translate(String originalValue, String targetLocale) {
        return translateApiClient.translateToRu(originalValue);
    }
}
