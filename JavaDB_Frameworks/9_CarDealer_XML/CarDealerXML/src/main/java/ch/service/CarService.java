package ch.service;

import ch.domain.dtos.CarImportRootDto;

public interface CarService {

    void importCars(CarImportRootDto carImportRootDto);
}
