package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.Author;
import bookshopsystemapp.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.security.acl.Group;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByCopiesLessThan(Integer numberOfCopies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal priceFrom, BigDecimal priceTo);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate beforeDate, LocalDate afterDate);

    List<Book> findAllByReleaseDateBefore(LocalDate localDate);

    List<Book> findAll();

    //@Query(value = "SELECT b FROM Book AS b JOIN Author AS a WHERE ")
    List<Book> findAllByTitleContaining(String string);

    List<Book> findAllByAuthor(Author author);

    @Query("SELECT SUM(b.copies), CONCAT(a.firstName, ' ', a.lastName) " +
            "FROM bookshopsystemapp.domain.entities.Book AS b " +
            "JOIN b.author AS a " +
            "GROUP BY a.id " +
            "ORDER BY SUM(b.copies) DESC")
    List<Object[]> findAllByCountOfAllCopies();

    @Query("SELECT COUNT(b) FROM bookshopsystemapp.domain.entities.Book AS b WHERE LENGTH(b.title)> :length")
    Integer findAllByTitleLessThanGivenLength(@Param("length") int length);

    Book findBookByTitle(String title);
}
