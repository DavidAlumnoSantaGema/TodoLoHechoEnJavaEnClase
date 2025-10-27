package JuegoDeBanderas;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BotonSeleccionarBandera extends JButton
{
	private static final long serialVersionUID = 1L;
	JFrame frame;

	public BotonSeleccionarBandera(JFrame frame)
	{
		super();
		this.frame = frame;
	}

	public BotonSeleccionarBandera(Icon icon, JFrame frame) {
		super(icon);
		this.frame = frame;
	}

	public BotonSeleccionarBandera(String text, JFrame frame) {
		super(text);
		this.frame = frame;
	}

	public BotonSeleccionarBandera(Action a, JFrame frame) {
		super(a);
		this.frame = frame;
	}

	public BotonSeleccionarBandera(String text, Icon icon, JFrame frame) {
		super(text, icon);
		this.frame = frame;
	}
	
	
	public void RespuestaEnviada(boolean acertada)
	{
		this.setEnabled(false);
		if (acertada)
		{
			((Main)frame).SumarYActualizarContador();
		}
	}

}
