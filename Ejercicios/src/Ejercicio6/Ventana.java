package Ejercicio6;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int fontSize = 20;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 197);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JSpinner spinner = new JSpinner();
		spinner.getModel().setValue(fontSize);
		spinner.setBounds(10, 225, 103, 20);
		contentPane.add(spinner);
		
		JSlider slider = new JSlider();
		slider.setMinimum(1);
		slider.setValue(fontSize);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				fontSize = (int)slider.getValue();
				spinner.getModel().setValue(fontSize);
				
				String fontName = textArea.getFont().getFontName();
				int style = textArea.getFont().getStyle();
				textArea.setFont(new Font(fontName, style, fontSize));
			}
		});
		slider.setBounds(198, 224, 226, 26);
		contentPane.add(slider);
		
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				fontSize = (int)spinner.getModel().getValue();
				slider.setValue(fontSize);
				
				String fontName = textArea.getFont().getFontName();
				int style = textArea.getFont().getStyle();
				textArea.setFont(new Font(fontName, style, fontSize));
			}
		});
	}
}
