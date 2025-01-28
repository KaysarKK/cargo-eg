//package kz.tech.cargoeg.service.impl;
//
//import kz.tech.cargoeg.model.entity.CustomerEntity;
//import kz.tech.cargoeg.repository.CustomerRepository;
//import kz.tech.cargoeg.service.CustomerService;
//import kz.tech.cargoeg.service.TranslateService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.lang.reflect.Field;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//
//    @Autowired
//    private TranslateService translateService;
//
//    @Override
//    public CustomerEntity saveOne(CustomerEntity customerEntity) throws IllegalAccessException {
//        for (Field field : customerEntity.getClass().getDeclaredFields()) {
//            field.setAccessible(true);
//            if (field.getType().equals(String.class)) {
//                String originalValue = (String) field.get(customerEntity);
//                if (originalValue != null) {
//                    String translatedValue = translateService.translate(originalValue, "ru");
//                    field.set(customerEntity, translatedValue);
//                }
//            }
//        }
//        return customerRepository.save(customerEntity);
//    }
//}
