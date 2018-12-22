package alararestaurant.service;

import alararestaurant.domain.dtos.ItemImportDto;
import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.CategoryRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ItemServiceImpl implements ItemService {

    private final static String ITEMS_JSON_FILE_PATH =
            "C:\\Users\\4o4o9\\Desktop\\AlaraRestaurant-skeleton\\AlaraRestaurant\\src\\main\\resources\\files\\items.json";
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean itemsAreImported() {

        return this.itemRepository.count() > 0;
    }

    @Override
    public String readItemsJsonFile() throws IOException {
        return this.fileUtil.readFile(ITEMS_JSON_FILE_PATH);
    }

    @Override
    public String importItems(String items) {
        StringBuilder importResult = new StringBuilder();

        ItemImportDto[] itemImportDtos = this.gson
                .fromJson(items, ItemImportDto[].class);

        for (ItemImportDto itemImportDto : itemImportDtos) {
            if (!this.validationUtil.isValid(itemImportDto)) {
                importResult.append("Invalid data format.")
                        .append(System.lineSeparator());
                continue;
            }

            Category categoryEntity = this.categoryRepository
                    .findByName(itemImportDto.getCategory()).orElse(null);

            if (categoryEntity == null) {
                categoryEntity = new Category();
                categoryEntity.setName(itemImportDto.getCategory());
                categoryEntity = this.categoryRepository.saveAndFlush(categoryEntity);
            }

            if(this.itemRepository
                    .findByName(itemImportDto.getName())
                    .orElse(null) != null){
                importResult.append("Invalid data format.")
                        .append(System.lineSeparator());
                continue;
            }

            Item itemEntity = this.modelMapper.map(itemImportDto, Item.class);

            itemEntity.setCategory(categoryEntity);

            this.itemRepository.saveAndFlush(itemEntity);

            importResult.append(String.format("Record %s successfully imported."
                    , itemImportDto.getName()))
                    .append(System.lineSeparator());
        }
        return importResult.toString().trim();
    }
}
