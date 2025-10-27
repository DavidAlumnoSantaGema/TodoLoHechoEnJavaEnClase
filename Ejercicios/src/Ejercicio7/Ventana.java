package Ejercicio7;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 230, 239);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Font selectedFont = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()[comboBox.getSelectedIndex()];
				Font realFont = new Font(selectedFont.getName(), selectedFont.getStyle(), 12);
				textArea.setFont(realFont);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(GetAllFontNames()));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(250, 13, 324, 22);
		contentPane.add(comboBox);
	}
	
	private String[] GetAllFontNames()
	{
		String[] names = new String[GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts().length];
		
		for (int i = 0; i < GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts().length; i++)
		{			
			names[i] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()[i].getName();
		}
		return names;
	}
}
