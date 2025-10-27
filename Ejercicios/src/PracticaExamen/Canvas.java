package PracticaExamen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	private BufferedImage imagen;
	private Graphics2D g2;
	// ----------
	private int xMin;
	private int yMin;
	private int xMax;
	private int yMax;

	public Canvas()
	{
		super();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (imagen == null)
		{
			this.imagen = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
			g2 = imagen.createGraphics();
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, this.getWidth(), this.getHeight());
			g2.setColor(Color.BLACK);
			
			g2.setStroke(new BasicStroke(1));
		}
		
		g.drawImage(imagen, 0, 0, null);
		
		int x = xMin;
		int y = yMax;
		int width = xMax - xMin;
		int height = yMax - yMin;
		((Graphics2D)g).drawOval(Math.min(xMin, xMax), Math.min(yMin, yMax), Math.abs(xMax - xMin), Math.abs(yMax - yMin));
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		xMax = e.getX();
		yMax = e.getY();
		
		
		
		this.repaint();
		
		//xMin = xMax;
		//yMin = yMax;
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		xMin = e.getX();
		yMin = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		g2.drawOval(Math.min(xMin, xMax), Math.min(yMin, yMax), Math.abs(xMax - xMin), Math.abs(yMax - yMin));
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{		
	}

}
