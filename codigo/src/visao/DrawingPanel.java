package visao;

import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author henik
 */
public class DrawingPanel extends JPanel implements MouseMotionListener, MouseListener {

    private Rectangle selection;
    private Point anchor;
    private final Toolkit tk = Toolkit.getDefaultToolkit();
    private final Dimension d = tk.getScreenSize();
    private final ImageIcon imagem = new ImageIcon("img/image.jpg");
    private final Image image = imagem.getImage().getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH);

    public DrawingPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension dDesktop = this.getSize();
        double width = dDesktop.getWidth();
        double height = dDesktop.getHeight();
        Image background = new ImageIcon(image.getScaledInstance((int) width, (int) height, 1)).getImage();
        g.drawImage(background, 0, 0, this);

        if (selection != null) {
            Graphics2D g2d = (Graphics2D) g;

            //set the stroke of the copy, not the original 
            Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2d.setStroke(dashed);
            g2d.draw(selection);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        anchor = e.getPoint();
        selection = new Rectangle(anchor);
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        selection.setBounds((int) Math.min(anchor.x, e.getX()), (int) Math.min(anchor.y, e.getY()),
                (int) Math.abs(e.getX() - anchor.x), (int) Math.abs(e.getY() - anchor.y));
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //selection = null;
        repaint();
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //
    }

}
