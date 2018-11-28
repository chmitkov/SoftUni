package ch.service;

import ch.domain.dtos.CustomerImportDto;
import ch.domain.dtos.CustomerImportRootDto;
import ch.domain.entities.Customer;
import ch.repository.CustomerRepository;
import ch.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importCustomers(CustomerImportRootDto customerImportRootDto) {
        for (CustomerImportDto customerImportDto : customerImportRootDto.getCustomerImportDtos()) {
            if (!this.validationUtil.isValid(customerImportDto)) {
                System.out.println("Something went wrong");

                continue;
            }

            Customer customerEntity = this.modelMapper.map(
                    customerImportDto, Customer.class);
            customerEntity.setBirthDate(LocalDate.parse(
                    customerImportDto.getBirthDate()
            ));

            this.customerRepository.saveAndFlush(customerEntity);
        }
    }
}
