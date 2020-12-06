package tools;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class EraserTool extends AbstractTool {
    private Line2D myLine;
    private Point2D myStartingPoint;
    private Point2D myEndingPoint;


    public EraserTool() {
        super();
        myLine = new Line2D.Double();
        
    }

    //@Override
    public Shape getShape() {
    	if(myStartingPoint!=null) {
	    	System.out.println("Start" + myStartingPoint.getX() + ", " + myStartingPoint.getY());
    	}
    	if(myEndingPoint!=null) {
	    	System.out.println("End" + myEndingPoint.getX() + ", " + myEndingPoint.getY());
    	}
    	return (Shape) myLine.clone();
    }
    
    //@Override
    public void setMyStartingPoint(final Point2D thePoint) {
    	myStartingPoint = (Point2D) thePoint.clone();
    	System.out.println("setStartPoint: " + myStartingPoint);
        //myLine = new Line2D.Double(myStartingPoint, myStartingPoint);
        myLine.setLine(myStartingPoint, myStartingPoint);
    }
    
    //@Override
    public void setMyEndingPoint(final Point2D thePoint) {
    	myEndingPoint = (Point2D) thePoint.clone();
    	System.out.println("setEndPoint: " + myEndingPoint);
        myLine.setLine(myStartingPoint, myEndingPoint);
    }

}