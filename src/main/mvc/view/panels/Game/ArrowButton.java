package src.main.mvc.view.panels.Game;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 * This class is a JButton to create an arrow.
 * It paints an arrow on each direction.
 * @see JButton
 */
public class ArrowButton extends JButton {
    private final String arrow;
    private enum Direction {UP, DOWN, LEFT, RIGHT}

    ;

    /**
     * Constructor of the ArrowButton class.
     * It set the size of the button.
     * It set the direction of the arrow.
     * @param arrow Direction of the arrow.
     */
    public ArrowButton(String arrow) {
        this.arrow = arrow;
        setPreferredSize(new Dimension(100, 40));
    }

    /**
     * This method paints an arrow for each direction.
     * @param g Graphics object to paint.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        GeneralPath path = new GeneralPath();
        switch (Direction.valueOf(arrow.toUpperCase())) {
            case UP:
                path.moveTo((float) width / 2, 10);
                path.lineTo(width - 10, height - 10);
                path.lineTo(10, height - 10);
                path.closePath();
                break;
            case DOWN:
                path.moveTo(10, 10);
                path.lineTo(width - 10, 10);
                path.lineTo((float) width / 2, height - 10);
                path.closePath();
                break;
            case LEFT:
                path.moveTo(10, (float) height / 2);
                path.lineTo(width - 10, 10);
                path.lineTo(width - 10, height - 10);
                path.closePath();
                break;
            case RIGHT:
                path.moveTo(10, 10);
                path.lineTo(10, height - 10);
                path.lineTo(width - 10, (float) height / 2);
                path.closePath();
                break;
            default:
                break;
        }
        g2d.setColor(Color.BLACK);
        g2d.fill(path);
        g2d.dispose();
    }
}
