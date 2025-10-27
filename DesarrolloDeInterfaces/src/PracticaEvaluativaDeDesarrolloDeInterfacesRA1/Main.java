package PracticaEvaluativaDeDesarrolloDeInterfacesRA1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Canvas canvas;
	private ButtonGroup radios = new ButtonGroup();
	public JRadioButton radioNegro;
	public JRadioButton radioRojo;
	public JRadioButton radioAzul;
	public JSlider sliderGrosor;
	public JRadioButton radioBlanco;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 476);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);
		
		JMenuItem menuItemBorrar = new JMenuItem("Borrar lienzo");
		menuItemBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.LimpiarLienzo();
			}
		});
		menuArchivo.add(menuItemBorrar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		canvas = new Canvas();
		canvas.setBounds(10, 107, 640, 297);
		canvas.frame = this;
		contentPane.add(canvas);
		
		radioNegro = new JRadioButton("Negro");
		radioNegro.setSelected(true);
		radioNegro.setBounds(110, 51, 78, 23);
		radios.add(radioNegro);
		contentPane.add(radioNegro);
		
		radioRojo = new JRadioButton("Rojo");
		radioRojo.setBounds(30, 51, 78, 23);
		radios.add(radioRojo);
		contentPane.add(radioRojo);
		
		radioAzul = new JRadioButton("Azul");
		radioAzul.setBounds(30, 77, 78, 23);
		radios.add(radioAzul);
		contentPane.add(radioAzul);
		
		sliderGrosor = new JSlider();
		sliderGrosor.setValue(5);
		sliderGrosor.setMinimum(1);
		sliderGrosor.setMaximum(20);
		sliderGrosor.setBounds(497, 66, 131, 26);
		contentPane.add(sliderGrosor);
		
		JLabel labelColores = new JLabel("Colores");
		labelColores.setHorizontalAlignment(SwingConstants.CENTER);
		labelColores.setBounds(30, 11, 158, 33);
		contentPane.add(labelColores);
		
		JLabel labelGrosor = new JLabel("Grosor");
		labelGrosor.setHorizontalAlignment(SwingConstants.CENTER);
		labelGrosor.setBounds(497, 11, 131, 33);
		contentPane.add(labelGrosor);
		
		radioBlanco = new JRadioButton("Borrador");
		radioBlanco.setBounds(110, 77, 78, 23);
		radios.add(radioBlanco);
		contentPane.add(radioBlanco);
	}
}
