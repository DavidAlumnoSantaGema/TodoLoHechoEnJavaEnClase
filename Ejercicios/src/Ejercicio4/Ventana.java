package Ejercicio4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private static final String NOMBRE_USUARIO = "admin";
	private static final String PASSWORD = "1234";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombreUsuario;
	private JPasswordField passwordField;

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
		
		JLabel lblIniciarSesin = new JLabel("Iniciar sesión");
		lblIniciarSesin.setBounds(117, 10, 199, 22);
		lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesin.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblIniciarSesin);
		
		JLabel labelNombreUsuario = new JLabel("Nombre de usuario");
		labelNombreUsuario.setBounds(58, 108, 160, 14);
		contentPane.add(labelNombreUsuario);
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setBounds(228, 105, 160, 20);
		contentPane.add(textFieldNombreUsuario);
		textFieldNombreUsuario.setColumns(10);
		
		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setBounds(58, 139, 160, 14);
		contentPane.add(labelPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 136, 160, 20);
		contentPane.add(passwordField);
		
		JLabel labelOutput = new JLabel("");
		labelOutput.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutput.setBounds(58, 63, 330, 14);
		contentPane.add(labelOutput);
		
		JButton buttonLogIn = new JButton("Iniciar sesión");
		buttonLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				boolean nameMatches = textFieldNombreUsuario.getText().equals(NOMBRE_USUARIO);
				boolean passMatches = String.valueOf(passwordField.getPassword()).equals(PASSWORD);
				
				if (!nameMatches && !passMatches)
				{
					labelOutput.setText("El usuario y la password son incorrectos.");
				}
				else if (!nameMatches)
				{
					labelOutput.setText("El usuario introducido no es correcto.");
				}
				else if (!passMatches)
				{
					labelOutput.setText("La password introducida no es correcta.");
				}
				else
				{
					labelOutput.setText("Bienvenido.");
				}
			}
		});
		buttonLogIn.setBounds(125, 181, 160, 23);
		contentPane.add(buttonLogIn);
		

	}
}
