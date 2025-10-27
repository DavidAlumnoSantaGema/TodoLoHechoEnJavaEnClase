package PracticaEvaluativaDeDesarrolloDeInterfacesRA1;

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
	
	public Canvas()
	{
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	
	/**
	 * Creamos la BufferedImage aquí si no es nula, ya que las dimensiones del JPanel no existen al tiempo del constructor.
	 * También se encarga de mostrar la BufferedImage en la ventana.
	 */
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
	}

	/**
	 * Al arrastrar el ratón mientras que se mantiene el click, este método se encargará de:<br>
	 * 1. Actualizar el color antes de dibujar según que color esté seleccionado.<br>
	 * 2. Actualizar el tamaño según el valor del JSlider.<br>
	 * 3. Dibujar en la BufferedImage.<br>
	 * 4. Guardar las últimas coordenadas como el nuevo origen<br>
	 * 5. Provocar que la clase vuelva a dibujar la BufferedImage en la ventana.
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		xMax = e.getX();
		yMax = e.getY();
		
		g2.setColor(GetColor());
		g2.setStroke(new BasicStroke(frame.sliderGrosor.getValue()));
		g2.drawLine(xMin, yMin, xMax, yMax);
		
		xMin = xMax;
		yMin = yMax;
		
		repaint();
	}
	
	/**
	 * Al hacer click en la ventana, guardamos las coordenadas iniciales, dónde se ha empezado a hacer click.
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		xMin = e.getX();
		yMin = e.getY();
	}
	
	// ----- Me obliga a implementarlos, pero no tengo un uso para ninguno -----
	@Override
	public void mouseMoved(MouseEvent e) { }

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
	
	
	/**
	 * Dibuja un cuadrado blanco relleno en toda la imagen, encima de cualquier color que hubiera habido.
	 * Simula que se limpia la ventana.
	 */
	public void LimpiarLienzo()
	{
		Color curColor = g2.getColor();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, imagen.getWidth(), imagen.getHeight());
		g2.setColor(curColor);
		repaint();
	}
	
	/**
	 * Devuelve el color según el botón que se haya elegido entre negro, azul, rojo o borrador (color blanco).
	 * @return El color del botón seleccionado.
	 */
	private Color GetColor()
	{
		if (frame.radioNegro.isSelected())
		{
			return Color.BLACK;
		}
		if (frame.radioAzul.isSelected())
		{
			return Color.BLUE;
		}
		if (frame.radioRojo.isSelected())
		{
			return Color.RED;
		}
		if (frame.radioBlanco.isSelected())
		{
			return Color.WHITE;
		}
		return Color.black;
	}

}
