package ch.productshop.service;

import ch.productshop.domain.dtos.ProductInRangeDto;
import ch.productshop.domain.dtos.ProductSeedDto;
import ch.productshop.domain.entities.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);

    List<ProductInRangeDto> productsInRange
            (BigDecimal more, BigDecimal less);
}
