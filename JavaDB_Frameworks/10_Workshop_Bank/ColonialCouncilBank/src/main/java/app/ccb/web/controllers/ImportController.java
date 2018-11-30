package app.ccb.web.controllers;

import app.ccb.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

    private final BranchService branchService;
    private final EmployeeService employeeService;
    private final ClientService clientService;
    private final BankAccountService bankAccountService;
    private final CardService cardService;

    @Autowired
    public ImportController(BranchService branchService, EmployeeService employeeService, ClientService clientService, BankAccountService bankAccountService, CardService cardService) {
        this.branchService = branchService;
        this.employeeService = employeeService;
        this.clientService = clientService;
        this.bankAccountService = bankAccountService;
        this.cardService = cardService;
    }

    @GetMapping("/json")
    public ModelAndView importJson() {
        boolean[] areImported = new boolean[]{
                this.branchService.branchesAreImported(),
                this.employeeService.employeesAreImported(),
                this.clientService.clientsAreImported()
        };

        return super.view("json/import-json", "areImported", areImported);
    }

    @GetMapping("/xml")
    public ModelAndView importXml() {
        boolean[] areImported = new boolean[]{
                this.bankAccountService.bankAccountsAreImported(),
                this.cardService.cardsAreImported()
        };

        return super.view("xml/import-xml", "areImported", areImported);
    }

    @GetMapping("/branches")
    public ModelAndView importBranches() throws IOException {
        String branchesJsonFile = this.branchService.readBranchesJsonFile();
        return super.view("json/import-branches", "branches", branchesJsonFile);
    }

    @PostMapping(value = "/branches")
    public ModelAndView importBranchesConfirm(@RequestParam(required = false, name = "branches") String branches) {
        String importResult = this.branchService.importBranches(branches);
        System.out.println(importResult);

        return super.redirect("/import/json");
    }

    @GetMapping("/employees")
    public ModelAndView importEmployees() throws IOException {
        String employeesJsonFile = this.employeeService.readEmployeesJsonFile();
        return super.view("json/import-employees", "employees", employeesJsonFile);
    }

    @PostMapping("/employees")
    public ModelAndView importEmployeesConfirm(@RequestParam(required = false, name = "employees") String employees) {
        String importResult = this.employeeService.importEmployees(employees);
        System.out.println(importResult);

        return super.redirect("/import/json");
    }

    @GetMapping("/clients")
    public ModelAndView importClients() throws IOException {
        String clientJsonFile = this.clientService.readClientsJsonFile();
        return super.view("json/import-clients", "clients", clientJsonFile);
    }

    @PostMapping("/clients")
    public ModelAndView importClientsConfirm(@RequestParam(required = false, name = "clients") String clients) {
        String importResult = this.clientService.importClients(clients);
        System.out.println(importResult);

        return super.redirect("/import/json");
    }

    @GetMapping("/bank-accounts")
    public ModelAndView importBankAccounts() throws IOException {
        String bankAccountXmlFile = this.bankAccountService.readBankAccountsXmlFile();
        return super.view("xml/import-bank-accounts", "bankAccounts", bankAccountXmlFile);
    }

    @PostMapping("/bank-accounts")
    public ModelAndView importBankAccountsConfirm() throws FileNotFoundException, JAXBException {
        String importResult = this.bankAccountService.importBankAccounts();
        System.out.println(importResult);

        return super.redirect("/import/xml");
    }

    @GetMapping("/cards")
    public ModelAndView importCards() throws IOException {
        String cardXmlFile = this.cardService.readCardsXmlFile();
        return super.view("xml/import-cards", "cards", cardXmlFile);
    }

    @PostMapping("/cards")
    public ModelAndView importCardsConfirm() throws JAXBException, FileNotFoundException {
        String importResult = this.cardService.importCards();
        System.out.println(importResult);

        return super.redirect("/import/xml");
    }
}
