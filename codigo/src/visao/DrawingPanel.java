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
    private final String dirOut = "img/image.jpg";
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
        repaint();
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        int x = e.getX(), y = e.getY();

        BufferedImage bi = new BufferedImage(imagem.getIconWidth(), imagem.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage out = recortarImagem(bi, x, y);

        Graphics g = bi.createGraphics();
        imagem.paintIcon(null, g, 0, 0);
        g.dispose();
        File outputfile = new File(dirOut);
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

    private BufferedImage recortarImagem(BufferedImage bi, int x, int y) {
        if ((x > imagem.getIconWidth() && x1 > imagem.getIconWidth())
                || (y > imagem.getIconHeight() && y1 > imagem.getIconHeight())) {
            return bi;
        } else if (x > x1 && y > y1) {
            if (x > imagem.getIconWidth()) {
                x = imagem.getIconWidth();
            }
            if (y > imagem.getIconHeight()) {
                y = imagem.getIconHeight();
            }
            return bi.getSubimage(x1, y1, x - x1, y - y1);
        } else if (x > x1 && y < y1) {
            if (x > imagem.getIconWidth()) {
                x = imagem.getIconWidth();
            }
            if (y1 > imagem.getIconHeight()) {
                y1 = imagem.getIconHeight();
            }
            return bi.getSubimage(x1, y, x - x1, y1 - y);
        } else if (x < x1 && y > y1) {
            if (x1 > imagem.getIconWidth()) {
                x1 = imagem.getIconWidth();
            }
            if (y > imagem.getIconHeight()) {
                y = imagem.getIconHeight();
            }
            return bi.getSubimage(x, y1, x1 - x, y - y1);
        } else if (x < x1 && y < y1) {
            if (x1 > imagem.getIconWidth()) {
                x1 = imagem.getIconWidth();
            }
            if (y1 > imagem.getIconHeight()) {
                y1 = imagem.getIconHeight();
            }
            return bi.getSubimage(x, y, x1 - x, y1 - y);
        }
        return bi;
    }

}
