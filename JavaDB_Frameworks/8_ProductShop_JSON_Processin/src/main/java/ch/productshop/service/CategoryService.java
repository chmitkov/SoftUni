package ch.productshop.service;


import ch.productshop.domain.dtos.CategorySeedDto;

public interface CategoryService {

    void seedCategories(CategorySeedDto[] categorySeedDtos);
}
