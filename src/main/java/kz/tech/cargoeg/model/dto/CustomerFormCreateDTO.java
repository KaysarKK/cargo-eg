package kz.tech.cargoeg.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerFormCreateDTO {
    private String from;
    private String to;
    private String cargoSize;
    private Integer height;
    private Integer weight;
    private Integer deep;
    private Integer price;
    private Integer mass;
    private TransportTypeCreateDTO transportType;
    private String comment;
    private List<String> fileUrls;
}
