/**
* @author Kimberly Hice
* @date May 25, 2012
* @description Creates a Book object to emulate a physical book. 
*/

import java.lang.StringBuilder;

public class Book {
    private String title;
    private String authorsName;

    /**
     * Creates a basic Book object with only a title
     * @param n Title of the book
     */
    public Book(String n){
	this(n, "");
    }

    /**
     * Creates a Book object with an author
     * @param n Title of the book
     * @param an Author of the book
     */
    public Book(String n, String an){
	title = n;
	authorsName = an;
    }

    /**
     * Retrieve title of the book
     * @return (String) Title of book
     */
    public String getTitle(){
	return title;
    }

    /**
     * Change or set the title of the book
     * @param n New title for the book
     */
    public void setTitle(String n){
	title = n;
    }

    /**
     * Retrieve author of the book
     * @return (String) Author's name
     */
    public String getAuthor(){
	return authorsName;
    }

    /**
     * Change or set the author of the book
     * @param an New author for the book
     */
    public void setAuthor(String an){
	authorsName = an;
    }

    /**
     * Prints name of the book in the following format:
     * "Title"
     * If author's name is present, it is appended as follows:
     * "Title" by Author's name
     * @return String representation of book information
     */
    public String toString(){
	//StringBuilder is more efficient than String concatonation
	StringBuilder sb = new StringBuilder();
	sb.append("\"");
	sb.append(title);
	sb.append("\"");
	if(authorsName.isEmpty() == false){
	    sb.append(" by ");
	    sb.append(authorsName);
	}
	return sb.toString();
    }
}
