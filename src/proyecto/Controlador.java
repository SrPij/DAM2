package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
 

public class Controlador {
	
	//Declaracion de variables con los actionlistener para cada boton
	private Modelo modelo;
	private Vista vista;
	private ActionListener actionListenerCargar;
	private ActionListener actionListenerLogin;
	private ActionListener actionListenerDescribir;
	private ActionListener actionListenerSelect;
	private ActionListener actionListenerInsertar;
	private ActionListener actionListenerActualizar;
	private ActionListener actionListenerMostrar;
	private ActionListener actionListenerMostrarBBDD;
	private ActionListener actionListenerBorrar;
	private ActionListener actionListenerCerrar;
	
	public Controlador(Modelo modelo,Vista vista) {
		this.modelo=modelo;
		this.vista=vista;
		control();
		
	}
 public void control() {
	 
	//Llama a la funcion cargar de modelo
		actionListenerCargar = new ActionListener() {
			public void actionPerformed(ActionEvent cargar) {
				modelo.cargar();
			}
		};
		vista.getBtnCargar().addActionListener(actionListenerCargar);
	
	
		//Muestra la composicion de la base de datos de books en particular 
		actionListenerMostrarBBDD = new ActionListener() {
			public void actionPerformed(ActionEvent mostrarBBDD) {
				try {
					if(modelo.getAceptado()== true) {
						vista.getTextArea().setText("");
						Statement st = modelo.getcon().createStatement();
						ResultSet rs = st.executeQuery("select * from editorials");
						ResultSetMetaData rsmd = rs.getMetaData();
						int column_count = rsmd.getColumnCount();
						for (int i = 1; i <= column_count; i++) {
							vista.getTextArea().append("columna=" + rsmd.getTableName(i) + "." + rsmd.getColumnName(i) + " --> "+ rsmd.getColumnTypeName(i)+ "\n");
							}
						ResultSet rT = st.executeQuery("select * from titles");
						ResultSetMetaData rsmdt = rT.getMetaData();
						column_count = rsmdt.getColumnCount();
						for (int i = 1; i <= column_count; i++) {
							vista.getTextArea().append("columna=" + rsmdt.getTableName(i) + "." + rsmdt.getColumnName(i) + " --> "+ rsmdt.getColumnTypeName(i)+ "\n");
							}
						ResultSet ra = st.executeQuery("select * from authors");
						ResultSetMetaData rsmda = ra.getMetaData();
						column_count = rsmda.getColumnCount();
						for (int i = 1; i <= column_count; i++) {
							vista.getTextArea().append("columna=" + rsmda.getTableName(i) + "." + rsmda.getColumnName(i) + " --> "+ rsmda.getColumnTypeName(i)+ "\n");
							}
						rs.close();
						rT.close();
						ra.close();
						st.close();
						
					}else {
						JOptionPane.showMessageDialog(null,"Identificate primero");
					}		
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		};
		vista.getBtnMostrarBBDD().addActionListener(actionListenerMostrarBBDD);
		
		
		
		//Muestra la tabla escrita por el textfield de vista
		actionListenerMostrar = new ActionListener() {
			public void actionPerformed(ActionEvent mostrar) {
				try {
					if(modelo.getAceptado()== true) {
						vista.getTextArea().setText("");
						Statement stmt = modelo.getcon().createStatement();
						ResultSet rs = stmt.executeQuery("SELECT * FROM  " + vista.getTextTabla().getText());
						java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    int column_count = rsmd.getColumnCount();
						while(rs.next()) {
							for(int x =1 ; x <=column_count;x++ )
								vista.getTextArea().append(rs.getString(x)+ "\n");
							}
						rs.close();
						stmt.close();
					}else {
						JOptionPane.showMessageDialog(null,"Identificate primero");
					}		
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		};
		vista.getBtnMostrar().addActionListener(actionListenerMostrar);
		
		
		
		//Describe la tabla escrita en el textfield de vista
		actionListenerDescribir = new ActionListener() {
			public void actionPerformed(ActionEvent describir) {
				try {
					if(modelo.getAceptado()== true) {
						vista.getTextArea().setText("");
						Statement st = modelo.getcon().createStatement();
						ResultSet rs = st.executeQuery("select * from "+ vista.getTextTabla().getText());
						ResultSetMetaData rsmd = rs.getMetaData();
						int column_count = rsmd.getColumnCount();
						for (int i = 1; i <= column_count; i++) {
							vista.getTextArea().append("columna=" + rsmd.getTableName(i) + "." + rsmd.getColumnName(i) + " --> "+ rsmd.getColumnTypeName(i)+ "\n");
						}
						rs.close();
						st.close();
					}else {
						JOptionPane.showMessageDialog(null,"Identificate primero");
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		};
		vista.getBtnDescripcion().addActionListener(actionListenerDescribir);
	
		//Ejecuta y muestra el select escrito por el textfield
		actionListenerSelect = new ActionListener() {
			public void actionPerformed(ActionEvent select) {
				try {
					if(modelo.getAceptado()== true) {
						vista.getTextArea().setText("");
						Statement stmt = modelo.getcon().createStatement();
						ResultSet rs = stmt.executeQuery(vista.getTextSelect().getText());
						java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					    int column_count = rsmd.getColumnCount();
						while(rs.next()) {
							for(int x =1 ; x <=column_count;x++ )
								vista.getTextArea().append(rs.getString(x) + "\n");
								;
							}
						
						rs.close();
						stmt.close();
					}else {
						JOptionPane.showMessageDialog(null,"Identificate primero");
					}		
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		};
		vista.getBtnSelect().addActionListener(actionListenerSelect);
		
		
		//Ejecuta la orden introducida de insert del textfield
		actionListenerInsertar = new ActionListener() {
			public void actionPerformed(ActionEvent insertar) {
				try {
					if(modelo.getAceptado()== true) {
						int dialogo =JOptionPane.showConfirmDialog(null,"¿INSERTAR?");
						if(dialogo== 0) {
							vista.getTextArea().setText("");
							PreparedStatement rs = modelo.getcon().prepareStatement(vista.getTextInsertar().getText());
							int resultadoInsertar = rs.executeUpdate();
							rs.close();
							JOptionPane.showMessageDialog(null,"Numero de lineas afectadas: "+resultadoInsertar);
						}
					}else {
						JOptionPane.showMessageDialog(null,"Identificate primero");
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		};
		vista.getBtnInsertar().addActionListener(actionListenerInsertar);
		
		

		//Ejecuta la orden introducida de borrar del textfield
		actionListenerBorrar = new ActionListener() {
			public void actionPerformed(ActionEvent borrar) {
				try {
					if(modelo.getAceptado()== true) {
						int dialogo =JOptionPane.showConfirmDialog(null,"¿BORRAR?");
						if(dialogo== 0) {
							vista.getTextArea().setText("");
							PreparedStatement rs = modelo.getcon().prepareStatement(vista.getTextBorrar().getText());
							int resultadoBorrar = rs.executeUpdate();
							rs.close();
							JOptionPane.showMessageDialog(null,"Numero de lineas afectadas: "+resultadoBorrar);
						}
					}else {
						JOptionPane.showMessageDialog(null,"Identificate primero");
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		};
		vista.getBtnBorrar().addActionListener(actionListenerBorrar);
		
		

		//Ejecuta la orden introducida de update del textfield
		actionListenerActualizar = new ActionListener() {
			public void actionPerformed(ActionEvent actualizar) {
				try {
					if(modelo.getAceptado()== true) {
						int dialogo =JOptionPane.showConfirmDialog(null,"¿ACTUALIZAR?");
						if(dialogo== 0) {
							vista.getTextArea().setText("");
							PreparedStatement rs = modelo.getcon().prepareStatement(vista.getTextActualizar().getText());
							int resultadoActualizar = rs.executeUpdate();
							rs.close();
							JOptionPane.showMessageDialog(null,"Numero de lineas afectadas: "+resultadoActualizar);
						}
					}else {
						JOptionPane.showMessageDialog(null,"Identificate primero");
					}
					
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		};
		vista.getBtnActualizar().addActionListener(actionListenerActualizar);

		//Llama a la funcion login de modelo pasandole el usuario y contrseña que se le pasa de vista 
		actionListenerLogin = new ActionListener() {
			public void actionPerformed(ActionEvent login) {
				try {
					
					String Usuario = vista.getTextUsuario().getText(); 
					String Pass = vista.getTextContraseña().getText();
					modelo.Login(Usuario,Pass);
								
				}catch(Exception e){
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),"Error al identificarse",JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		vista.getBtnLogin().addActionListener(actionListenerLogin);
		

		//Llama a la funcion de cerrar de modelo 
		actionListenerCerrar = new ActionListener() {
			public void actionPerformed(ActionEvent cerrar) {
				try {
					int dialogo =JOptionPane.showConfirmDialog(null,"¿CERRAR CONEXION?");
					if(dialogo== 0) {
						vista.getTextArea().setText("");
						modelo.Cerrar();
					}
	
				}catch(Exception e){
					JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),"Error al cerrar conexion",JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		vista.getBtnCerrarconexion().addActionListener(actionListenerCerrar);
		
	}
}

