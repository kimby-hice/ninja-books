/**
* @author Kimberly Hice
* @date May 25, 2012
* @description Creates a Shelf object intended to emulate a physical bookshelf. 
* A shelf object can hold a variable number of Book objects.  Books can be 
* added, edited, and removed from the shelf as needed.  Shelf has a default 
* capacity for 25 books that can be changed as needed, and shelves hold names
* so they can be differentiated.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.StringBuilder;


public class Shelf {
    private ArrayList<Book> books;
    private int capacity;
    private String name;

    /**
     * Creates a basic Shelf object with default capacity for 25 Book objects.
     * @param n (String) Name for this shelf
     */
    public Shelf(String n){
	this(n, 25);
    }

    /**
     * Creates a shelf object with specified capacity for number of Book objects
     * @param cap Capacity of shelf
     * @param n (String) Name for this shelf
     */
    public Shelf(String n, int cap){
	books = new ArrayList<Book>();
	capacity = cap;
	name = n;
    }

    /**
     * Returns current name for this Shelf object
     * @return (String) Name of shelf
     */
    public String getName(){
	return name;
    }

    /**
     * Sets the new name for this Shelf
     * @param newName New name for this shelf
     */
    public void setName(String newName){
	name = newName;
    }

    /**
     * Returns the number of Book objects the shelf presently holds
     * @return (int) Number of Book objects held by shelf
     */
    public int getSize(){
	return books.size();
    }

    /**
     * Returns the maximum capacity the shelf is set to
     * @return (int) Maximum number of Book objects the shelf will hold
     */
    public int getCapacity(){
	return capacity;
    }
	
    /**
     * Mimics pulling a book off a physical shelf, this method returns the Book 
     * object at a specific index
     * @param index Index number of Shelf object to return
     * @return Book object
     */
    public Book getBook(int index){
	return books.get(index);
    }

    /**
     * Saves modified information for an existing Book object
     * @param b Book object, presumably with new information
     * @param index Index number of Shelf object to modify
     */
    public void saveBook(Book b, int index){
	//edit book information for that index
	Book tempBook = b;
	books.get(index).setTitle(tempBook.getTitle());
	books.get(index).setAuthor(tempBook.getAuthor());
    }

    /**
     * Checks whether adding another Book object will exceed shelf capacity
     * @return (boolean) True if there is room to add another Book object
     */
    public boolean canAddBook(){
	return (books.size() < capacity); //if size is at cap, returns false
    }

    /**
     * Adds a new Book object to the shelf, provided there is room.  
     * If there is not room for another book, returns boolean value False to 
     * indicate failure.
     * @param b New Book object to add to shelf
     * @return (boolean) True if object was successfully added to shelf
     */
    public boolean addBook(Book b){
	//check if adding this book meets/exceeds capacity
	if(books.size() + 1 >= capacity){
	    return false;
	} else {
	    books.add(b);
	    return true;
	}
    }

    /**
     * Removes a specific Book object from the shelf. Returns a boolean False
     * if the specified index value was invalid.
     * @param index Index number of Shelf object to remove
     * @return (boolean) True if object was successfully removed from shelf
     */
    public boolean removeBook(int index){
	if(index < 0) {
	    return false;   //index out of bounds
	} else if(index >= books.size()){
	    return false;   //index out of bounds
	} else {
	    books.remove(index);
	    return true;
	}
    }

    /**
     * Uses private class BookTitleComparator to sort the Book objects by title
     */
    public void sortBooksByTitle(){
	Collections.sort(books, new BookTitleComparator()); 
    }

    /**
     * Uses private class BookAuthorComparator to sort the Book objects by author
     */
    public void sortBooksByAuthor(){
	Collections.sort(books, new BookAuthorComparator());
    }

    /**
     * Prints all the Book objects on the shelf.  If the shelf holds no Book
     * objects, returns a statement "Your bookshelf is empty."  If the shelf
     * holds multiple Book objects, they are printed in the following format:
     * Book object1, Book object2, Bookobject3
     * @return String representation of all Book objects on shelf
     */
    public String toString(){
	//StringBuilder is more efficient than String concatonation
	StringBuilder sb = new StringBuilder();
	Book tempBook;

	sb.append("Shelf ");
	sb.append(name);
	sb.append(": ");
	
	//return early if any books exist
	if(books.isEmpty()){
	    sb.append("This bookshelf is empty.");
	    return sb.toString();
	}
	
	//get first book
	tempBook = books.get(0);
	sb.append(tempBook);

	//formatting appropriate for subsequent books (fencepost)
	for(int i = 1; i < books.size(); i++){
	    tempBook = books.get(i);
	    sb.append(", ");
	    sb.append(tempBook);
	}

	return sb.toString(); 
    }

}

    /**
    * @author Kimberly Hice
    * @date May 25, 2012
    * @description Class to allow for custom sorting of Book objects by title.
    * Utilizes String.compareTo for efficiency.
    */
    class BookTitleComparator implements Comparator<Book> {
	@Override
	public int compare(Book o1, Book o2) {
	    return o1.getTitle().compareTo(o2.getTitle());
	}
    }

    /**
    * @author Kimberly Hice
    * @date May 25, 2012
    * @description Class to allow for custom sorting of Book objects by
    * author's name.  Utilizes String.compareTo for efficiency.
    */
    class BookAuthorComparator implements Comparator<Book> {
	@Override
	public int compare(Book o1, Book o2) {
	    return o1.getAuthor().compareTo(o2.getAuthor());
	}
    }
