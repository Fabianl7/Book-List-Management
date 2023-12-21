# Book-List-Management

This Java program, named BookListManagement, allows users to create and manage a list of bookstore books and library books. It uses the `BookList`, `Book`, `BookstoreBook`, and `LibraryBook` classes to represent different types of books and provides a simple interface for users to input book details.

## How it Works

### Book Class

The `Book` class is an abstract class that serves as the base class for both `BookstoreBook` and `LibraryBook`. It includes common properties such as author, title, ISBN, and provides a string representation of a book.

### BookstoreBook Class

The `BookstoreBook` class extends the `Book` class and represents a book in a bookstore. It includes additional information such as the price, sale status, and discount. The class provides methods to calculate the discounted price and generates a string representation of the bookstore book.

### LibraryBook Class

The `LibraryBook` class extends the `Book` class and represents a book in a library. It includes additional information such as the call number, floor number, and the number of books. The class provides methods to generate a call number and generates a string representation of the library book.

### BookList Class

The `BookList` class is responsible for managing a list of books. It includes methods to add both bookstore and library books to the list and to print a summary of all created books.

### Main Class

The `Main` class serves as the main program. It allows users to interactively create bookstore books and library books, provides details such as author, title, ISBN, and more. Users can choose to create multiple books and, at the end, view a summary of all created books, categorized as library books and bookstore books.

## Classes and Methods

### Book Class

- `public String getAuthor()`: Gets the author of the book.
- `public void setAuthor(String author)`: Sets the author of the book.
- `public String getTitle()`: Gets the title of the book.
- `public void setTitle(String title)`: Sets the title of the book.
- `public String getIsbn()`: Gets the ISBN of the book.
- `public void setIsbn(String isbn)`: Sets the ISBN of the book.
- `public String toString()`: Generates a string representation of the book.

### BookstoreBook Class

- `public double getPrice()`: Gets the list price of the book.
- `public void setPrice(double price)`: Sets the list price of the book.
- `public boolean isOnSale()`: Checks if the book is on sale.
- `public void setOnSale(boolean onSale)`: Sets the sale status of the book.
- `public double getDiscount()`: Gets the discount percentage of the book.
- `public void setDiscount(double discount)`: Sets the discount percentage of the book.
- `public double getNumBooks()`: Gets the total number of bookstore books.
- `public void setNumBooks(int numBooks)`: Sets the total number of bookstore books.
- `public double getDiscountedPrice()`: Calculates the discounted price of the book.
- `public String toString()`: Generates a string representation of the bookstore book.

### LibraryBook Class

- `public String getCallNumber()`: Gets the call number of the book.
- `public void setCallNumber(String callNumber)`: Sets the call number of the book.
- `public int getNumBooks()`: Gets the total number of library books.
- `public void setNumBooks(int numOfBooks)`: Sets the total number of library books.
- `public String toString()`: Generates a string representation of the library book.

### BookList Class

- `public void addBBBook(String author, String title, String isbn, double price, boolean onSale, double discount)`: Adds a new bookstore book to the list.
- `public void addLBBook(String author, String title, String isbn)`: Adds a new library book to the list.
- `public int getbookstoreBooks()`: Gets the total number of bookstore books.
- `public void addbookstoreBooks()`: Increments the total number of bookstore books.
- `public int getlibraryBooksNu()`: Gets the total number of library books.
- `public void addlibraryBooksNu()`: Increments the total number of library books.
- `public Book[] getList()`: Gets the list of books.
- `public void setList(Book[] list)`: Sets the list of books.
- `public void printList()`: Prints a summary of all created books, categorized as library books and bookstore books.

### Main Class

- `public static void main(String[] args)`: The main method to run the program. It allows users to interactively create bookstore books and library books, then displays a summary of all created books.

## Usage

1. **Compile the Program:**
   - Open a terminal and navigate to the directory containing the program files.
   - Compile the program using the following command:
     ```bash
     javac Main.java
     ```

2. **Run the Program:**
   - After compilation, run the program with the following command:
     ```bash
     java Main
     ```

3. **Interactive Input:**
   - Follow the on-screen prompts to create bookstore books and library books.
   - Provide details such as author, title, ISBN, and sale information.

4. **View Output:**
   - The program will display a summary of all created books, categorized as library books and bookstore books.

## Example

```bash
javac Main.java
java Main
