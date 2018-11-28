package ch.service;

import ch.domain.dtos.CarImportDto;
import ch.domain.dtos.CarImportRootDto;
import ch.domain.entities.Car;
import ch.domain.entities.Part;
import ch.repository.CarRepository;
import ch.repository.PartRepository;
import ch.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importCars(CarImportRootDto carImportRootDto) {

        for (CarImportDto carImportDto : carImportRootDto.getCarImportDtos()) {
            if (!this.validationUtil.isValid(carImportDto)) {
                System.out.println("Something went wrong.");

                continue;
            }

            Car carEntity = this.modelMapper.map(carImportDto,
                    Car.class);

            carEntity.setParts(this.getRandomParts());

            this.carRepository.saveAndFlush(carEntity);
        }
    }

    private List<Part> getRandomParts() {
        List<Part> parts = new ArrayList<>();
        Random random = new Random();

        List<Part> partEntities = this.partRepository.findAll();

        int length = random.nextInt(10) + 10;

        for (int i = 0; i < length; i++) {
            int partIndex = random.nextInt(
                    (int) (this.partRepository.count() - 1)) + 1;
            parts.add(partEntities.get(partIndex));

        }

        return parts;
    }
}
