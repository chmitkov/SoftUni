package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.Author;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface AuthorService {

    void seedAuthors() throws IOException;

    List<String> findAllOrderedByBookCount();
}
