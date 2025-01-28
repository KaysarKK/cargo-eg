package kz.tech.cargoeg.model.entity;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
public class CustomerEntity {

    @Id
    private UUID id;
}
