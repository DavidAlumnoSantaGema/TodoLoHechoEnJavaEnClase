package JuegoDeBanderas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int puntos = 0;
	LabelContador lblMarcador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMarcador = new LabelContador(this);
		lblMarcador.Actualizar(puntos);
		lblMarcador.setBackground(new Color(64, 0, 64));
		lblMarcador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarcador.setBounds(0, 0, 546, 38);
		contentPane.add(lblMarcador);
		
		JLabel lblBandera1 = new JLabel("");
		lblBandera1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera1.setBounds(0, 38, 274, 124);
		lblBandera1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Tarde\\eclipse-workspace\\DesarrolloDeInterfaces\\src\\JuegoDeBanderas\\andalucia.png").getImage().getScaledInstance(lblBandera1.getWidth(), lblBandera1.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblBandera1);
		
		JLabel lblBandera2 = new JLabel("");
		lblBandera1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera2.setBounds(272, 38, 274, 124);
		lblBandera2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Tarde\\eclipse-workspace\\DesarrolloDeInterfaces\\src\\JuegoDeBanderas\\catalunia.jpg").getImage().getScaledInstance(lblBandera2.getWidth(), lblBandera2.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblBandera2);
		
		BotonSeleccionarBandera buttonBandera1 = new BotonSeleccionarBandera("Adivinar", this);
		buttonBandera1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DialogoOpcionesBandera dialog = new DialogoOpcionesBandera("Extremadura", "Asturias", "Andalucia", 3, buttonBandera1);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		buttonBandera1.setForeground(new Color(0, 0, 0));
		buttonBandera1.setBounds(0, 162, 274, 50);
		contentPane.add(buttonBandera1);
		
		BotonSeleccionarBandera buttonBandera2 = new BotonSeleccionarBandera("Adivinar", this);
		buttonBandera2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DialogoOpcionesBandera dialog = new DialogoOpcionesBandera("Cataluña", "Castilla y León", "Valencia", 1, buttonBandera2);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		buttonBandera2.setForeground(Color.BLACK);
		buttonBandera2.setBounds(272, 162, 274, 50);
		contentPane.add(buttonBandera2);
		
		JLabel lblBandera3 = new JLabel("");
		lblBandera3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera3.setBounds(0, 211, 274, 124);
		lblBandera3.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Tarde\\eclipse-workspace\\DesarrolloDeInterfaces\\src\\JuegoDeBanderas\\extremadura.jpg").getImage().getScaledInstance(lblBandera3.getWidth(), lblBandera3.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblBandera3);
		
		BotonSeleccionarBandera buttonBandera3 = new BotonSeleccionarBandera("Adivinar", this);
		buttonBandera3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DialogoOpcionesBandera dialog = new DialogoOpcionesBandera("Islas Baleares", "Murcia", "Extremadura", 3, buttonBandera3);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		buttonBandera3.setForeground(Color.BLACK);
		buttonBandera3.setBounds(0, 335, 274, 50);
		contentPane.add(buttonBandera3);
		
		JLabel lblBandera4 = new JLabel("");
		lblBandera4.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandera4.setBounds(272, 211, 274, 124);
		lblBandera4.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Tarde\\eclipse-workspace\\DesarrolloDeInterfaces\\src\\JuegoDeBanderas\\galicia.png").getImage().getScaledInstance(lblBandera4.getWidth(), lblBandera4.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(lblBandera4);
		
		BotonSeleccionarBandera buttonBandera4 = new BotonSeleccionarBandera("Adivinar", this);
		buttonBandera4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DialogoOpcionesBandera dialog = new DialogoOpcionesBandera("Islas Canarias", "Galicia", "La Rioja", 2, buttonBandera4);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		buttonBandera4.setForeground(Color.BLACK);
		buttonBandera4.setBounds(272, 335, 274, 50);
		contentPane.add(buttonBandera4);
		
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e)
			{
				int salir = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres salir?", "Saliendo del juego", JOptionPane.YES_NO_OPTION);
				if (salir == JOptionPane.YES_OPTION)
				{
					
				}
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	public void SumarYActualizarContador()
	{
		puntos++;
		lblMarcador.Actualizar(puntos);
	}
}
