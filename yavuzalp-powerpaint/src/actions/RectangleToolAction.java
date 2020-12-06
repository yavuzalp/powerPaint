package actions;

import tools.AbstractTool;
import tools.LineTool;
import tools.RectangleTool;
import view.DrawingArea;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class RectangleToolAction extends AbstractAction {

    private static final Point2D.Double FIRST_POINT = new Point2D.Double(0, 0);


    private final DrawingArea myPanel;

    private final AbstractTool myTool;
    
    private final JComponent myComponent;

    public RectangleToolAction(final DrawingArea thePanel, final JComponent theComponent){
        super("Rectangle", new ImageIcon("./images/rectangle.gif"));
        myPanel = thePanel;
        myComponent = theComponent;
        myTool = (AbstractTool) new RectangleTool();
        myTool.setMyStartingPoint(FIRST_POINT);
        myTool.setMyEndingPoint(FIRST_POINT);
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_L);
        putValue(Action.SELECTED_KEY, false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("Rectangle is selected!");
    	myPanel.setTool((myTool));
        
    }

}