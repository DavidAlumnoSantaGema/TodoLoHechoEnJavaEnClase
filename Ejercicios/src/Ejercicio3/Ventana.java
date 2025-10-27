package Ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<String> checkboxesActivos = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Selecciona una marca");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(81, 11, 244, 14);
		contentPane.add(labelTitulo);
		
		JCheckBox checkboxToyota = new JCheckBox("Toyota");
		checkboxToyota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				TryAddCheckboxToList(checkboxToyota);
			}
		});
		checkboxToyota.setBounds(24, 87, 97, 23);
		contentPane.add(checkboxToyota);
		
		JCheckBox checkboxHonda = new JCheckBox("Honda");
		checkboxHonda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				TryAddCheckboxToList(checkboxHonda);
			}
		});
		checkboxHonda.setBounds(24, 113, 97, 23);
		contentPane.add(checkboxHonda);
		
		JCheckBox checkboxTesla = new JCheckBox("Tesla");
		checkboxTesla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				TryAddCheckboxToList(checkboxTesla);	
			}
		});
		checkboxTesla.setBounds(24, 139, 97, 23);
		contentPane.add(checkboxTesla);
		
		JLabel labelSeleccion = new JLabel("");
		labelSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeleccion.setBounds(180, 87, 244, 14);
		contentPane.add(labelSeleccion);
		
		JButton buttonComprobar = new JButton("Comprobar selección");
		buttonComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				switch (checkboxesActivos.size())
				{
					case 0:
						labelSeleccion.setText("No hay ninguna marca seleccionada");
						break;
					case 1:
						labelSeleccion.setText("Has seleccionado " + checkboxesActivos.get(0));
						break;
					case 2:
						labelSeleccion.setText("Has seleccionado " + checkboxesActivos.get(0) + " y " + checkboxesActivos.get(1));
						break;
					case 3:
						labelSeleccion.setText("Has seleccionado " + checkboxesActivos.get(0) + ", " + checkboxesActivos.get(1) + " y " + checkboxesActivos.get(2));
						break;
					default:
						labelSeleccion.setText("Error");
						break;
				}
			}
		});
		buttonComprobar.setBounds(180, 139, 244, 23);
		contentPane.add(buttonComprobar);
	}
	
	private void TryAddCheckboxToList(JCheckBox cb)
	{
		if (cb.isSelected())
		{
			checkboxesActivos.add(cb.getText());
		}
		else
		{
			checkboxesActivos.remove(cb.getText());
		}
	}
}
