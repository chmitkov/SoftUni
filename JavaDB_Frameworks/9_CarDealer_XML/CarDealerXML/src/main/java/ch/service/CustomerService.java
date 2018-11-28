package ch.service;

import ch.domain.dtos.CustomerImportRootDto;

public interface CustomerService {

    void importCustomers(CustomerImportRootDto customerImportRootDto);
}
