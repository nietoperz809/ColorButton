import javax.swing.*;
import java.awt.*;


/**
 * @author Administrator
 */
public class ColorToggleButton extends JButton {
    private Color _clOn = Color.green;
    private Color _clOff = Color.red;

    /**
     * Simulate Togglebutton behaviour
     */
    public ColorToggleButton() {
        super();
        addActionListener(e -> {
            if (isSelected())
                setSelected(false);
            else
                setSelected(true);
        });
    }

    /**
     * Constructor wirh colors
     * @param on
     * @param off
     */
    public ColorToggleButton(Color on, Color off) {
        this();
        setColors(on, off);
    }

    /**
     * set colors
     * @param on
     * @param off
     */
    public final void setColors(Color on, Color off) {
        _clOn = on;
        _clOff = off;
    }

    /**
     * Set optional handlers fror both states
     * @param on called when clicked
     * @param off called when released
     */
    public final void setHandlers(final ButtonAction on, final ButtonAction off) {
        addActionListener(e -> {
            if (isSelected())
                off.doIt();
            else
                on.doIt();
        });
    }

    /**
     * Do painting depending on state
     * @param g Paint context
     */
    @Override
    public void paintComponent(Graphics g) {
        if (isSelected()) {
            setBackground(_clOn);
            setBorder(BorderFactory.createLoweredBevelBorder());
        } else {
            setBackground(_clOff);
            setBorder(BorderFactory.createRaisedBevelBorder());
        }
        super.paintComponent(g);
    }

    @FunctionalInterface
    public interface ButtonAction {
        void doIt();
    }
}
