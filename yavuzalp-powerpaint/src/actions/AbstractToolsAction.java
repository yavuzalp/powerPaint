//package actions;
//
//import java.awt.Image;
//import java.awt.geom.Point2D;
//
//import javax.swing.Action;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JComponent;
//
//public abstract class AbstractToolsAction {
//    
//    private Point2D myStartingPoint;
//    private Point2D myEndingPoint;
//    
//    public AbstractToolsAction(final Point2D theStartingPoint, final Point2D theEndingPoint, final String theName, final Icon theIcon, final JComponent theComponent){
//        myStartingPoint = theStartingPoint;
//        myEndingPoint = theEndingPoint;
//        putKeys(theName, theIcon);
//    }
//
//
//    public void setMyEndingPoint(Point2D theEndingPoint) {
//        myEndingPoint = theEndingPoint;
//    }
//
//    public void setMyStartingPoint(Point2D theStartingPoint) {
//        myStartingPoint = theStartingPoint;
//    }
//
//    public Point2D getMyEndingPoint() {
//        return myEndingPoint;
//    }
//
//    public Point2D getMyStartingPoint() {
//        return myStartingPoint;
//    }
//    
//  /**
//  * Helper to set up the putValue for this action. 
//  * @param theName The name.
//  * @param theIcon The icon.
//  */
// private void putKeys(final String theName, final Icon theIcon) {
//     
//     // small icons are usually assigned to the menu
//     putValue(Action.SMALL_ICON, theIcon);
//     
//     // Here is how to assign a larger icon to the tool bar.
//     final ImageIcon icon = (ImageIcon) theIcon;
//     final Image largeImage =
//         icon.getImage().getScaledInstance(15, -1, java.awt.Image.SCALE_SMOOTH);
//     final ImageIcon largeIcon = new ImageIcon(largeImage);
//     putValue(Action.LARGE_ICON_KEY, largeIcon);
//     
//     // set a mnemonic on the first character of the name
//     putValue(Action.MNEMONIC_KEY,
//              KeyEvent.getExtendedKeyCodeForChar(theName.charAt(0)));
//     
//     // tool tips
//     putValue(Action.SHORT_DESCRIPTION, theName + " background");
//     
//     // coordinate button selection
//     putValue(Action.SELECTED_KEY, true); 
// }
//}
package actions;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * Sets the background of the panel to the specified color.
 * 
 * @author Charles Bryan
 * @version Autumn 2016
 */
public class AbstractToolsAction extends AbstractAction {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = 5378597116905801274L;
    
    /** The color to use. */
    //private final Color myColor;
    
    /** The component to work on in this action. */
    private final JComponent myComponent;

    /**
     * Constructs an action with the specified name and icon to set the
     * panel to the specified color.
     * 
     * @param theName The name.
     * @param theIcon The icon.
     * @param theColor The color.
     * @param theComponent The component to alter.
     */
    public AbstractToolsAction(final String theName, final Icon theIcon,
                final JComponent theComponent) {
        super(theName);
        
        myComponent = theComponent;
        
        //putKeys(theName, theIcon);
    }
    
    /**
     * Helper to set up the putValue for this action. 
     * @param theName The name.
     * @param theIcon The icon.
     */
    private void putKeys(final String theName, final Icon theIcon) {
        
        // small icons are usually assigned to the menu
        putValue(Action.SMALL_ICON, theIcon);
        
        
        // Here is how to assign a larger icon to the tool bar.
        final ImageIcon icon = (ImageIcon) theIcon;
        final Image largeImage =
            icon.getImage().getScaledInstance(15, -1, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon largeIcon = new ImageIcon(largeImage);
        putValue(Action.LARGE_ICON_KEY, largeIcon);
        
        // set a mnemonic on the first character of the name
        putValue(Action.MNEMONIC_KEY,
                 KeyEvent.getExtendedKeyCodeForChar(theName.charAt(0)));
        
        // tool tips
        //putValue(Action.SHORT_DESCRIPTION, theName + " background");
        
        // coordinate button selection
        putValue(Action.SELECTED_KEY, true); 
    }

    /**
     * Sets the panel to the specified color.
     * 
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        //myComponent.setBackground(myColor);
        
    }
}