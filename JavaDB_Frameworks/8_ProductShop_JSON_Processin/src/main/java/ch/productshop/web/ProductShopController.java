package ch.productshop.web;

import ch.productshop.domain.dtos.CategorySeedDto;
import ch.productshop.domain.dtos.ProductInRangeDto;
import ch.productshop.domain.dtos.ProductSeedDto;
import ch.productshop.domain.dtos.UserSeedDto;
import ch.productshop.domain.entities.Product;
import ch.productshop.service.CategoryService;
import ch.productshop.service.ProductService;
import ch.productshop.service.UserService;
import ch.productshop.util.FileIOUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductShopController implements CommandLineRunner {

    private final static String USER_FILE_PATH =
            "C:\\Users\\4o4o9\\Desktop\\ProductShop\\src\\main\\resources\\files\\users.json";
    private final static String CATEGORIES_FILE_PATH =
            "C:\\Users\\4o4o9\\Desktop\\ProductShop\\src\\main\\resources\\files\\categories.json";
    private final static String PRODUCTS_FILE_PATH =
            "C:\\Users\\4o4o9\\Desktop\\ProductShop\\src\\main\\resources\\files\\products.json";


    private final UserService userService;
    private final CategoryService categoryService;
    private final FileIOUtil fileIOUtil;
    private final ProductService productService;
    private final Gson gson;

    @Autowired
    public ProductShopController(UserService userService, CategoryService categoryService, FileIOUtil fileIOUtil, ProductService productService, Gson gson) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.fileIOUtil = fileIOUtil;
        this.productService = productService;
        this.gson = gson;
    }


    @Override
    public void run(String... args) throws Exception {

        // this.seedUsers();
        // this.seedCategories();
        // this.seedProducts();

        this.productsInRange();
    }

    private void seedUsers() throws IOException {
        String usersFileContent = this.fileIOUtil.readFile(USER_FILE_PATH);

        UserSeedDto[] userSeedDtos = this.gson
                .fromJson(usersFileContent, UserSeedDto[].class);

        this.userService.seedUsers(userSeedDtos);

    }

    private void seedCategories() throws IOException {
        String categoriesFileContent =
                this.fileIOUtil.readFile(CATEGORIES_FILE_PATH);

        CategorySeedDto[] categorySeedDtos =
                this.gson.fromJson(categoriesFileContent, CategorySeedDto[].class);

        this.categoryService.seedCategories(categorySeedDtos);
    }

    private void seedProducts() throws IOException {
        String productsFileContent = this.fileIOUtil.readFile(PRODUCTS_FILE_PATH);

        ProductSeedDto[] productSeedDtos =
                this.gson.fromJson(productsFileContent, ProductSeedDto[].class);


        this.productService.seedProducts(productSeedDtos);

    }

    private void productsInRange() throws IOException {
        List<ProductInRangeDto> productInRangeDtos = this.productService
                .productsInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        String productsInRangeJson = this.gson.toJson(productInRangeDtos);

        File file = new File(
                "C:\\Users\\4o4o9\\Desktop\\ProductShop\\src\\main\\resources\\files\\output\\products-in-range.json");

        FileWriter writer = new FileWriter(file);
        writer.write(productsInRangeJson);
        writer.close();
    }
}
