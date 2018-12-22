package alararestaurant.service;

import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String exportCategoriesByCountOfItems() {
        StringBuilder exportResult = new StringBuilder();

        List<Category> categories = this.categoryRepository.findByCountOfItems();


        for (Category category : categories) {
            exportResult.append(String.format("Category: %s", category.getName()))
                    .append(System.lineSeparator());
            // String test = category.getItems().stream()
            //       .map(item -> String.format("%s - %.2f", item.getName(), item.getPrice()))
            //     .collect(Collectors.joining(System.lineSeparator()));

            for (Item item : category.getItems()) {
                exportResult.append(String.format("--- Item Name: %s", item.getName()))
                        .append(System.lineSeparator())
                        .append(String.format("--- Item Price: %.2f", item.getPrice()))
                        .append(System.lineSeparator())
                        .append(System.lineSeparator());
            }
            exportResult.append(System.lineSeparator()).append(System.lineSeparator());
        }

        return exportResult.toString().trim();
    }
}
