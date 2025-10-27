package JuegoDeBanderas;

import java.awt.Frame;

import javax.swing.Icon;
import javax.swing.JLabel;

public class LabelContador extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CONTADORTITULO = "Puntos: ";
	Frame frame;

	public LabelContador(Frame frame) {
		this.frame = frame;
	}

	public LabelContador(String text, Frame frame) {
		super(text);
		this.frame = frame;
	}

	public LabelContador(Icon image, Frame frame) {
		super(image);
		this.frame = frame;
	}

	public LabelContador(String text, int horizontalAlignment, Frame frame) {
		super(text, horizontalAlignment);
		this.frame = frame;
	}

	public LabelContador(Icon image, int horizontalAlignment, Frame frame) {
		super(image, horizontalAlignment);
		this.frame = frame;
	}

	public LabelContador(String text, Icon icon, int horizontalAlignment, Frame frame) {
		super(text, icon, horizontalAlignment);
		this.frame = frame;
	}
	
	public void Actualizar(int puntos)
	{
		this.setText(CONTADORTITULO + puntos);
	}

}
