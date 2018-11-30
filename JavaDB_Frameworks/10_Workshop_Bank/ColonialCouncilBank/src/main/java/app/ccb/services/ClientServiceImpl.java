package app.ccb.services;

import app.ccb.domain.dtos.ClientImportDto;
import app.ccb.domain.entities.BankAccount;
import app.ccb.domain.entities.Card;
import app.ccb.domain.entities.Client;
import app.ccb.domain.entities.Employee;
import app.ccb.repositories.BankAccountRepository;
import app.ccb.repositories.ClientRepository;
import app.ccb.repositories.EmployeeRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final static String CLIENTS_JSON_FILE_PATH =
            "C:\\Users\\4o4o9\\Desktop\\ColonialCouncilBank-skeleton\\ColonialCouncilBank\\src\\main\\resources\\files\\json\\clients.json";

    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final BankAccountRepository bankAccountRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, EmployeeRepository employeeRepository, BankAccountRepository bankAccountRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper mapper, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean clientsAreImported() {
        return this.clientRepository.count() != 0;
    }

    @Override
    public String readClientsJsonFile() throws IOException {
        return this.fileUtil.readFile(CLIENTS_JSON_FILE_PATH);
    }

    @Override
    public String importClients(String clients) {
        StringBuilder importResult = new StringBuilder();

        ClientImportDto[] clientImportDtos = this.gson.fromJson(
                clients, ClientImportDto[].class);

        for (ClientImportDto clientImportDto : clientImportDtos) {
            if (!this.validationUtil.isValid(clientImportDto)) {
                importResult.append("Error: Incorrect Data!")
                        .append(System.lineSeparator());

                continue;
            }

            String[] employeeNames = clientImportDto.getAppointedEmployee().split(" ");
            Employee employeeEntity = this.employeeRepository.findByFirstNameAndLastName(
                    employeeNames[0], employeeNames[1]).orElse(null);

            if (employeeEntity == null) {
                importResult.append("Error: Incorrect Data!")
                        .append(System.lineSeparator());

                continue;
            }

            String clientFullName = String.format("%s %s",
                    clientImportDto.getFirstName(), clientImportDto.getLastName());

            Client clientEntity = this.clientRepository.findByFullName(clientFullName).orElse(null);

            if (clientEntity != null) {
                importResult.append("Error: Incorrect Data!")
                        .append(System.lineSeparator());

                continue;
            }

            clientEntity = this.modelMapper.map(
                    clientImportDto, Client.class);

            clientEntity.setFullName(clientFullName);

            clientEntity.getEmployees().add(employeeEntity);

            this.clientRepository.saveAndFlush(clientEntity);

            importResult.append(String.format("Successfully imported Client - %s", clientFullName))
                    .append(System.lineSeparator());
        }
        return importResult.toString().trim();
    }

    @Override
    public String exportFamilyGuy() {
        StringBuilder exportFamilyG = new StringBuilder();

        List<Client> clientsWithCards = this.clientRepository
                .findClientByNumberOfCards();

        Client topClient = clientsWithCards.get(0);

        BankAccount bankAccount = this.bankAccountRepository
                .findByAccountNumber(topClient.getBankAccount().getAccountNumber())
                .orElse(null);

        exportFamilyG.append(String.format("Full name: %s", topClient.getFullName()))
                .append(System.lineSeparator())
                .append(String.format("Age: %d", topClient.getAge()))
                .append(System.lineSeparator())
                .append(String.format("Bank Account: %s", bankAccount.getAccountNumber()))
                .append(System.lineSeparator());

        for (Card card : bankAccount.getCards()) {
            exportFamilyG.append(String.format("    Card Number: %s",
                    card.getCardNumber())).append(System.lineSeparator());
        }
        return exportFamilyG.toString().trim();
    }
}
