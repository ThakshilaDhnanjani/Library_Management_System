# Library_Management_System

This is a simple command-line library management system implemented in Java. It allows users to browse available books, borrow books, return books, and add new books to the library.

## Features

- Display available books categorized by genre: fiction, nonfiction, science fiction, and novels.
- Borrow books by entering the ISBN and the genre of the book.
- Return borrowed books by entering the ISBN.
- Add new books to the library by providing book details and selecting the genre.
- User-friendly command-line interface for easy interaction.

## Usage

1. Compile the Java source file `LibraryManagementSystem.java`.
2. Run the compiled program.

3. Follow the prompts to perform various library operations:
- Display available books.
- Borrow a book by providing the ISBN and genre.
- Return a borrowed book by providing the ISBN.
- Add a new book to the library by providing book details and genre.
- Exit the program.

## Classes

- `Book`: Represents a book with attributes such as title, author, ISBN, and availability status.
- `FictionBook`, `NonFictionBook`, `ScienceFictionBook`, `Novel`: Subclasses of `Book` representing different genres of books.
- `Library`: Manages the collection of books, allowing operations like adding books, displaying available books, borrowing books, and returning books.
- `User`: Represents a library user, allowing them to borrow and return books.

## Contributors

- G R T D Kirinda

## License

This project is licensed under the [MIT License](LICENSE).

