import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class _24BookLibrary {
    public static class Book {

        public String bookAuthor;

        public String bookName;

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public Date date;

        public double price;

        public Book(String bookAuthor, String bookName, Date date, double price) {
            this.bookAuthor = bookAuthor;
            this.bookName = bookName;
            this.date = date;
            this.price = price;
        }

        public String getBookAuthor() {
            return bookAuthor;
        }

        public void setBookAuthor(String bookAuthor) {
            this.bookAuthor = bookAuthor;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static class Library {
        public String authorName;

        public ArrayList<Book> books;

        public Double priceOfAllBook;

        public Double getPriceOfAllBook() {
            double sum = 0;

            for (Book b : books
                 ) {
                sum+=b.price;
            }
            return sum;
        }


        public String getAuthorName() {
            return authorName;
        }

        public Library(String authorName, ArrayList<Book> books) {
            this.authorName = authorName;
            this.books = books;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public ArrayList<Book> getBooks() {
            return books;
        }

        public void setBooks(ArrayList<Book> books) {
            this.books = books;
        }

    }

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Library> libraries = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());


        while (n-- > 0) {
            String[] commands = br.readLine().split(" ");

            String bookName = commands[0];

            String bookAuthor = commands[1];

            Date bookDate = new SimpleDateFormat("dd.MM.yyyy")
                    .parse(commands[3]);

            double bookPrice = Double.parseDouble(commands[5]);

            Book currBook = new Book(bookAuthor, bookName, bookDate, bookPrice);

            boolean found = false;
            for (Library lib : libraries) {
                if(lib.authorName.equals(bookAuthor)){
                    lib.books.add(currBook);
                    found=true;
                }
            }
            if (found==false){
                Library currLib = new Library(bookAuthor,new ArrayList<Book>());
                currLib.books.add(currBook);
                libraries.add(currLib);
            }
        }
        libraries.sort((a,b)->b.getPriceOfAllBook().compareTo(a.getPriceOfAllBook()));

        libraries.forEach(x-> System.out.printf("%s -> %s%n",x.authorName,x.getPriceOfAllBook()));
    }
}
