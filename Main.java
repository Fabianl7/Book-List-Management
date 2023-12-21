import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		       
		BookList bookList = new BookList();  
		
		System.out.println("Welcome to the book program!\n");  
		String ans = "yes";
		while(ans.equals("yes")){           
			System.out.print("Would you like to create a book object? (yes/no): ");             
			ans = scanner.nextLine();
			            
			if(ans.equals("no")){ break; }
			
			ans = ans.toLowerCase();
			while(!ans.equals("yes")){              
				System.out.printf("I'm sorry but %s isn't a valid answer. Please enter either yes or no: ", ans);
				ans = scanner.nextLine();    
			}
			
			System.out.print("Please enter the author, title and the isbn of the book separated by /: ");                   
			String info = scanner.nextLine();           
		            
			String[] bookInfoArray = info.split("/");               
			String author = bookInfoArray[0];         
			String title = bookInfoArray[1];        
			String isbn = bookInfoArray[2];    
			
			System.out.println("Got it!");                       
			System.out.print("Now, tell me if the book is a bookstore book or a library book (BB/LB) (enter BB for bookstore book and LB for library book): ");
			String bookType = scanner.nextLine();             
			             
			while(!bookType.toUpperCase().equals("BB") && !bookType.toUpperCase().equals("LB")){              
				System.out.print("Oops! That's not a valid entry. Please try again: ");               
				bookType = (new Scanner(System.in)).nextLine();          
			}         
		
			System.out.println("Got it!");            
			
			title = title.toUpperCase();
			author = author.toUpperCase();
			
			if(bookType.toUpperCase().equals("BB")){
				System.out.print("Please enter the list price of " + title + " by " + author + ": ");              
				double price = scanner.nextDouble();           
				scanner.nextLine();
			                
				System.out.print("Is it on sale? (y/n): ");
				String saleStr = scanner.nextLine();
			                 
				boolean onSale = false;
				double discount = 0;
				if(saleStr.equals("y")){
					System.out.print("Deduction percentage: ") ;
					discount = scanner.nextDouble();
					scanner.nextLine();
					onSale = true;
				}
			
				System.out.println("Got it!");
			        
				bookList.addBBBook(author, title, isbn, price, onSale, discount);
			              
				System.out.println("\nHere is your bookstore book information: ");
				BookstoreBook tempBook = new BookstoreBook(author, title, isbn, price, onSale, discount);
				System.out.println(tempBook.toString()+"\n");
			                 
				} 
			else if(bookType.toUpperCase().equals("LB")){
				bookList.addLBBook(author, title, isbn);
			
				System.out.println("\nHere is your library book information: ");
				LibraryBook tempBook2 = new LibraryBook(author, title, isbn);
				System.out.println(tempBook2.toString()+"\n");
			             
			}
			
		}
		
		System.out.println("Sure!");
		System.out.println("\nHere are all your books...");
		bookList.printList();
		
		scanner.close();
	}
}

abstract class Book {
	private String author;
	private String title;
	private String isbn;
	
	public Book(String author, String title, String isbn) {
		this.author = author;
		this.title = title;
		this.isbn = isbn;
	}
	
	public Book(String author, String title) {
		this.author = author;
		this.title = title;
		this.isbn = "Not Available";
	}
	
	public Book(String author) {
		this.author = author;
		this.title = "Not Available";
		this.isbn = "Not Avaliable";
	}

	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getIsbn() { return isbn; }
	public void setIsbn(String isbn) { this.isbn = isbn; }

	public String toString() {
		return "[" + isbn + "-" + title + " by " + author;
	}
	
	
	
}

class BookstoreBook extends Book {
	private double price;
	private boolean onSale;
	private double discount;
	private static int numBooks = 0;
	
	public BookstoreBook(String author, String title, String isbn, double price, boolean onSale, double discount) {
		super(author, title, isbn);
		this.price = price;
		this.onSale = onSale;
		this.discount = discount;
		numBooks++;
	}
	
	public BookstoreBook(String author, String title, String isbn, double price) {
		super(author, title, isbn);
		this.price = price;
		this.onSale = false;
		this.discount = 0;
		numBooks++;
	}
	    
