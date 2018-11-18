package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.Author;
import bookshopsystemapp.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("SELECT a " +
            "FROM bookshopsystemapp.domain.entities.Author AS a " +
            "WHERE a.lastName LIKE :wildCard")
    List<Author> bookTitlesSearch(@Param("wildCard") String wildCard);

  // @Query("SELECT a, CONCAT(a.firstName, ' ', a.lastName) " +
  //         "FROM bookshopsystemapp.domain.entities.Book AS b " +
  //         "JOIN bookshopsystemapp.domain.entities.Author AS a")
  // List<Author> findAllAuthorByBooksCopies();
}
