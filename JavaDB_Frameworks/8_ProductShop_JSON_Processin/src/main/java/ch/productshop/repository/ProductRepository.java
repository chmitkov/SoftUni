package ch.productshop.repository;

import ch.productshop.domain.dtos.ProductSeedDto;
import ch.productshop.domain.entities.Product;
import ch.productshop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByPriceBetweenAndBuyerOrderByPrice
            (BigDecimal more, BigDecimal less, User buyer);
}
