package tools;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class RectangleTool extends AbstractTool {
    private Rectangle2D myRectangle;
    private Point2D myStartingPoint;
    private Point2D myEndingPoint;


    public RectangleTool() {
        super();
        myRectangle = new Rectangle2D.Double();
        
    }

    //@Override
    public Shape getShape() {
    	if(myStartingPoint!=null) {
	    	System.out.println("Start" + myStartingPoint.getX() + ", " + myStartingPoint.getY());
    	}
    	if(myEndingPoint!=null) {
	    	System.out.println("End" + myEndingPoint.getX() + ", " + myEndingPoint.getY());
    	}
    	return (Shape) myRectangle.clone();
    }
    
    //@Override
    public void setMyStartingPoint(final Point2D thePoint) {
    	myStartingPoint = (Point2D) thePoint.clone();
    	System.out.println("setStartPoint: " + myStartingPoint);
        //myLine = new Line2D.Double(myStartingPoint, myStartingPoint);
    	//myRectangle.setLine(myStartingPoint, myStartingPoint);
    	myRectangle.setFrame(new Rectangle2D.Double(myStartingPoint.getX(), myStartingPoint.getY(), 0, 0));
    }
    
    //@Override
    public void setMyEndingPoint(final Point2D thePoint) {
    	myEndingPoint = (Point2D) thePoint.clone();
    	System.out.println("setEndPoint: " + myEndingPoint);
    	myRectangle.setFrame(new Rectangle2D.Double(myStartingPoint.getX(), myStartingPoint.getY(), myEndingPoint.getX()-myStartingPoint.getX(), myEndingPoint.getY()-myStartingPoint.getY()));
    }

}