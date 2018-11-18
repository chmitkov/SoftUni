package bookshopsystemapp.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    List<String> bookTitlesByAgeRestriction(String ageRestrictionStr);

    List<String> goldenBooksTitles();

    List<String> bookTitleAndPriceInRange(BigDecimal priceFrom, BigDecimal priceTo);

    List<String> notReleasedBookInYear(String year);

    List<String> booksReleasedBeforeDate(String dateStr);

    List<String> booksWithAuthorsWithFirstNameEnds(String nameEndsWithStr);

    List<String> booksWithTitleContainingString(String containingString);

    Integer booksCount(Integer length);

    String bookInfo(String title);

    List<String> findAllByCountOfAllCopies();
}
