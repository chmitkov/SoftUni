package bookshopsystemapp.service;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    List<String> bookTitlesSearch(String givenStr);

    List<String> totalBookCopiesByAuthor();
}
