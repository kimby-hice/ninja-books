
/**
 * @author Kimberly Hice
 * @date May 25, 2012
 * @description Intended to emulate a human librarian, this class interacts with 
 * Shelf objects to view, modify, and sort Book objects on a shelf.
 * Librarian creates a GUI object to visually display books on the shelves.
 */
public class Librarian {

    /**
     * Program creates shelf objects, calls on method prepopulate to add Book
     * objects, manipulates Book objects to display ability to change, and then
     * calls GUI object to visually display books on shelves
     * @param args Not used
     */
    public static void main(String[] args) {
	Shelf shelf = new Shelf("Shelf 1");
	prepopulate(shelf);
	GUI shelfGUI = new GUI(shelf);

	shelf = new Shelf("Shelf 2");
	prepopulate(shelf);
	shelf.addBook(new Book("Some Ninja I Used to Know"));
	shelfGUI = new GUI(shelf);
    }

    /**
     * Adds several hard-coded Book objects to a shelf
     * @param useShelf Shelf to add Book objects to
     */
    private static void prepopulate(Shelf useShelf) {
	Book a = new Book("Lego Ninjago Read #1: Way of the Ninja", "Greg Farshtey");
	useShelf.addBook(a);
	a = new Book("The Nine Halls of Death: Ninja", "Haha Lung");
	useShelf.addBook(a);
	a = new Book("Ninjutsu: The Secret Art of the Ninja", "Simon Yeo");
	useShelf.addBook(a);
	a = new Book("The Mystic Arts of the Ninja", "Stephen K. Hayes");
	useShelf.addBook(a);
	a = new Book("Naruto: The Tests of the Ninja", "Masashi Kishimoto");
	useShelf.addBook(a);
	a = new Book("I Was an Eighth-Grade Ninja", "Andrew Simmons");
	useShelf.addBook(a);
	a = new Book("Secrets of the Ninja", "Ashida Kim");
	useShelf.addBook(a);
	a = new Book("Shoninki: The Secret Teachings of the Ninja", "Masazumi Natori");
	useShelf.addBook(a);
    }

}
