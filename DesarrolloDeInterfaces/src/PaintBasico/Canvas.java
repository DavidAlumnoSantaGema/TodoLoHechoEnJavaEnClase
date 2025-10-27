package PaintBasico;

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
	public Main frame;
	private BufferedImage imagen;
	private Graphics2D g2;
	private int xMin;
	private int yMin;
	private int xMax;
	private int yMax;
	private boolean dibujando = false;
	
	public Canvas()
	{
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (imagen == null)
		{
			imagen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
			g2 = imagen.createGraphics();
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());
			g2.setColor(Color.BLACK);
		}
		
		g.drawImage(imagen, 0, 0, null);
		
		if (dibujando)
		{
			PreviewFigure(g);
		}
	}
	
	
	private void PreviewFigure(Graphics g)
	{
		g.setColor(GetColor());
		((Graphics2D)g).setStroke(new BasicStroke(frame.sliderGrosor.getValue()));
		
		switch (GetModoDeDibujo())
		{
			case DibujoLibre:
			default:
				break;
			case LineaRecta:
				g.drawLine(xMin, yMin, xMax, yMax);
				break;
			case Circulo:
				{
					int x = Math.min(xMin, xMax);
					int y = Math.min(yMin, yMax);
					int width = Math.abs(xMax - xMin);
					int height = Math.abs(yMax - yMin);
					g.drawOval(x, y, width, height);
				}
				break;
			case Cuadrado:
				{
					int x = Math.min(xMin, xMax);
					int y = Math.min(yMin, yMax);
					int width = Math.abs(xMax - xMin);
					int height = Math.abs(yMax - yMin);
					g.drawRect(x, y, width, height);
				}
				break;
		}
	}


	@Override
	public void mouseDragged(MouseEvent e)
	{
		g2.setColor(GetColor());
		g2.setStroke(new BasicStroke(frame.sliderGrosor.getValue()));
		
		switch (GetModoDeDibujo())
		{
			case DibujoLibre:
			default:
				xMax = e.getX();
				yMax = e.getY();
				

				g2.drawLine(xMin, yMin, xMax, yMax);
				
				xMin = xMax;
				yMin = yMax;
			break;
			case LineaRecta:
			case Circulo:
			case Cuadrado:
				xMax = e.getX();
				yMax = e.getY();
				break;
		}

		
		repaint();
	}

	
	@Override
	public void mousePressed(MouseEvent e)
	{
		dibujando = true;
		xMin = e.getX();
		yMin = e.getY();
	}
	
	// ----- Me obliga a implementarlos, pero no tengo un uso para ninguno -----
	@Override
	public void mouseMoved(MouseEvent e) { }

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e)
	{
		dibujando = false;
		switch (GetModoDeDibujo())
		{
			case DibujoLibre:
			default:
				break;
			case LineaRecta:
				g2.drawLine(xMin, yMin, xMax, yMax);
				break;
			case Circulo:
				{
					int x = Math.min(xMin, xMax);
					int y = Math.min(yMin, yMax);
					int width = Math.abs(xMax - xMin);
					int height = Math.abs(yMax - yMin);
					g2.drawOval(x, y, width, height);
				}
				break;
			case Cuadrado:
				{
					int x = Math.min(xMin, xMax);
					int y = Math.min(yMin, yMax);
					int width = Math.abs(xMax - xMin);
					int height = Math.abs(yMax - yMin);
					g2.drawRect(x, y, width, height);
				}
				break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
	

	public void LimpiarLienzo()
	{
		Color curColor = g2.getColor();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());
		g2.setColor(curColor);
		repaint();
	}
	
	
	private ModoDeDibujo GetModoDeDibujo()
	{
		return frame.modoDeDibujo;
	}
	

	private Color GetColor()
	{
		return frame.color;
	}

}
