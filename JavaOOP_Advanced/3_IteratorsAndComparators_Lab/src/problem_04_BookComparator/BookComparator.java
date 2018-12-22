package problem_04_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        if (firstBook.getTitle().equals(secondBook.getTitle())) {
            return firstBook.getYear() == secondBook.getYear()
                    ? 0 : firstBook.getYear() - secondBook.getYear();
        }
        return firstBook.getTitle().compareTo(secondBook.getTitle());
    }
}
