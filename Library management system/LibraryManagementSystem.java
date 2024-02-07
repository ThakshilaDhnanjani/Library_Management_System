import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public Book(Scanner scanner) {
        System.out.print("Enter book title: ");
        this.title = scanner.nextLine();

        System.out.print("Enter author name: ");
        this.author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        this.isbn = scanner.nextLine();

        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\nAvailable: " + available;
    }
}

class FictionBook extends Book {
    public FictionBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    public FictionBook(Scanner scanner) {
        super(scanner);
    }
}

class NonFictionBook extends Book {
    public NonFictionBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    public NonFictionBook(Scanner scanner) {
        super(scanner);
    }
}

class ScienceFictionBook extends Book {
    public ScienceFictionBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    public ScienceFictionBook(Scanner scanner) {
        super(scanner);
    }
}

class Novel extends Book {
    public Novel(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    public Novel(Scanner scanner) {
        super(scanner);
    }
}

class Library {
    private List<Book> fictionBooks;
    private List<Book> nonFictionBooks;
    private List<Book> scienceFictionBooks;
    private List<Book> novels;

    public Library() {
        this.fictionBooks = new ArrayList<>();
        this.nonFictionBooks = new ArrayList<>();
        this.scienceFictionBooks = new ArrayList<>();
        this.novels = new ArrayList<>();
    }

    public void addBook(Book book, int genre) {
        switch (genre) {
            case 1:
                fictionBooks.add(book);
                break;
            case 2:
                nonFictionBooks.add(book);
                break;
            case 3:
                scienceFictionBooks.add(book);
                break;
            case 4:
                novels.add(book);
                break;
            default:
                System.out.println("Invalid genre choice.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");

        System.out.println("\n1. Fiction Books:");
        displayBooksByCategory(fictionBooks);

        System.out.println("\n2. Nonfiction Books:");
        displayBooksByCategory(nonFictionBooks);

        System.out.println("\n3. Science Fiction Books:");
        displayBooksByCategory(scienceFictionBooks);

        System.out.println("\n4. Novels:");
        displayBooksByCategory(novels);
    }

    private void displayBooksByCategory(List<Book> bookList) {
        for (Book book : bookList) {
            if (book.isAvailable()) {
                System.out.println("....................................\n" + book);
            }
        }
    }

    public Book borrowBook(String isbn, int genre) {
        List<Book> bookList;
        switch (genre) {
            case 1:
                bookList = fictionBooks;
                break;
            case 2:
                bookList = nonFictionBooks;
                break;
            case 3:
                bookList = scienceFictionBooks;
                break;
            case 4:
                bookList = novels;
                break;
            default:
                return null;
        }

        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                book.setAvailable(false);
                return book;
            }
        }
        return null;
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
    }
}

class User {
    private static int userCount = 0;
    private int userId;
    private List<Book> borrowedBooks;

