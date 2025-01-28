//package kz.tech.cargoeg.controller.assembler;
//
//
//import kz.tech.cargoeg.controller.CustomerController;
//import kz.tech.cargoeg.controller.assembler.base.BaseModelAssembler;
//import kz.tech.cargoeg.model.CustomerEventEnum;
//import kz.tech.cargoeg.model.dto.CustomerDTO;
//import kz.tech.cargoeg.model.entity.CustomerEntity;
//import kz.tech.cargoeg.util.ModelMapperUtil;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//
//@Component
//public class CustomerModelAssembler extends BaseModelAssembler<CustomerEntity, CustomerDTO> {
//
//    public CustomerModelAssembler() {
//        super(CustomerController.class, CustomerDTO.class);
//    }
//
//    @Override
//    public CustomerDTO toModel(CustomerEntity entity) {
//        CustomerDTO inspectionDTO = ModelMapperUtil.map(entity, CustomerDTO.class);
//        return inspectionDTO;
//    }
//}
