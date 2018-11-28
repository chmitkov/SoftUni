package ch.service;

import ch.domain.entities.Car;
import ch.domain.entities.Customer;
import ch.domain.entities.Sale;
import ch.repository.CarRepository;
import ch.repository.CustomerRepository;
import ch.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CustomerRepository customerRepository, CarRepository carRepository) {
        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
    }


    @Override
    public void importSales() {

        final int saleNumberToSeed = 40;
        Set<Sale> sales = new HashSet<>(saleNumberToSeed);

        for (int i = 0; i < saleNumberToSeed; i++) {
            while (true) {
                Sale sale = new Sale();
                sale.setCar(getRandomCar());
                sale.setCustomer(getRandomCustomer());
                sale.setDiscount(getRandomDiscountPercentage());
                if (sales.add(sale)) {
                    break;
                }
            }
        }
        saleRepository.saveAll(sales);
    }

    private Integer getRandomDiscountPercentage() {
        Integer[] discounts = new Integer[]{0, 5, 1, 15, 20, 30, 40, 50};
        Random random = new Random();
        int randomIndex = random.nextInt(discounts.length);
        return  discounts[randomIndex];
    }

    private Customer getRandomCustomer() {
        Random random = new Random();
        int randomId = random.nextInt((int) customerRepository.count()) + 1;
        return customerRepository.getOne(randomId);
    }

    private Car getRandomCar() {
        Random random = new Random();
        int randomId = random.nextInt((int) carRepository.count()) + 1;
        return carRepository.getOne(randomId);
    }
}

