package proyectomultihilo;

import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
/**

 * Esta app con interfaz grafica recoge el numero de croquetas de cada tipo que quiere el cliente y mediante el ProcessBuilder al llamar a lanzar, se los pasa como args a la app procesadora 

 * @author: Miguel Puig Hernandez

 * @version: 12/11/2022
 */
public class LanzadoraVista {
    //Campos de la clase
	private JFrame frame;
	
	private ActionListener actionListenerJamon;
	private ActionListener actionListenerPollo;
	private ActionListener actionListenerBacalao;
	private ActionListener actionListenerQueso;
	private ActionListener actionListenerPedido;
	Integer numjamon=0,numpollo=0,numbacalao=0,numqueso=0,numtotal=0;

	/**
	 * Launch the application.
	 */
	public void lanzar(Integer n1,Integer n2,Integer n3,Integer n4,Integer n5) {
		String clase= "proyectomultihilo.Procesadora";
		try {
			String javaHome=System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" +File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(n1.toString());
			command.add(n2.toString());
			command.add(n3.toString());
			command.add(n4.toString());
			command.add(n5.toString());
			
			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			long startTime = System.currentTimeMillis();
			process.waitFor();
			long tiempo = System.currentTimeMillis() - startTime;

			JOptionPane.showMessageDialog(null,"Hemos tardado " + tiempo + " milisegundos");
			
		}catch( Exception e ){
			e.printStackTrace();
			
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LanzadoraVista window = new LanzadoraVista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LanzadoraVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 522, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnJamon = new JButton("Jamon ");
		btnJamon.setBounds(31, 42, 108, 23);
		frame.getContentPane().add(btnJamon);
		
		JButton btnPollo = new JButton("Pollo ");
		btnPollo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPollo.setBounds(149, 42, 110, 23);
		frame.getContentPane().add(btnPollo);
		
		JButton btnBacalao = new JButton("Bacalao ");
		btnBacalao.setBounds(269, 42, 107, 23);
		frame.getContentPane().add(btnBacalao);
		
		JButton btnQueso = new JButton("Queso ");
		btnQueso.setBounds(386, 42, 110, 23);
		frame.getContentPane().add(btnQueso);
		
		JButton btnPedido = new JButton("Realizar Pedido");
		btnPedido.setBounds(31, 93, 156, 23);
		frame.getContentPane().add(btnPedido);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 127, 444, 166);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		/**

	     * ActionListener para recoger el boton de jamon, sumar 1 en el tipo correspondiente  y mostrar el numero de croquetas del pedido actual


	     */
		actionListenerJamon = new ActionListener() {
			public void actionPerformed(ActionEvent jamon) {
				try {
						numjamon = numjamon + 1;
						numtotal = numtotal + 1;
						textArea.append(numjamon + " croquetas de jamon \n Total de croquetas: "+ numtotal + "\n");
						
				}catch( Exception e  ){
					e.printStackTrace();
				}
			}
		};
		btnJamon.addActionListener(actionListenerJamon);
		/**

	     * ActionListener para recoger el boton de pollo, sumar 1 en el tipo correspondiente  y mostrar el numero de croquetas del pedido actual


	     */
		actionListenerPollo = new ActionListener() {
			public void actionPerformed(ActionEvent pollo) {
				try {
						numpollo = numpollo + 1;
						numtotal = numtotal + 1;
						textArea.append(numpollo + " croquetas de pollo \n Total de croquetas: "+ numtotal + "\n");
				}catch( Exception e  ){
					e.printStackTrace();
				}
			}
		};
		btnPollo.addActionListener(actionListenerPollo);
		/**

	     * ActionListener para recoger el boton de bacalao , sumar 1 en el tipo correspondiente  y mostrar el numero de croquetas del pedido actual


	     */
		actionListenerBacalao = new ActionListener() {
			public void actionPerformed(ActionEvent bacalao) {
				try {
						numbacalao = numbacalao + 1;
						numtotal = numtotal + 1;
						textArea.append(numbacalao+ " croquetas de bacalao \n Total de croquetas: "+ numtotal + "\n");
				}catch( Exception e  ){
					e.printStackTrace();
				}
			}
		};
		btnBacalao.addActionListener(actionListenerBacalao);
		/**

	     * ActionListener para recoger el boton de queso , sumar 1 en el tipo correspondiente y mostrar el numero de croquetas del pedido actual


	     */
		actionListenerQueso = new ActionListener() {
			public void actionPerformed(ActionEvent queso) {
				try {
						numqueso = numqueso + 1;
						numtotal = numtotal + 1;
						textArea.append(numqueso+ " croquetas de queso \n Total de croquetas: "+ numtotal + "\n");
				}catch( Exception e  ){
					e.printStackTrace();
				}
			}
		};
		btnQueso.addActionListener(actionListenerQueso);
		/**

	     * ActionListener para recoger el boton de pedido , llamar a la funcion lanzar y mostrar el numero de croquetas del pedido actual


	     */
		
		actionListenerPedido = new ActionListener() {
			public void actionPerformed(ActionEvent pedido) {
				try {
					textArea.append(" \n \n"+numjamon + " croquetas de jamon \n "+numpollo + " croquetas de pollo \n "+numbacalao+ " croquetas de bacalao \n "+numqueso+ " croquetas de queso \n Total de croquetas: "+ numtotal + "\n");
					LanzadoraVista l = new LanzadoraVista();
					l.lanzar(numjamon,numpollo,numbacalao,numqueso,numtotal);
				}catch( Exception e  ){
					e.printStackTrace();
				}
			}
		};
		btnPedido.addActionListener(actionListenerPedido);
	}
}
