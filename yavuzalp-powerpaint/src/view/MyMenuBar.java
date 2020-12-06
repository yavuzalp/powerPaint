package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Build a menu bar for this application. 
 * 
 * @author Charles Bryan
 * @version Autumn 2016
 */
public class MyMenuBar extends JMenuBar {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = -7819331691212802947L;

    private static final int sliderSpacingA= 1;
    
    private static final int sliderSpacingB= 5;
    
    private static JSlider myJSlider;
    /**
     * A fully-stocked menu bar.
     * @param theHelpAction the action for the exit menu item
     * @param theToolsActions the list of color actions for this menu. 
     */
    public  MyMenuBar(final List<Action> OptionsActions,
    				  final JPanel myPanel,
                      final List<Action> theToolsActions) {
        super();

        add(buildOptionsMenu(OptionsActions, myPanel));
        add(buildToolsMenu(theToolsActions));
        add(buildHelpMenu(myPanel));
    }
    
    /**
     * Build the File JMenu. 
     * @param theOptionAction the action for the exit menu item
     * @param myPanel 
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
    private JMenu buildOptionsMenu(final List<Action> theOptionAction, JPanel myPanel) {
        // setup the file menu
        final JMenu optionMenu = new JMenu("Options");
        optionMenu.setMnemonic(KeyEvent.VK_F);
        JMenu thickness = new JMenu("Thickness");
        myJSlider=new JSlider(0, 20, 10);
        myJSlider.setMinorTickSpacing(1);
        myJSlider.setMajorTickSpacing(5);
        myJSlider.setPaintTicks(true);
        myJSlider.setPaintLabels(true);
        myJSlider.addChangeListener(
        		new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						System.out.println(myJSlider.getValue());
						((DrawingArea) myPanel).setStroke(myJSlider.getValue());
						
					}
        			
        		}
        		);
        thickness.add(myJSlider);
        optionMenu.add(thickness);
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
    private JMenu buildHelpMenu(final JPanel thePanel) {
        // setup the file menu
        final JMenu fileMenu = new JMenu("Help");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                System.out.println("menuSelected");
                JOptionPane.showMessageDialog(thePanel, "<Your Name>\n Autumn 2020\n TCSS 305 Assignment 4",
                		"About", 0, new ImageIcon((new ImageIcon("./resources/w.gif").getImage().getScaledInstance(60, -1, java.awt.Image.SCALE_SMOOTH))));
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("menuDeselected");

            }

            @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("menuCanceled");

            }

        });
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
