package app.ccb.services;

import app.ccb.domain.dtos.EmployeeImportDto;
import app.ccb.domain.entities.Branch;
import app.ccb.domain.entities.Client;
import app.ccb.domain.entities.Employee;
import app.ccb.repositories.BranchRepository;
import app.ccb.repositories.EmployeeRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final static String EMPLOYEE_JSON_FILE_PATH =
            "C:\\Users\\4o4o9\\Desktop\\ColonialCouncilBank-skeleton\\ColonialCouncilBank\\src\\main\\resources\\files\\json\\employees.json";

    private final EmployeeRepository employeeRepository;
    private final BranchRepository branchRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BranchRepository branchRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() != 0;
    }

    @Override
    public String readEmployeesJsonFile() throws IOException {
        return this.fileUtil.readFile(EMPLOYEE_JSON_FILE_PATH);
    }

    @Override
    public String importEmployees(String employees) {
        StringBuilder importResults = new StringBuilder();
        EmployeeImportDto[] employeeImportDtos = this.gson.fromJson(
                employees, EmployeeImportDto[].class);

        for (EmployeeImportDto employeeImportDto : employeeImportDtos) {
            if (!this.validationUtil.isValid(employeeImportDto)) {
                importResults.append("Error: Incorrect Data!")
                        .append(System.lineSeparator());

                continue;
            }

            Branch branchEntity = this.branchRepository.findAllByName(
                    employeeImportDto.getBranchName()).orElse(null);

            if (branchEntity == null) {
                importResults.append("Error: Incorrect Data!")
                        .append(System.lineSeparator());

                continue;
            }

            Employee employeeEntity = this.modelMapper.map(
                    employeeImportDto, Employee.class);

            String[] names = employeeImportDto.getFullName().split(" ");
            employeeEntity.setFirstName(names[0]);
            employeeEntity.setLastName(names[1]);

            employeeEntity.setStartedOn(LocalDate.parse(
                    employeeImportDto.getStartedOn()));

            employeeEntity.setBranch(branchEntity);

            this.employeeRepository.saveAndFlush(employeeEntity);

            importResults.append(String.format("Successfully imported Employee – %s",
                    employeeImportDto.getFullName()))
                    .append(System.lineSeparator());
        }
        return importResults.toString().trim();
    }

    @Override
    public String exportTopEmployees() {
        StringBuilder exportEmployees = new StringBuilder();
        List<Employee> topEmployees = this.employeeRepository.findAllWithClients();

        for (Employee currentEmployee : topEmployees) {
            exportEmployees.append(String.format("Full name: %s %s",
                    currentEmployee.getFirstName(), currentEmployee.getLastName()))
                    .append(System.lineSeparator())
                    .append(String.format("Salary: %.2f", currentEmployee.getSalary()))
                    .append(System.lineSeparator())
                    .append(String.format("Started On: %s", currentEmployee.getStartedOn()))
                    .append(System.lineSeparator())
                    .append("Clients:").append(System.lineSeparator());

            for (Client client : currentEmployee.getClients()) {
                exportEmployees.append(String.format("  %s", client.getFullName()))
                        .append(System.lineSeparator());
            }
        }

        return exportEmployees.toString().trim();
    }
}
