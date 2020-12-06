package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.DrawingArea;

/**
 * Creates exit/close actions. 
 * 
 * @author Charles Bryan
 * @version Autumn 2016
 */
public class HelpMenu extends AbstractAction implements PropertyChangeListener {

    /** A generated serialization ID. */
    private static final long serialVersionUID = -3641127125217134863L;
    
    /** The window this action closes. */
    private final JFrame myWindow;
    
    //private final JOptionPane myPane;
    
    private final Icon myIcon;
    /**
     * Constructs an action with the specified name and icon to set the
     * panel to the specified color.
     * 
     * @param theName The name.
     * @param theIcon The icon.
     * @param theWindow The window to close.
     */
    public HelpMenu(final String theName, final Icon theIcon, final JFrame theWindow) {
        super(theName);
        
        myWindow = theWindow;
        
        putValue(Action.SMALL_ICON, theIcon);
        
        // Here is how to assign a larger icon to the tool bar.
        final ImageIcon icon = (ImageIcon) theIcon;
        final Image largeImage =
            icon.getImage().getScaledInstance(60, -1, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon largeIcon = new ImageIcon(largeImage);
        putValue(Action.LARGE_ICON_KEY, largeIcon);
        putValue(Action.SMALL_ICON, largeIcon);
        myIcon = new ImageIcon(largeImage);
        // set a mnemonic on the first character of the name
        putValue(Action.MNEMONIC_KEY,
                 KeyEvent.getExtendedKeyCodeForChar(theName.charAt(0)));
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
    	System.out.println("Clicked" + theEvent.ACTION_PERFORMED);
    	JOptionPane.showMessageDialog(myWindow, "<Your Name>\n Autumn 2020\n TCSS 305 Assignment 4", "About", 0, myIcon);
        // do NOT call System.exit()
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if (DrawingArea.Properties.HOME.equals(theEvent.getPropertyName())) {
            setEnabled((Boolean) theEvent.getNewValue());
            JOptionPane.showMessageDialog(myWindow, "Printing complete");
        }
        
    }
}
