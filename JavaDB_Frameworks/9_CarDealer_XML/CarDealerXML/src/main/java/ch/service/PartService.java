package ch.service;

import ch.domain.dtos.PartImportRootDto;

public interface PartService {
    void importParts(PartImportRootDto partImportRootDto);
}
