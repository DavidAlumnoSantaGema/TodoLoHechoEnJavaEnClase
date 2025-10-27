package EditorDeTextosAccesoADatos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JCheckBoxMenuItem menuItemCheckboxNegrita;
	JCheckBoxMenuItem menuItemCheckboxCursiva;
	JTextArea textArea;
	JComboBox comboBox;
	JSpinner spinner;
	JLabel labelLength;
	
	
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Main()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 320);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);
		
		JMenuItem menuItemNuevo = new JMenuItem("Nuevo");
		menuItemNuevo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText(null);
			}
		});
		menuArchivo.add(menuItemNuevo);
		
		JMenuItem menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		menuArchivo.add(menuItemSalir);
		
		JMenu menuEstilo = new JMenu("Estilo");
		menuBar.add(menuEstilo);
		
		menuItemCheckboxNegrita = new JCheckBoxMenuItem("Negrita");
		menuItemCheckboxNegrita.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Main.this.TryDisableNegritaCheckbox(menuItemCheckboxNegrita.isSelected());
				updateFontStyle();
			}
		});
		menuEstilo.add(menuItemCheckboxNegrita);
		
		menuItemCheckboxCursiva = new JCheckBoxMenuItem("Cursiva");
		menuItemCheckboxCursiva.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TryDisableCursivaCheckbox(menuItemCheckboxNegrita.isSelected());
				updateFontStyle();
			}
		});
		menuEstilo.add(menuItemCheckboxCursiva);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSettings = new JPanel();
		panelSettings.setBackground(Color.LIGHT_GRAY);
		panelSettings.setBounds(0, 0, 464, 71);
		contentPane.add(panelSettings);
		panelSettings.setLayout(null);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(11), null, null, Integer.valueOf(1)));
		spinner.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				updateFontStyle();
			}
		});
		spinner.setBounds(200, 32, 50, 20);
		panelSettings.add(spinner);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				updateFontStyle();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(GetAllFontNames()));
		comboBox.setBounds(10, 31, 180, 22);
		panelSettings.add(comboBox);
		
		JLabel labelFuenteTitulo = new JLabel("Fuente");
		labelFuenteTitulo.setBounds(10, 11, 180, 14);
		panelSettings.add(labelFuenteTitulo);
		
		JLabel labelTamanoFuente = new JLabel("Tamaño letra");
		labelTamanoFuente.setHorizontalAlignment(SwingConstants.LEFT);
		labelTamanoFuente.setBounds(200, 11, 93, 14);
		panelSettings.add(labelTamanoFuente);
		
		labelLength = new JLabel("0, 1");
		labelLength.setHorizontalAlignment(SwingConstants.TRAILING);
		labelLength.setBounds(361, 46, 93, 14);
		panelSettings.add(labelLength);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 71, 464, 188);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 11));
		textArea.getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				UpdateCountLabel();	
			}

			@Override
			public void removeUpdate(DocumentEvent e)
			{
				UpdateCountLabel();				
			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				UpdateCountLabel();				
			}
		});
		scrollPane.setViewportView(textArea);
	}
	
	
	/**
	 * Desactiva el checkbox de cursiva si el checkbox de la negrita está activo
	 * @param bool El valor cambiado del checkbox
	 */
	private void TryDisableNegritaCheckbox(boolean bool)
	{
		//menuItemCheckboxNegrita.setSelected(bool);
		if (bool)
		{
			menuItemCheckboxCursiva.setSelected(false);
		}
	}
	
	
	/**
	 * Desactiva el checkbox de negrita si el checkbox de la cursiva está activo
	 * @param bool El valor cambiado del checkbox
	 */
	private void TryDisableCursivaCheckbox(boolean bool)
	{
		//menuItemCheckboxCursiva.setSelected(bool);
		if (bool)
		{
			menuItemCheckboxNegrita.setSelected(false);
		}
	}
	
	
	/** 
	 * @return Devuelve todos los nombres de familia de las fuentes cargadas del sistema
	 */
	private String[] GetAllFontNames()
	{
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	}
	
	
	/**
	 * Actualiza la fuente del textArea con los el nombre seleccionado en el comboBox,
	 * el estilo de fuente de los checkbox,
	 * y el tamaño del texto del spinner.
	 */
	private void updateFontStyle()
	{
		String fontName = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()[comboBox.getSelectedIndex()];
		
		Font font = new Font(fontName, GetFontStyle(), (int)spinner.getValue());
		textArea.setFont(font);
	}
	
	
	/**
	 * Devuelve el estilo dependiendo si las opciones de negrita o cursiva están activadas o no.
	 * @return 0 si no hay nada activo, 1 si está negrita activo, 2 si está cursiva activo
	 */
	private int GetFontStyle()
	{
		if (menuItemCheckboxNegrita.isSelected())
		{
			return 1;
		}
		else if (menuItemCheckboxCursiva.isSelected())
		{
			return 2;
		}
		else
		{
			return 0;
		}
	}
	
	
	/**
	 * Actualiza el mensaje que muestra la cuenta de caracteres y la cuenta de líneas.
	 */
	private void UpdateCountLabel()
	{
		String label = "";
		label += String.valueOf(textArea.getText().length()) + ", ";
		label += String.valueOf(textArea.getLineCount());
		labelLength.setText(label);
	}
}

