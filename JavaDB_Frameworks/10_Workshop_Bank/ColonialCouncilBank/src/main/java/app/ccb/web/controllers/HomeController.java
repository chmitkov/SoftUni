package app.ccb.web.controllers;

import app.ccb.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {

    private final BranchService branchService;
    private final EmployeeService employeeService;
    private final ClientService clientService;
    private final BankAccountService bankAccountService;
    private final CardService cardService;

    @Autowired
    public HomeController(BranchService branchService, EmployeeService employeeService, ClientService clientService, BankAccountService bankAccountService, CardService cardService) {
        this.branchService = branchService;
        this.employeeService = employeeService;
        this.clientService = clientService;
        this.bankAccountService = bankAccountService;
        this.cardService = cardService;
    }

    @GetMapping("")
    public ModelAndView index() {
        boolean areImported = this.branchService.branchesAreImported() &&
                this.employeeService.employeesAreImported() &&
                this.clientService.clientsAreImported() &&
                this.bankAccountService.bankAccountsAreImported() &&
                this.cardService.cardsAreImported();

        return super.view("index", "areImported", areImported);
    }
}
