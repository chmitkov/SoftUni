package alararestaurant.service;

import alararestaurant.domain.dtos.EmployeeImportDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Position;
import alararestaurant.repository.CategoryRepository;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.PositionRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final static String EMPLOYEES_JSON_FILE_PATH =
            "C:\\Users\\4o4o9\\Desktop\\AlaraRestaurant-skeleton\\AlaraRestaurant\\src\\main\\resources\\files\\employees.json";

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CategoryRepository categoryRepository, PositionRepository positionRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        return this.fileUtil.readFile(EMPLOYEES_JSON_FILE_PATH);
    }

    @Override
    public String importEmployees(String employees) throws IOException {
        StringBuilder importResult = new StringBuilder();

        EmployeeImportDto[] employeeImportDtos = this.gson
                .fromJson(employees, EmployeeImportDto[].class);

        for (EmployeeImportDto employeeImportDto : employeeImportDtos) {
            if(!this.validationUtil.isValid(employeeImportDto)){
                importResult.append("Invalid data format.")
                        .append(System.lineSeparator());
                continue;
            }

            Position positionEntity = this.positionRepository
                    .findByName(employeeImportDto.getPosition()).orElse(null);

            if(positionEntity == null){
                positionEntity = new Position();
                positionEntity.setName(employeeImportDto.getPosition());
                positionEntity = this.positionRepository.saveAndFlush(positionEntity);
            }

            Employee employeeEntity = this.modelMapper
                    .map(employeeImportDto, Employee.class);

            employeeEntity.setPosition(positionEntity);

            this.employeeRepository.saveAndFlush(employeeEntity);

            importResult.append(String.format("Record %s successfully imported.",
                    employeeImportDto.getName()))
                    .append(System.lineSeparator());

        }

        return importResult.toString().trim();
    }
}
