package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.Author;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final static String AUTHORS_FILE_PATH =
            "C:\\Users\\4o4o9\\Desktop\\springdataintro\\src\\main\\resources\\files\\authors.txt";

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedAuthors() throws IOException {

        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] authorFileContent = this.fileUtil.getFileContent(AUTHORS_FILE_PATH);

        for (String line : authorFileContent) {
            String[] names = line.split("\\s+");

            Author author = new Author();
            author.setFirstName(names[0]);
            author.setLastName(names[1]);

            this.authorRepository.saveAndFlush(author);
        }
    }

    @Override
    public List<String> bookTitlesSearch(String givenStr) {
        String wildCard = givenStr.concat("%");

        List<String> result = new ArrayList<>();
        List<Author> authorsList = this.authorRepository.bookTitlesSearch(wildCard);

        for (Author author : authorsList) {
            List<String> books = this.bookRepository.findAllByAuthor(author)
                    .stream().map(Book::getTitle).collect(Collectors.toList());

            result.addAll(books);
        }

        return result;
    }

    @Override
    public List<String> totalBookCopiesByAuthor() {
      //  List<Author> test = this.authorRepository.findAllAuthorByBooksCopies();

        return new ArrayList<>();
    }
}
