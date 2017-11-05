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
    private String dirIn, dirOut;
    private Icon imagem = new ImagemProxy(dirIn);
    private int x1, y1, x2, y2;

    public DrawingPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public String getDirIn() {
        return dirIn;
    }

    public void setDirIn(String dirIn) {
        this.dirIn = dirIn;
        imagem = new ImagemProxy(dirIn);
    }

    public String getDirOut() {
        return dirOut;
    }

    public void setDirOut(String dirOut) {
        this.dirOut = dirOut;
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
        x1 = e.getX();
        y1 = e.getY();
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
        x2 = e.getX();
        y2 = e.getY();
        repaint();
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        BufferedImage bi = new BufferedImage(imagem.getIconWidth(), imagem.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage out = recortarImagem(bi);

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

    private BufferedImage recortarImagem(BufferedImage bi) {
        if ((x2 > imagem.getIconWidth() && x1 > imagem.getIconWidth())
                || (y2 > imagem.getIconHeight() && y1 > imagem.getIconHeight())) {
            return bi;
        } else if (x2 > x1 && y2 > y1) {
            if (x2 > imagem.getIconWidth()) {
                x2 = imagem.getIconWidth();
            }
            if (y2 > imagem.getIconHeight()) {
                y2 = imagem.getIconHeight();
            }
            return bi.getSubimage(x1, y1, x2 - x1, y2 - y1);
        } else if (x2 > x1 && y2 < y1) {
            if (x2 > imagem.getIconWidth()) {
                x2 = imagem.getIconWidth();
            }
            if (y1 > imagem.getIconHeight()) {
                y1 = imagem.getIconHeight();
            }
            return bi.getSubimage(x1, y2, x2 - x1, y1 - y2);
        } else if (x2 < x1 && y2 > y1) {
            if (x1 > imagem.getIconWidth()) {
                x1 = imagem.getIconWidth();
            }
            if (y2 > imagem.getIconHeight()) {
                y2 = imagem.getIconHeight();
            }
            return bi.getSubimage(x2, y1, x1 - x2, y2 - y1);
        } else if (x2 < x1 && y2 < y1) {
            if (x1 > imagem.getIconWidth()) {
                x1 = imagem.getIconWidth();
            }
            if (y1 > imagem.getIconHeight()) {
                y1 = imagem.getIconHeight();
            }
            return bi.getSubimage(x2, y2, x1 - x2, y1 - y2);
        }
        return bi;
    }

}
