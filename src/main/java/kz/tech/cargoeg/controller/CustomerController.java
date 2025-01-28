//package kz.tech.cargoeg.controller;
//
//import kz.tech.cargoeg.controller.assembler.CustomerModelAssembler;
//import kz.tech.cargoeg.model.dto.CustomerDTO;
//import kz.tech.cargoeg.model.dto.CustomerFormCreateDTO;
//import kz.tech.cargoeg.model.entity.CustomerEntity;
//import kz.tech.cargoeg.service.CustomerService;
//import kz.tech.cargoeg.util.ModelMapperUtil;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(value = "/api/customers")
//public class CustomerController {
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private CustomerModelAssembler customerModelAssembler;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public CustomerDTO saveOnePlanned(@RequestBody CustomerFormCreateDTO customerFormCreateDTO) throws IllegalAccessException {
//        return customerModelAssembler.toModel(customerService.saveOne(ModelMapperUtil.map(customerFormCreateDTO, CustomerEntity.class)));
//    }
//}
