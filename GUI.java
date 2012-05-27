
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* @author Kimberly Hice
* @date May 25, 2012
* @description Creates a new JFrame to display all Book objects on a specified
* Shelf object
*/
public class GUI {

    /**
     * Creates a new JFrame pop up, displays Book objects on specified Shelf
     * @param useShelf Shelf to make a display for
     */
    public GUI(Shelf useShelf) {
	final Shelf tempShelf = useShelf;
	final JFrame frame = new JFrame(tempShelf.getName());

	int height = 450;
	int width = 300;
	frame.setSize(width, height);
	// Get the size of the default screen
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	int centerx = (int)screen.getWidth()/2;
	int centery = (int)(int)screen.getHeight()/2;
	// Make frame pop up in middle of screen
	frame.setLocation((centerx - width/2),(centery - height/2));
	// Set default frame behavior
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Add sorting buttons
	JPanel optionsPanel = new JPanel();
	//Sort by Title
	JButton sortByTitle = new JButton("Sort by Title");
	sortByTitle.setActionCommand("sortTitle");
	optionsPanel.add(sortByTitle);
	//Sort by Author
	JButton sortByAuthor = new JButton("Sort by Author");
	sortByAuthor.setActionCommand("sortAuthor");
	optionsPanel.add(sortByAuthor);
	frame.add(optionsPanel, BorderLayout.SOUTH);

	//Add books
	JPanel bookPanel = new DrawBooks(useShelf);
	frame.add(bookPanel, BorderLayout.CENTER);

	//Make the buttons sort this specific shelf and frame only
	sortByTitle.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e) {
		tempShelf.sortBooksByTitle();
		frame.repaint();
	    }
	});
	sortByAuthor.addActionListener((new ActionListener(){
	    public void actionPerformed(ActionEvent e) {
		tempShelf.sortBooksByAuthor();
		frame.repaint();
	    }
	}));

	frame.setVisible(true);
    }

    /**
    * @author Kimberly Hice
    * @date May 25, 2012
    * @description Class used to draw the book titles of Book objects on a given
    * Shelf.  Graphics are used so the titles can be rotated to mimic book spines.
    */
    public static class DrawBooks extends JPanel {
	private Shelf thisShelf;

	public DrawBooks(Shelf s){
	    thisShelf = s;
	}

	@Override
	public void paint(Graphics g) {
	    //initial starting point, pre-rotation
	    Point startingPoint = new Point(30, getHeight() - 30);

	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setFont(new Font("serif", Font.PLAIN, 15));
	    //rotate counterclockwise 90 degrees
	    g2d.rotate(-Math.PI / 2.0);

	    for (int i = 0; i < thisShelf.getSize(); i++) {
		g2d.drawString(thisShelf.getBook(i).toString(),
			(startingPoint.y * -1), //inverse points due to rotation
			startingPoint.x + (i * 25)); //avoid titles drawn on top of each other
	    }
	}
    }
}
