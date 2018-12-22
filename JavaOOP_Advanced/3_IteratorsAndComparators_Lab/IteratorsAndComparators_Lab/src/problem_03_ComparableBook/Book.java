package problem_03_ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(this.authors);
    }

    public void setAuthors(String... authors) {
        this.authors = authors.length == 0
                ? new ArrayList<>() : Arrays.asList(authors);
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Year: %d, Authors: %s",
                this.getTitle(), this.getYear(),
                String.join(" ,", this.getAuthors()));
    }

    @Override
    public int compareTo(Book otherBook) {
        return this.year == otherBook.getYear()
                ? 0 : this.year - otherBook.getYear();
    }
}
