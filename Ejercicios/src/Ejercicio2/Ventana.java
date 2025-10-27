package Ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);
		
		JMenuItem menuItemNuevo = new JMenuItem("Nuevo");
		menuArchivo.add(menuItemNuevo);
		
		JMenuItem menuItemAbrir = new JMenuItem("Abrir");
		menuArchivo.add(menuItemAbrir);
		
		JMenuItem menuItemSalir = new JMenuItem("Salir");
		menuArchivo.add(menuItemSalir);
		
		JMenu menuEditar = new JMenu("Editar");
		menuBar.add(menuEditar);
		
		JMenuItem menuItemCopiar = new JMenuItem("Copiar");
		menuEditar.add(menuItemCopiar);
		
		JMenuItem menuItemPegar = new JMenuItem("Pegar");
		menuEditar.add(menuItemPegar);
		
		JMenu menuFormato = new JMenu("Formato");
		menuBar.add(menuFormato);
		
		JMenuItem menuItemNegrita = new JMenuItem("Negrita");
		menuFormato.add(menuItemNegrita);
		
		JMenuItem menuItemCursiva = new JMenuItem("Cursiva");
		menuFormato.add(menuItemCursiva);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
