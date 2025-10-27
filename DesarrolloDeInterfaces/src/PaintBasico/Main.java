package PaintBasico;

import java.awt.Color;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Canvas canvas;
	public JSlider sliderGrosor;
	public Color color = Color.BLACK;
	public ModoDeDibujo modoDeDibujo = ModoDeDibujo.DibujoLibre;
	
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
		
		JMenu menuFormaDibujo = new JMenu("Forma de dibujo");
		menuBar.add(menuFormaDibujo);
		
		JMenuItem menuItemDibujoLibre = new JMenuItem("Dibujo libre");
		menuItemDibujoLibre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				modoDeDibujo = ModoDeDibujo.DibujoLibre;
			}
		});
		menuFormaDibujo.add(menuItemDibujoLibre);
		
		JMenuItem menuItemLineaRecta = new JMenuItem("Linea recta");
		menuItemLineaRecta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				modoDeDibujo = ModoDeDibujo.LineaRecta;
			}
		});
		menuFormaDibujo.add(menuItemLineaRecta);
		
		JMenuItem menuItemCuadrado = new JMenuItem("Cuadrado");
		menuItemCuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				modoDeDibujo = ModoDeDibujo.Cuadrado;
			}
		});
		menuFormaDibujo.add(menuItemCuadrado);
		
		JMenuItem menuItemCirculo = new JMenuItem("Circulo");
		menuItemCirculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				modoDeDibujo = ModoDeDibujo.Circulo;
			}
		});
		menuFormaDibujo.add(menuItemCirculo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		canvas = new Canvas();
		canvas.setBounds(10, 107, 640, 297);
		canvas.frame = this;
		contentPane.add(canvas);
		
		sliderGrosor = new JSlider();
		sliderGrosor.setValue(5);
		sliderGrosor.setMinimum(1);
		sliderGrosor.setMaximum(20);
		sliderGrosor.setBounds(497, 66, 131, 26);
		contentPane.add(sliderGrosor);
		
		JLabel labelGrosor = new JLabel("Grosor");
		labelGrosor.setHorizontalAlignment(SwingConstants.CENTER);
		labelGrosor.setBounds(497, 11, 131, 33);
		contentPane.add(labelGrosor);
		
		JButton botonCambiarColor = new JButton("Cambiar color");
		botonCambiarColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			    JFrame frame = new JFrame();
			    frame.setSize(500, 500);
			    JColorChooser colorChooser = new JColorChooser();
			    colorChooser.setColor(color);
			    frame.getContentPane().add(colorChooser);
			    frame.addWindowListener(new WindowAdapter()
			    {
					@Override
					public void windowClosed(WindowEvent e)
					{
						Main.this.color = colorChooser.getColor();
					}
				});
			    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    frame.setVisible(true);
			}
		});
		botonCambiarColor.setBounds(21, 30, 167, 43);
		contentPane.add(botonCambiarColor);
	}
}
