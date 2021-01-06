package assets;

import javax.swing.*;
import java.awt.*;

/**
 * Date and Times
 * SwingUtils.java
 *
 * Utilities for Swing classes.
 *
 * @author Henrik Berg
 * @version December 21, 2020
 */
public final class SwingUtils {
    /**
     * Method to add components in a GridBagLayout.
     *
     * @param panel the panel to add the component to.
     * @param component the component to add.
     * @param x the x coordinate of the component.
     * @param y the y coordinate of the component.
     * @param width the desired width of the component.
     * @param height the desired height of the component.
     * @param align the desired alignment of the component.
     */
    public static void addComponent(JPanel panel, JComponent component, int x,
                                    int y, int width, int height, int align) {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = 100.0;
        c.weighty = 100.0;
        c.insets = new Insets(5, 0, 5, 0);
        c.anchor = align;
        c.fill = GridBagConstraints.NONE;

        panel.add(component, c);
    }
}
