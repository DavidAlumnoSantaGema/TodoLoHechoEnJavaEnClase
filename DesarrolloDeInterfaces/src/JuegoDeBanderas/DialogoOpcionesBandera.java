package JuegoDeBanderas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoOpcionesBandera extends JDialog
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton[] radios = new JRadioButton[3];
	JRadioButton botonRadio1;
	JRadioButton botonRadio2;
	JRadioButton botonRadio3;
	BotonSeleccionarBandera boton;
	int correctOption;

	/**
	 * Create the dialog.
	 */
	public DialogoOpcionesBandera(String opcion1, String opcion2, String opcion3, int correctOption, BotonSeleccionarBandera boton)
	{
		this.correctOption = correctOption;
		this.boton = boton;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel labelTitulo = new JLabel("Elige la comunidad autonoma a la que pertenece esta bandera");
			labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitulo.setBounds(10, 11, 414, 30);
			contentPanel.add(labelTitulo);
		}
		
		botonRadio1 = new JRadioButton(opcion1);
		buttonGroup.add(botonRadio1);
		botonRadio1.setBounds(155, 48, 109, 23);
		contentPanel.add(botonRadio1);
		radios[0] = botonRadio1;
		
		botonRadio2 = new JRadioButton(opcion2);
		buttonGroup.add(botonRadio2);
		botonRadio2.setBounds(155, 87, 109, 23);
		contentPanel.add(botonRadio2);
		radios[1] = botonRadio2;
		
		botonRadio3 = new JRadioButton(opcion3);
		buttonGroup.add(botonRadio3);
		botonRadio3.setBounds(155, 127, 109, 23);
		contentPanel.add(botonRadio3);
		radios[2] = botonRadio3;
		
		{
			JButton botonAceptar = new JButton("Aceptar");
			botonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					if (CheckSelection())
					{
						JOptionPane.showMessageDialog(botonAceptar, "¡Correcto!", "Respuesta correcta", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(botonAceptar, "¡Incorrecto!", "Respuesta incorrecta", JOptionPane.ERROR_MESSAGE);
					}
					DialogoOpcionesBandera.this.dispose();
				}
			});
			botonAceptar.setBounds(155, 157, 109, 30);
			contentPanel.add(botonAceptar);
			botonAceptar.setActionCommand("OK");
			getRootPane().setDefaultButton(botonAceptar);
		}
		{
			JButton botonCancelar = new JButton("Cancelar");
			botonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					DialogoOpcionesBandera.this.dispose();
				}
			});
			botonCancelar.setBounds(155, 198, 109, 30);
			contentPanel.add(botonCancelar);
			botonCancelar.setActionCommand("Cancel");
		}
	}
	
	public boolean CheckSelection()
	{
		boolean acertado = radios[correctOption - 1].isSelected();
		
		if (boton != null)
		{
			boton.RespuestaEnviada(acertado);
		}
		return acertado;
	}
	
}
