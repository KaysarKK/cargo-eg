package kz.tech.cargoeg.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TransportTypeDTO {
    private UUID id;
    private String valueRu;
    private String valueCh;
}
