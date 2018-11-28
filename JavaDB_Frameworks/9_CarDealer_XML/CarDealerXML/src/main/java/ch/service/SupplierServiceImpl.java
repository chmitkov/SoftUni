package ch.service;

import ch.domain.dtos.SupplierImportDto;
import ch.domain.dtos.SupplierImportRootDto;
import ch.domain.entities.Supplier;
import ch.repository.SupplierRepository;
import ch.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importSuppliers(SupplierImportRootDto supplierImportRootDto) {
        for (SupplierImportDto supplierImportDto : supplierImportRootDto.getSupplierImportDtos()) {
            if (!this.validationUtil.isValid(supplierImportDto)) {
                System.out.println("Something went wrong");

                continue;
            }

            Supplier supplierEntity = this.modelMapper
                    .map(supplierImportDto, Supplier.class);

            this.supplierRepository.saveAndFlush(supplierEntity);
        }
    }
}
