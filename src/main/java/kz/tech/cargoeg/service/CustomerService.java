package kz.tech.cargoeg.service;

import kz.tech.cargoeg.model.entity.CustomerEntity;

public interface CustomerService {
    CustomerEntity saveOne(CustomerEntity map) throws IllegalAccessException;
}
