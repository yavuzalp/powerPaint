/*
 * ToolBarFrame TCSS 305
 */

/*
 * This example shows the combined use of Buttons, Actions, and ButtonGroups.
 */

package view;

import actions.AbstractToolsAction;
import actions.EllipseToolAction;
import actions.EraserToolAction;
import actions.HelpMenu;
import actions.LineToolAction;
import actions.OptionsAction;
import actions.PencilToolAction;
import actions.RectangleToolAction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * A frame that uses a menu bar and Toolbar to change colors.
 * 
 * @author Alan Fowler based on an original program by Cay Horstmann
 * @author Charles Bryan Added the Drawing Area panel to this JFrame
 * @version 1.5
 */
public class ToolBarFrame extends JFrame {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = -4447570618384470786L;

    /** A constant for the string "Exit". */
    private static final String EXIT_STRING = "Exit";

    /** The panel used inside the frame. */
    private final JPanel myPanel;

    /** The option action. */
    private List<Action> myOptionsActions;

    /** The exit action. */
    //private Action myHelpAction;

    /** A list of color actions. */
    private List<Action> myToolActions;

    // Constructor

    /**
     * Constructs a new ToolBarFrame with all its controls.
     */
    public ToolBarFrame() {
        super("Power Paint");
        
        myPanel = new DrawingArea();
        add(myPanel, BorderLayout.CENTER);
        
        setupActions(); // initializes myActions

        final JToolBar toolBar = createToolBar();
        add(toolBar, BorderLayout.SOUTH);
        
        setJMenuBar(new MyMenuBar(myOptionsActions, myPanel, myToolActions));
        pack();

    }

    /** 
     * Sets up all the Actions.
     */
    private void setupActions() {
    	myOptionsActions = new ArrayList<Action>();
    	
    	myOptionsActions.add(new OptionsAction("Primary Color", new ImageIcon(""), myPanel));

    	myOptionsActions.add(new OptionsAction("Secondary Color", new ImageIcon(""), myPanel));
    	
        myToolActions = new ArrayList<Action>();
        
        myToolActions.add(new PencilToolAction(new DrawingArea(), myPanel, new ImageIcon("./images/pencil.gif")));
        
        myToolActions.add(new LineToolAction(new DrawingArea(), myPanel, new ImageIcon("./images/line.gif")));
        
        myToolActions.add(new RectangleToolAction(new DrawingArea(), myPanel, new ImageIcon("./images/rectangle.gif")));
        
        myToolActions.add(new EllipseToolAction(new DrawingArea(), myPanel, new ImageIcon("./images/ellipse.gif")));
        
        myToolActions.add(new EraserToolAction(new DrawingArea(), myPanel, new ImageIcon("./images/eraser.gif")));
        
        //myHelpAction = new HelpMenu("About", new ImageIcon("./resources/w.gif"), this); 
        
        //myPanel.addPropertyChangeListener((PropertyChangeListener) myHelpAction);

    }

    /**
     * @return a fully-stocked tool bar.
     */
    private JToolBar createToolBar() {
        final JToolBar bar = new JToolBar();
//        bar.add(myExitAction);
//        bar.addSeparator();
        
        
        final ButtonGroup btngrp = new ButtonGroup();
        for (final Action ca : myToolActions) {
            final JToggleButton tb = new JToggleButton(ca);
            if(tb.getText().equals("Line")) {
            	tb.setSelected(true);
            }
            btngrp.add(tb);
            bar.add(tb);
        }
        
        //uncomment if you don't want any of the buttons selected on start.

        return bar;
    }

}