	public BookstoreBook(String author, String title, String isbn) {
		super(author, title, isbn);
		this.price = 0;
		this.onSale = false;
		this.discount = 0;
		numBooks++;
	}
	 
	public double getPrice() { return price; }      
	public void setPrice(double price) { this.price = price; }      
	  
	public boolean isOnSale() { return onSale; }      
	public void setOnSale(boolean onSale) { this.onSale = onSale; }      
	    
	public double getDiscount() { return discount; }         
	public void setDiscount(double discount) { this.discount = discount; }      
	  
	public double getNumBooks() { return numBooks; }         
	public void setNumBooks(int numBooks) { this.numBooks = numBooks; }
	
	public double getDiscountedPrice() { return price - (price * discount / 100); }      
	    
	public String toString(){             
		return super.toString() + ", $" + price + " listed for $" + getDiscountedPrice() + "]";     
	}  
	
}  

class LibraryBook extends Book {          
	private String callNumber;
	private static int numBooks, floorNumber;  
	
	public LibraryBook(String author, String title, String isbn) {
		super(author, title, isbn);
		floorNumber = (int)(Math.random() * (99 - 0) + 1);
		this.callNumber = callNumber();
		numBooks++;
	}
	
	public LibraryBook(String author, String title) {        
		super(author, title);
		floorNumber = (int)(Math.random() * (99 - 0) + 1);
		
		this.callNumber = callNumber();
		numBooks++;
	}
	    
	public LibraryBook(String author) {
		super(author);
		floorNumber = (int)(Math.random() * (99 - 0) + 1);
		
		this.callNumber = callNumber();
		numBooks++;
	}
	
	private String callNumber() {
		return floorNumber + "." + getAuthor().substring(0, 3) + "." + getIsbn().charAt(getIsbn().length() - 1);
	}
	
	public String getCallNumber() { return callNumber; }
	public void setCallNumber(String callNumber) { this.callNumber = callNumber; }
	
	public int getNumBooks() { return numBooks; }
	public void setNumBooks(int numOfBooks) { this.numBooks = numOfBooks; }
	
	public String toString(){
		return super.toString() + ", CALL NUMBER: " + callNumber + "]";
	}
}

class BookList {
	private Book[] list;
	private int bookstoreBooksNum, libraryBooksNum;
	
	public BookList() {
		list = new Book[100];	
	}
	
	public void addBBBook(String author, String title, String isbn, double price, boolean onSale, double discount) {
		for(int i = 0; i<100;i++) {
			if(list[i] == null)
			{
				list[i] = new BookstoreBook(author, title, isbn, price, onSale, discount);
				bookstoreBooksNum++;
				break;
			}
		}
	}
	
	public void addLBBook(String author, String title, String isbn) {
		for(int i = 0; i<100;i++) {
			if(list[i] == null)
			{
				list[i] = new LibraryBook(author, title, isbn);
				libraryBooksNum++;
				break;
			}
		}
	}
	
	public int getbookstoreBooks() { return bookstoreBooksNum; }
	public void addbookstoreBooks() { bookstoreBooksNum++; }
	
	public int getlibraryBooksNu() { return libraryBooksNum; }
	public void addlibraryBooksNu() { libraryBooksNum++; }
	
	public Book[] getList() { return list; }
	public void setList(Book[] list) { this.list = list; }

	public void printList() {
		System.out.println("Library Books (" + libraryBooksNum + ")");
		for(int i=0; i<list.length; i++)
		{
			if(list[i] instanceof LibraryBook) {
				LibraryBook book=(LibraryBook) list[i];
				System.out.println("\t" + book);
			}
		}
		
		System.out.println("------");
		
		System.out.println("Bookstore Books (" + bookstoreBooksNum + ")");
		for(int i=0; i<list.length; i++)
		{
			if(list[i] instanceof BookstoreBook) {
				BookstoreBook book=(BookstoreBook) list[i];
				System.out.println("\t" + book);
			}
		}
		System.out.println("------");
		System.out.println("Take care now!");
	}
}








 