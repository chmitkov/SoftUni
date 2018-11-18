package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;

    private final CategoryService categoryService;

    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.authorService.seedAuthors();

        this.categoryService.seedCategories();

        this.bookService.seedBooks();

        //this.bookTitles();

        //this.authorNames();

        // 1.Books Titles by Age Restriction
        // this.bookTitlesByAgeRestriction();

        // 2.Golden Books
        //this.goldenBook();

        // 3.Books by Price
        // this.bookByPrice();

        // 4.Not Released Books
        // this.notReleasedBooks();

        //  5.Books Released Before Date
        // this.bookReleasedBefore();

        //  6.Authors Search
        // this.authorWithNameEndsWith();

        // 7.Books Search
        // this.bookSearch();

        // 8.Book Titles Search
        // this.bookTitlesSearch();

        // 9.Count Books
        // this.countBooksWithLongerTitleThan();

        // 10.Total Book Copies
        // this.totalBookCopiesByAuthor();

        // 11.Reduced Book
        // this.reducedBook();
    }


    private void bookByPrice() {

        BigDecimal numberOne = BigDecimal.valueOf(5);
        BigDecimal numberTwo = BigDecimal.valueOf(40);
        this.bookService.bookTitleAndPriceInRange(numberOne, numberTwo)
                .forEach(System.out::println);
    }

    private void bookTitles() {
        List<String> bookTitles = this.bookService.getAllBooksTitlesAfter();

        System.out.println(String.join("\r\n", bookTitles));
    }

    private void bookTitlesByAgeRestriction() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ageRestrictionStr = br.readLine().toUpperCase();

        this.bookService.bookTitlesByAgeRestriction(ageRestrictionStr).forEach(System.out::println);
    }

    private void goldenBook() {

        this.bookService.goldenBooksTitles().forEach(System.out::println);
    }

    private void notReleasedBooks() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String yearStr = br.readLine();

        this.bookService.notReleasedBookInYear(yearStr).forEach(System.out::println);
    }

    private void bookReleasedBefore() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String dateInString = br.readLine();

        this.bookService.booksReleasedBeforeDate(dateInString).forEach(System.out::println);
    }

    private void authorWithNameEndsWith() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String endsWithStr = br.readLine();

        this.bookService.booksWithAuthorsWithFirstNameEnds(endsWithStr)
                .forEach(System.out::println);
    }

    private void bookSearch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String givenStr = br.readLine().toLowerCase();

        this.bookService.booksWithTitleContainingString(givenStr)
                .forEach(System.out::println);
    }

    private void bookTitlesSearch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String givenStr = br.readLine();

        this.authorService.bookTitlesSearch(givenStr).forEach(System.out::println);
    }

    private void countBooksWithLongerTitleThan() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        System.out.println(this.bookService.booksCount(length));
    }

    private void totalBookCopiesByAuthor() {
        this.bookService.findAllByCountOfAllCopies().forEach(System.out::println);
    }

    private void reducedBook() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String title = br.readLine();


        System.out.println(this.bookService.bookInfo(title));

    }


}
