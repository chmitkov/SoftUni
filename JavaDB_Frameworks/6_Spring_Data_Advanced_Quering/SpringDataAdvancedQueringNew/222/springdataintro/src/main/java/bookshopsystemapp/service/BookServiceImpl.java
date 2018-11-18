package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.*;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH =
            "C:\\Users\\4o4o9\\Desktop\\springdataintro\\src\\main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;

    private final FileUtil fileUtil;

    private final AuthorRepository authorRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void seedBooks() throws IOException {

        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);

        for (String line : booksFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();

            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(lineParams[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();
            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i]).append(" ");
            }
            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(
                LocalDate.parse("2000-12-31"));

        return books.stream().map(x -> x.getTitle()).collect(Collectors.toList());
    }

    @Override
    public List<String> bookTitlesByAgeRestriction(String ageRestrictionStr) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionStr);

        return this.bookRepository.findAllByAgeRestriction(ageRestriction)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> goldenBooksTitles() {
        return this.bookRepository.findAllByCopiesLessThan(5000)
                .stream().map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> bookTitleAndPriceInRange(BigDecimal priceFrom, BigDecimal priceTo) {
        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(priceFrom, priceTo)
                .stream()
                .map(x -> String.format("%s - $%.2f", x.getTitle(), x.getPrice())).collect(Collectors.toList());
    }

    @Override
    public List<String> notReleasedBookInYear(String year) {
        LocalDate beforeDate = LocalDate.of(Integer.parseInt(year), 1, 1);
        LocalDate afterDate = LocalDate.of(Integer.parseInt(year), 12, 31);

        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(beforeDate, afterDate)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> booksReleasedBeforeDate(String dateStr) {
        int[] dateTokens = Arrays.stream(dateStr.split("-"))
                .mapToInt(Integer::parseInt).toArray();

        LocalDate localDate = LocalDate.of(dateTokens[2], dateTokens[1], dateTokens[0]);

        return this.bookRepository.findAllByReleaseDateBefore(localDate)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> booksWithAuthorsWithFirstNameEnds(String nameEndsWithStr) {

        return this.bookRepository.findAll().stream()
                .filter(x -> x.getAuthor().getFirstName().endsWith(nameEndsWithStr))
                .map(x -> String.format("%s %s", x.getAuthor().getFirstName(), x.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> booksWithTitleContainingString(String containingString) {
        return this.bookRepository.findAllByTitleContaining(containingString)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public Integer booksCount(Integer length) {
        return this.bookRepository.findAllByTitleLessThanGivenLength(length);
    }

    @Override
    public String bookInfo(String title) {

        StringBuilder sb = new StringBuilder();
        Book book = this.bookRepository.findBookByTitle(title);
        sb.append(title).append(" ").append(book.editionType.name())
                .append(" ").append(book.ageRestriction.name()).append(" ").append(book.price);

        return sb.toString();
    }

    @Override
    public List<String> findAllByCountOfAllCopies() {
        List<Object[]> list = this.bookRepository.findAllByCountOfAllCopies();

        List<String> result = new ArrayList<>();

        for (Object[] row : list) {
            String fullName =  row[1].toString();
            String copies =  row[0].toString();

            result.add(String.format("%s - %s", fullName, copies));
        }
        return result;
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);

    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();

        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();
            categories.add(category);
        }

        return categories;
    }
}
