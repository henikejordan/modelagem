package visao;

import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JPanel;
import modelo.ImagemProxy;

/**
 *
 * @author henik
 */
public class DrawingPanel extends JPanel implements MouseMotionListener, MouseListener {

    private Rectangle selection;
    private Point anchor;
    private String dir;
    private Icon imagem = new ImagemProxy(dir);
    private int x1, y1;

    public DrawingPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
        imagem = new ImagemProxy(dir);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        imagem.paintIcon(this, g, 0, 0);

        //desenhar o retângulo
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
        x1 = e.getX();
        y1 = e.getY();
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

        BufferedImage bi = new BufferedImage(imagem.getIconWidth(), imagem.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage out;
        if (e.getX() > x1 && e.getY() > y1) {
            out = bi.getSubimage(x1, y1, e.getX() - x1, e.getY() - y1);
        } else if (e.getX() > x1 && e.getY() < y1) {
            out = bi.getSubimage(x1, e.getY(), e.getX() - x1, y1 - e.getY());
        } else if (e.getX() < x1 && e.getY() > y1) {
            out = bi.getSubimage(e.getX(), y1, x1 - e.getX(), e.getY() - y1);
        } else {
            out = bi.getSubimage(e.getX(), e.getY(), x1 - e.getX(), y1 - e.getY());
        }
        Graphics g = bi.createGraphics();
        imagem.paintIcon(null, g, 0, 0);
        g.dispose();
        File outputfile = new File("img/image.jpg");
        try {
            ImageIO.write(out, "jpg", outputfile);
        } catch (IOException ex) {
            //
        }
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
