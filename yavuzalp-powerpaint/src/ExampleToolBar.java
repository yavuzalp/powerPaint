import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.ToolBarFrame;

/**
 * The driver for this application. 
 * 
 * @author Charles Bryan
 * @version Autumn 2016
 */
public final class ExampleToolBar {
    
    /**
     * Private constructor to inhibit instantiation.
     */
    private ExampleToolBar() {
        throw new IllegalStateException();
    }
    
    /**
     * Creates and makes visible a ToolBarFrame.
     * 
     * @param theArgs Command line arguments, ignored.
     */
    public static void main(final String... theArgs) {
        /* Use an appropriate Look and Feel */
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final ToolBarFrame toolbarFrame = new ToolBarFrame();
                toolbarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                toolbarFrame.setVisible(true);
                toolbarFrame.setIconImage(new ImageIcon("./resources/w.gif").getImage());
            }
        });
    }
}
