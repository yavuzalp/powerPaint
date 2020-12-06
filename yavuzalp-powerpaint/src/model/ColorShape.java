package model;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ColorShape{
    /** The default width value. */
    private final Shape myShape; 
    
       
    /** The default height value. */
    private final Color myColor;

    private final int myStroke;

    public ColorShape( final Shape theShape, final Color theColor, int theStroke){
    	myShape = theShape;
    	myColor = theColor;
    	myStroke = theStroke;
    }

	public Color getMyColor() {
		return myColor;
	}

	public int getMyStroke() {
		return myStroke;
	}


	public Shape getMyShape() {
		return myShape;
	}

    
}
