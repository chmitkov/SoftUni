package app.ccb.web.controllers;

import app.ccb.services.ClientService;
import app.ccb.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final EmployeeService employeeService;
    private final ClientService clientService;

    @Autowired
    public ExportController(EmployeeService employeeService, ClientService clientService) {
        this.employeeService = employeeService;
        this.clientService = clientService;
    }

    @GetMapping("/top-employees")
    public ModelAndView exportTopEmployees() {
        String exportResult = this.employeeService.exportTopEmployees();

        return super.view("export/export-top-employees", "topEmployees", exportResult);
    }

    @GetMapping("/family-guy")
    public ModelAndView exportFamilyGuy() {
        String exportResult = this.clientService.exportFamilyGuy();

        return super.view("export/export-family-guy", "familyGuy", exportResult);
    }
}
