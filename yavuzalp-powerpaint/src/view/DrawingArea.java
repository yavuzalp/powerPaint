
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import model.ColorShape;
import model.UWColor;
import tools.AbstractTool;
import tools.LineTool;

/**
 * A Helper class for some examples.
 * 
 * @author Charles Bryan
 * @version Autumn 2015
 */
public class DrawingArea extends JPanel {

	/** A generated serial version UID for object Serialization. */
	private static final long serialVersionUID = 3316811765624525730L;

	/** The default width value. */
	private static AbstractTool myEmptyTool = new LineTool();
	
	private static AbstractTool myTool = new LineTool();
	/** The default width value. */
	private static final int WIDTH = 700;

	/** The default height value. */
	private static final int HEIGHT = 500;

	/** The squares starting center y. */
	private final ArrayList<ColorShape> myList;

	/** The default height value. */
	private final Color myColor;

	private final int myStroke;

	private Shape myShape;

//    static {
//        START_X = WIDTH / 2 - SQUARE_SIDE / 2;
//        START_Y = HEIGHT / 2 - SQUARE_SIDE / 2;
//    }

	/** The minimum size this component should be. */
	private static final Dimension MIN_SIZE = new Dimension(WIDTH, HEIGHT);

	/** Represents a square in the center of the area. */
	// private final Rectangle2D myHomeBase;

	/** The color for home base. */
	private Color myHomeBaseColor;

	/** The center point of the square drawn on the panel. */
	public Point myStartPoint;

	public Point myEndPoint;

	/**
	 * Constructs a BlankArea, ready for drawing.
	 * 
	 */
	public DrawingArea() {
		super();
		setBackground(Color.white);
		setOpaque(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		this.myList = new ArrayList<ColorShape>();
		this.myColor = UWColor.PURPLE.getColor();
		this.myStroke = 10;

		final MouseInputAdapter mia = new MyMouseInputAdapter();
		addMouseListener(mia);
		addMouseMotionListener(mia);
	}

	public void setTool(AbstractTool theTool) {
		myTool = theTool;
	}

	// paintComponent (no s at the end!) is the method you want to override
	// if you want to paint/draw on JCompenents. Use the Graphics context
	// passed in to draw or fill on this JComponent.
	//
	// Brief:
	// https://docs.oracle.com/javase/tutorial/uiswing/painting/index.html
	//
	// Detailed:
	// https://docs.oracle.com/javase/tutorial/2d/
	@Override
	protected void paintComponent(final Graphics theGraphics) {
		// MAKE SURE you call the parent paintComponenet
		super.paintComponent(theGraphics);
		//System.out.println(myTool);
		// cast Graphics object to the "newer-ish" Graphics2D class.
		final Graphics2D g2d = (Graphics2D) theGraphics;

		// for better graphics display
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		myList.forEach(each->{
//			g2d.setPaint(each.getMyColor());
//			g2d.setStroke(new BasicStroke(each.getMyStroke()));
//			try {
//				//System.out.println("Did it draw");
//				//System.out.println(each.toString());
//				System.out.println("Shape: ( " + each.getMyShape().getBounds().x + ", " + each.getMyShape().getBounds().y + " ), height: " + each.getMyShape().getBounds().height + ", width: " + each.getMyShape().getBounds().width);
//				g2d.draw(each.getMyShape());
//			} catch (Exception e) {
//				System.out.println(e);
//			}});
		for (ColorShape each : myList) {
			g2d.setPaint(each.getMyColor());
			g2d.setStroke(new BasicStroke(each.getMyStroke()));
			try {
				//System.out.println("Did it draw");
				//System.out.println(each.toString());
				System.out.println("Shape: ( " + each.getMyShape().getBounds().x + ", " + each.getMyShape().getBounds().y + " ), height: " + each.getMyShape().getBounds().height + ", width: " + each.getMyShape().getBounds().width);
				g2d.draw(each.getMyShape());
			} catch (Exception e) {
				System.out.println(e);
			}
//			try {
//				System.out.println("Did it fill");
//				System.out.println(each.toString());
//				g2d.fill(each.getMyShape());
//			} catch (Exception e) {
//				System.out.println(e);
//			}
		}
		System.out.println("List: " + myList.size());

	};

	@Override
	public Dimension getMinimumSize() {
		return MIN_SIZE;
	}

	@Override
	public Dimension getPreferredSize() {
		return MIN_SIZE;
	}

	/**
	 * Mouse Adapter to handle Mouse Events and move the square around.
	 * 
	 * @author Charles Bryan
	 */
	class MyMouseInputAdapter extends MouseInputAdapter {

		@Override
		public void mousePressed(final MouseEvent theEvent) {
			myStartPoint = getCenterPoint(theEvent);
			handlePress(theEvent.getPoint());
			repaint();
		}

		@Override
		public void mouseDragged(final MouseEvent theEvent) {
			// myCurrentPoint = getCenterPoint(theEvent);
//            checkLocation();
			Color tempColor = myList.get(myList.size()-1).getMyColor();
			int tempStroke = myList.get(myList.size()-1).getMyStroke();
			myTool.setMyEndingPoint(theEvent.getPoint());
			myList.set(myList.size()-1, new ColorShape(myTool.getShape(), tempColor, tempStroke));
			repaint();
		}

		@Override
		public void mouseReleased(final MouseEvent theEvent) {
			myEndPoint = getCenterPoint(theEvent);
			handleRelease(theEvent.getPoint());
			repaint();
		}

		/**
		 * Returns a new Point that is the center of the square based on the theEvent's
		 * point being the top left corner of the square.
		 * 
		 * @param theEvent the mouse event with the Point of the top left corner of the
		 *                 square
		 * @return a new Point that is the center of the square
		 */
		private Point getCenterPoint(final MouseEvent theEvent) {
			final int x = theEvent.getX();
			final int y = theEvent.getY();
			return new Point(x, y);
		}

		/**
		 * Helper to determine if the square is inside of home base.
		 */
		private void handlePress(Point theStartP) {
			myTool = myEmptyTool; 
			myTool.setMyStartingPoint(theStartP);
			myList.add(new ColorShape(myTool.getShape(), myColor, myStroke));
		}

		private void handleRelease(Point theEndP) {
			myTool.setMyEndingPoint(theEndP);
			myList.set(myList.size()-1, new ColorShape(myTool.getShape(), myColor, myStroke));
		}
	}

	/**
	 * Holds the non-swing properties of this class.
	 * 
	 * @author Charles Bryan
	 * @version Autumn 2016
	 */
	public final class Properties {

		/** The home property. */
		public static final String HOME = "home property";

		/**
		 * Private constructor to inhibit instantiation.
		 */
		private Properties() {
			throw new IllegalStateException();
		}

	}

}