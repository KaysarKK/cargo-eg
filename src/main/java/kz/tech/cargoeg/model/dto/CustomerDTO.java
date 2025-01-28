package kz.tech.cargoeg.model.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class CustomerDTO extends RepresentationModel<CustomerDTO> {
    private String from;
    private String to;
    private String cargoSize;
    private Integer height;
    private Integer weight;
    private Integer deep;
    private Integer price;
    private Integer mass;
    private TransportTypeDTO transportType;
    private String comment;
    private List<String> fileUrls;
    private String customerName;
    private String customerPhone;
}
