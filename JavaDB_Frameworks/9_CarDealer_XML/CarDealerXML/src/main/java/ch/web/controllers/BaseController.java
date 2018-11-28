package ch.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController implements CommandLineRunner {
    private final ImportController importController;

    @Autowired
    protected BaseController(ImportController importController) {
        this.importController = importController;
    }

    @Override
    public void run(String... args) throws Exception {

        // this.importController.importSuppliers();
        // this.importController.importParts();
        // this.importController.importCars();
        // this.importController.importCustomers();
        // this.importController.importSales();
    }
}
