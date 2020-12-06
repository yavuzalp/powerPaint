package view;

import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

/**
 * Build a menu bar for this application. 
 * 
 * @author Charles Bryan
 * @version Autumn 2016
 */
public class MyMenuBar extends JMenuBar {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = -7819331691212802947L;

    /**
     * A fully-stocked menu bar.
     * @param theHelpAction the action for the exit menu item
     * @param theToolsActions the list of color actions for this menu. 
     */
    public  MyMenuBar(final List<Action> OptionsActions,
    				  final Action theHelpAction,
                      final List<Action> theToolsActions) {
        super();

        add(buildOptionsMenu(OptionsActions));
        add(buildToolsMenu(theToolsActions));
        add(buildHelpMenu(theHelpAction));
    }
    
    /**
     * Build the File JMenu. 
     * @param theOptionAction the action for the exit menu item
     * @return the file menu
     */
//    private JMenu buildOptionsMenu(final Action theExitAction) {
//        // setup the file menu
//        final JMenu fileMenu = new JMenu("Options");
//        fileMenu.setMnemonic(KeyEvent.VK_F);
//        
//        fileMenu.add(theExitAction);
//        return fileMenu;
//    }
    private JMenu buildOptionsMenu(final List<Action> theOptionAction) {
        // setup the file menu
        final JMenu optionMenu = new JMenu("Options");
        optionMenu.setMnemonic(KeyEvent.VK_F);
        optionMenu.add("Thickness");
        final ButtonGroup btngrp = new ButtonGroup();

        for (final Action ca : theOptionAction) {
            final JRadioButtonMenuItem btn = new JRadioButtonMenuItem(ca);
            btngrp.add(btn);
            optionMenu.add(ca);
        }
        return optionMenu;
    }
    
    /**
     * Build the File JMenu. 
     * @param theExitAction the action for the exit menu item
     * @return the file menu
     */
    private JMenu buildHelpMenu(final Action theHelpAction) {
        // setup the file menu
        final JMenu fileMenu = new JMenu("Help");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.addActionListener(theHelpAction);
        //fileMenu.add(theHelpAction);
        return fileMenu;
    }
    
    /**
     * Build the Color Menu.
     * @param theColorActions the list of color actions for this menu. 
     * @return the color menu.
     */
    private JMenu buildToolsMenu(final List<Action> theColorActions) {
        // setup the color menu
        final JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.setMnemonic(KeyEvent.VK_O);
        
        final ButtonGroup btngrp = new ButtonGroup();

        for (final Action ca : theColorActions) {
            final JRadioButtonMenuItem btn = new JRadioButtonMenuItem(ca);
            btngrp.add(btn);
            toolsMenu.add(btn);
        }
        return toolsMenu;
    }
}
