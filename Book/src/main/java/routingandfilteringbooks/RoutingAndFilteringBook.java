package routingandfilteringbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class RoutingAndFilteringBook {
    private static List<Book> bookList = new ArrayList<>();

    RoutingAndFilteringBook() {
        bookList.add(new Book("Harry Potter & the Philosopher's Stone", "J K Rowling", 250));
        bookList.add(new Book("Atomic Habits", "James Clear", 300));
    }

    @RequestMapping(value = "/available-books", method = RequestMethod.GET)
    public List<Book> available() {
        return bookList;
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String add(@RequestBody Book bookData) {
        bookList.add(bookData);
        return  "Record added successfully";
    }

    @RequestMapping(value = "/get-book/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable Integer index) {
        index = index != null ? index : 0;
        return bookList.get(index);
    }

    @RequestMapping(value = "/update-book/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable Integer index, @RequestBody Book bookData) {
        bookList.set(index, bookData);
        return "Record updated successfully";
    }

    @RequestMapping(value = "/delete-book/{id}", method = RequestMethod.PUT)
    public String delete(@PathVariable Integer index) {
        bookList.remove(index);
        return "Record deleted successfully";
    }

    @RequestMapping(value = "/internal/fetch-first", method = RequestMethod.GET)
    public Book get() {
        return bookList.get(0);
    }

    public static void main(String[] args) {
        SpringApplication.run(RoutingAndFilteringBook.class, args);
    }
}