    public User() {
        this.userId = ++userCount;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.println("___________________PRADEEPA CENTRAL LIBRARY________________________\n" +
                "                     ________Explore Your Best Choice!______\n" +
                "    Books are the gateways to boundless imagination, unlocking worlds of wonder and dreams.");

        Book fictionBook1 = new FictionBook("The Great Gatsby", " F. Scott Fitzgerald", "1925");
        Book fictionBook2 = new FictionBook("The Handmaid's Tale", "Margaret Atwood", "4569");
        Book fictionBook3 = new FictionBook("The Hunger Games", "J.R. Tolkien", "1999");
        Book fictionBook4 = new FictionBook("To Kill a Mockingbird", "J.R. Tolk", "1896");
        Book fictionBook5 = new FictionBook("The dragons dougter", "Kristin Hannah", "5858");

        Book nonFictionBook1 = new NonFictionBook("My Name is Barbara", "Barbara Wilson", "1009");
        Book nonFictionBook2 = new NonFictionBook("Freakonomics", "Kenadi Browns", "2045");
        Book nonFictionBook3 = new NonFictionBook("Quiet", "Steeve Kolbert", "5625");
        Book nonFictionBook4 = new NonFictionBook("Watch your Mouth", "Elizabeth Capote", "9856");
        Book nonFictionBook5 = new NonFictionBook("In Cold Blood", "Truman Capote", "1205");

        Book scienceFictionBook1 = new ScienceFictionBook("Dune", "Frank Herbert", "9875");
        Book scienceFictionBook2 = new ScienceFictionBook("The Three Body Problem", "Liu Cixin", "9874");
        Book scienceFictionBook3 = new ScienceFictionBook("Neuromancer", "William Gibson", "9873");
        Book scienceFictionBook4 = new ScienceFictionBook("The Martian", "Andy Weir", "9872");
        Book scienceFictionBook5 = new ScienceFictionBook("Frankenstein", "Mary Shelly", "9871");

        Book novels1 = new Novel("Speak", "John Green", "1234");
        Book novels2 = new Novel("Uglies", "Scott Westerfeld", "1235");
        Book novels3 = new Novel("Forever", "Judy Blume", "1236");
        Book novels4 = new Novel("Twilight", "Stephenie Meyer", "1237");
        Book novels5 = new Novel("Feed", "M.T. Anderson", "1238");

        library.addBook(fictionBook1, 1);
        library.addBook(fictionBook2, 1);
        library.addBook(fictionBook3, 1);
        library.addBook(fictionBook4, 1);
        library.addBook(fictionBook5, 1);
        library.addBook(nonFictionBook1, 2);
        library.addBook(nonFictionBook2, 2);
        library.addBook(nonFictionBook3, 2);
        library.addBook(nonFictionBook4, 2);
        library.addBook(scienceFictionBook1, 3);
        library.addBook(scienceFictionBook2, 3);
        library.addBook(scienceFictionBook3, 3);
        library.addBook(scienceFictionBook4, 3);
        library.addBook(scienceFictionBook5, 3);
        library.addBook(novels1, 4);
        library.addBook(novels2, 4);
        library.addBook(novels3, 4);
        library.addBook(novels4, 4);
        library.addBook(novels5, 4);

        User user = new User();

        while (true) {
            System.out.println("\n1. Display Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Add a New Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String isbnToBorrow = scanner.nextLine();
                    System.out.print(
                            "Enter the genre of the book -:\n1.Fiction Book\n2.Nonfiction Book\n3.ScienceFictionBook\n4.Novel\nEnter What you want Book Category-:");
                    int genreToBorrow = scanner.nextInt();
                    Book borrowedBook = library.borrowBook(isbnToBorrow, genreToBorrow);

                    if (borrowedBook != null) {
                        user.borrowBook(borrowedBook);
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book not available or not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book you return: ");
                    String isbnToReturn = scanner.nextLine();
                    Book bookToReturn = null;

                    for (Book borrowed : user.getBorrowedBooks()) {
                        if (borrowed.getIsbn().equals(isbnToReturn)) {
                            bookToReturn = borrowed;
                            break;
                        }
                    }

                    if (bookToReturn != null) {
                        library.returnBook(bookToReturn);
                        user.returnBook(bookToReturn);
                        System.out.println("The book has been successfully returned.");
                    } else {
                        System.out.println("can't find the book.");
                    }
                    break;
                case 4:
                    System.out.print(
                            "Enter the genre of the book (1 Fiction, 2  Nonfiction, 3 Science Fiction, 4 Novel): ");
                    int genreToAdd = scanner.nextInt();
                    Book newBook;

                    switch (genreToAdd) {
                        case 1:
                            newBook = new FictionBook(scanner);
                            break;
                        case 2:
                            newBook = new NonFictionBook(scanner);
                            break;
                        case 3:
                            newBook = new ScienceFictionBook(scanner);
                            break;
                        case 4:
                            newBook = new Novel(scanner);
                            break;
                        default:
                            System.out.println("Invalid genre choice.");
                            continue; // Skip the rest of the loop and start over
                    }

                    library.addBook(newBook, genreToAdd);
                    System.out.println("successfully registered!");
                    break;
                case 5:
                    System.out.println("Thankyou!");
                    System.exit(0);
                default:
                    System.out.println("Invalied Option");
            }
        }
    }
}
