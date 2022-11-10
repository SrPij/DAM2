package proyecto;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.TextArea;
import javax.swing.JScrollPane;

public class Vista {
	
//Declaracion de las variables
	private JFrame frame;
	private JTextField textUsuario;
	private JTextField textSelect;
	private JTextField textInsertar;
	private JTextField textActualizar;
	private JTextField textBorrar;
	private JTextField textTabla;
	private JButton btnLogin;
	private JButton btnInsertar;
	private JButton btnSelect;
	private JButton btnBorrar;
	private JButton btnActualizar;
	private JButton btnCargar;
	private JButton btnDescripcion;
	private JButton btnMostrar;
	private JButton btnMostrarBBDD;
	private TextArea textArea;
	private JTextField textContraseña;
	private JButton btnCerrarconexion;
	
	
	
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(122, 39, 86, 20);
		frame.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(119, 101, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Usuario");
		lblNewJgoodiesLabel.setBounds(20, 42, 92, 14);
		frame.getContentPane().add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Contraseña");
		lblNewJgoodiesLabel_1.setBounds(20, 73, 92, 14);
		frame.getContentPane().add(lblNewJgoodiesLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 140, 808, 342);
		frame.getContentPane().add(scrollPane);
		
		textArea = new TextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Gestion de datos");
		lblNewJgoodiesTitle.setBounds(248, 17, 92, 14);
		frame.getContentPane().add(lblNewJgoodiesTitle);
		
		textSelect = new JTextField();
		textSelect.setBounds(347, 39, 86, 20);
		frame.getContentPane().add(textSelect);
		textSelect.setColumns(10);
		
		textInsertar = new JTextField();
		textInsertar.setBounds(347, 70, 86, 20);
		frame.getContentPane().add(textInsertar);
		textInsertar.setColumns(10);
		
		textActualizar = new JTextField();
		textActualizar.setBounds(536, 39, 86, 20);
		frame.getContentPane().add(textActualizar);
		textActualizar.setColumns(10);
		
		textBorrar = new JTextField();
		textBorrar.setBounds(536, 70, 86, 20);
		frame.getContentPane().add(textBorrar);
		textBorrar.setColumns(10);
		
		btnCargar = new JButton("Cargar XML");
		btnCargar.setBounds(58, 5, 150, 23);
		frame.getContentPane().add(btnCargar);
		
		JLabel lblNewLabel_3 = new JLabel("Tabla");
		lblNewLabel_3.setBounds(650, 17, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textTabla = new JTextField();
		textTabla.setBounds(705, 39, 86, 20);
		frame.getContentPane().add(textTabla);
		textTabla.setColumns(10);
		
		 btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(659, 69, 89, 23);
		frame.getContentPane().add(btnMostrar);
		
		 btnDescripcion = new JButton("Descripcion");
		btnDescripcion.setBounds(757, 69, 89, 23);
		frame.getContentPane().add(btnDescripcion);
		
		 btnMostrarBBDD = new JButton("Mostrar BBDD");
		btnMostrarBBDD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMostrarBBDD.setBounds(48, 495, 114, 23);
		frame.getContentPane().add(btnMostrarBBDD);
		
		 btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelect.setBounds(248, 38, 89, 23);
		frame.getContentPane().add(btnSelect);
		
		 btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInsertar.setBounds(248, 69, 89, 23);
		frame.getContentPane().add(btnInsertar);
		
		 btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(443, 38, 89, 23);
		frame.getContentPane().add(btnActualizar);
		
		 btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(443, 69, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		textContraseña = new JTextField();
		textContraseña.setColumns(10);
		textContraseña.setBounds(122, 70, 86, 20);
		frame.getContentPane().add(textContraseña);
		
		btnCerrarconexion = new JButton("Cerrar Conexion");
		btnCerrarconexion.setBounds(201, 495, 139, 23);
		frame.getContentPane().add(btnCerrarconexion);
		frame.setVisible(true);
	}


	//GETS y SETS para las varables anteriormente declaradas
	public JTextField getTextUsuario() {
		return textUsuario;
	}



	public JTextField getTextSelect() {
		return textSelect;
	}
	public JButton getSelect() {
		return btnSelect;
	}


	public JTextField getTextInsertar() {
		return textInsertar;
	}


	public JTextField getTextActualizar() {
		return textActualizar;
	}


	public JTextField getTextBorrar() {
		return textBorrar;
	}


	public JTextField getTextTabla() {
		return textTabla;
	}

	public JTextField getTextContraseña() {
		return textContraseña;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	
	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	
	public JButton getBtnSelect() {
		return btnSelect;
	}

	
	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	

	public JButton getBtnCargar() {
		return btnCargar;
	}

	

	public JButton getBtnDescripcion() {
		return btnDescripcion;
	}
	public JButton getBtnCerrarconexion() {
		return btnCerrarconexion;
	}

	public JButton getBtnMostrar() {
		return btnMostrar;
	}

	

	public JButton getBtnMostrarBBDD() {
		return btnMostrarBBDD;
	}

	public TextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}
}
