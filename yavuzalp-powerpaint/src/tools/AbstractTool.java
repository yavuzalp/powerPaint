package tools;

import java.awt.Shape;
import java.awt.geom.Point2D;

public abstract class AbstractTool {
    
    private Point2D myStartingPoint;
    private Point2D myEndingPoint;
    
    public AbstractTool(){
    }


    public abstract void setMyEndingPoint(Point2D theEndingPoint);

    public abstract void setMyStartingPoint(Point2D myStartingPoint);

//    public Point2D getMyEndingPoint() {
//        return myEndingPoint;
//    }
//
//    public Point2D getMyStartingPoint() {
//        return myStartingPoint;
//    }
//
//    public void setMyEndingPoint(Point2D theEndingPoint) {
//        myEndingPoint = theEndingPoint;
//    }
//
//    public void setMyStartingPoint(Point2D myStartingPoint) {
//        this.myStartingPoint = myStartingPoint;
//    }
//
//    public Point2D getMyEndingPoint() {
//        return myEndingPoint;
//    }
//
//    public Point2D getMyStartingPoint() {
//        return myStartingPoint;
//    }

	public abstract Shape getShape();
    
}