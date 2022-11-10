package proyecto;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document; 
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;




public class Modelo {

	//Declaracion de las variables 
	//
	//Variable de conexion
	public Connection con;
	//Variable para el fichero xml
	private static String ficheroXML = "BBDD.xml";

	//Variable para saber si ha sido identificado primero
	public boolean Aceptado=false;
	
	

	//Funcion que carga el xml para obtener los datos de conexion para la base de datos
	public  void cargar () {
		String Url="";
		String Usuario="";
		String Pass="";
		
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document document = dBuilder.parse(new File(ficheroXML));
				NodeList nodeList = document.getElementsByTagName("BBDD");

				//Recoge los datos del xml 
				for(int i =0;i < nodeList.getLength();i++) {
					Node node=nodeList.item(i);
					Element eElement =(Element) node;
					 Url = eElement.getElementsByTagName("Url").item(0).getTextContent();
					 Usuario = eElement.getElementsByTagName("Usuario").item(0).getTextContent();
					Pass = eElement.getElementsByTagName("Pass").item(0).getTextContent();
				}

				
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Los anteriores datos guardados en las variables con sus nombres se 
				//usan para conectarse a la base de datos
				con = DriverManager.getConnection(Url,Usuario,Pass);
				Statement stmt = con.createStatement();
				JOptionPane.showMessageDialog(null," EXITO AL CARGAR!");
				stmt.close();
				 
				 
			}catch(Exception e) {
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),"Error al cargar",JOptionPane.ERROR_MESSAGE);
				
			}
	}
	//Funcion para identificarse con los datos de la base de datos
	//que habran sido recogidos por la clase vista en sus textfield
	public void Login(String Usuario,String Pass) {
		try {
		   Statement stmt = con.createStatement();
		 //guardamos en variables el usuario y contraseña de la bbdd
		   ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				 String usuarioX= rs.getString("user");
			       String PassX = rs.getString("pass");
			       if(usuarioX.equals(Usuario) && PassX.equals(Pass)) {
		    		   Aceptado = true;
		    		   JOptionPane.showMessageDialog(null," Bienvenido!");
			       }else {
			    	   
			       }
		       
				}
			if(Aceptado == false) {
				JOptionPane.showMessageDialog(null,"Credenciales erroneas");
			}
		   rs.close();
		   stmt.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),"ERROR AL CARGAR",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Funcion para cerrar la conexion 
	public void Cerrar() {
		try {
				con.close();
				  JOptionPane.showMessageDialog(null," Conexion finalizada");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(),"Error al cargar",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Gets para el uso de estas variables en la funcion controlador
	public boolean getAceptado() {
		return Aceptado;
	}
	public Connection getcon() {
		return con;
	}
}