package kz.tech.cargoeg.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TransportTypeCreateDTO {
    private UUID key;
    private String value;
}
