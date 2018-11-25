package ch.productshop.service;

import ch.productshop.domain.dtos.ProductInRangeDto;
import ch.productshop.domain.dtos.ProductSeedDto;
import ch.productshop.domain.entities.Category;
import ch.productshop.domain.entities.Product;
import ch.productshop.domain.entities.User;
import ch.productshop.repository.CategoryRepository;
import ch.productshop.repository.ProductRepository;
import ch.productshop.repository.UserRepository;
import ch.productshop.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedProducts(ProductSeedDto[] productSeedDtos) {
        for (ProductSeedDto productSeedDto : productSeedDtos) {
            if (!this.validatorUtil.isValid(productSeedDto)) {
                this.validatorUtil.violations(productSeedDto)
                        .forEach(x -> System.out.println(x.getMessage()));

                continue;
            }
            Product product = this.modelMapper.map(productSeedDto, Product.class);
            product.setSeller(getRandomUser());

            Random random = new Random();
            if (random.nextInt() % 13 != 0) {
                product.setBuyer(getRandomUser());
            }

            product.setCategories(getRandomCategories());

            this.productRepository.saveAndFlush(product);

        }
    }

    @Override
    public List<ProductInRangeDto> productsInRange(BigDecimal more, BigDecimal less) {
        List<Product> productEntities = this.productRepository.findAllByPriceBetweenAndBuyerOrderByPrice(
                more, less, null);

        List<ProductInRangeDto> productInRangeDtos = new ArrayList<>();

        for (Product productEntity : productEntities) {
            ProductInRangeDto productInRangeDto =
                    this.modelMapper.map(productEntity, ProductInRangeDto.class);
            productInRangeDto.setSeller(String.format("%s %s",
                    productEntity.getSeller().getFirstName(),
                    productEntity.getSeller().getLastName()
            ));

            productInRangeDtos.add(productInRangeDto);
        }
        return productInRangeDtos;
    }

    private User getRandomUser() {
        Random random = new Random();

        //int randomInt = ;
        return this.userRepository.getOne(random.nextInt((int) this.userRepository.count() - 1) + 1);
    }

    private List<Category> getRandomCategories() {
        Random random = new Random();

        List<Category> categories = new ArrayList<>();

        int categoriesCount = random.nextInt((int) this.categoryRepository.count() - 1) + 1;
        for (int i = 0; i < categoriesCount; i++) {
            categories.add(this.categoryRepository.getOne(
                    random.nextInt((int) this.categoryRepository.count() - 1) + 1));
        }

        return categories;
    }
}
