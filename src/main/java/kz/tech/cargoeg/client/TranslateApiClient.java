package kz.tech.cargoeg.client;

import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${integration.translate.service-name}", url = "${integration.translate.url}",configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface TranslateApiClient {
    @PostMapping("/api/translate")
    String translateToRu(@RequestBody String text);
}
