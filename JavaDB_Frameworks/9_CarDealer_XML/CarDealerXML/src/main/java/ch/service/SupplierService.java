package ch.service;

import ch.domain.dtos.SupplierImportRootDto;

public interface SupplierService {
    void importSuppliers(SupplierImportRootDto supplierImportRootDto);
}
