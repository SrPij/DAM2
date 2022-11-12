package proyectomultihilo;



import javax.swing.JOptionPane;
/**

 * Esta app sin interfaz grafica con el numero de croquetas de cada tipo que quiere el cliente crea una croqueta(hilo) de el tipo especificado y los lanza  

 * @author: Miguel Puig Hernandez

 * @version: 12/11/2022
 */
public class Procesadora {
	public static void main(String[] args) {
		//Campos de la clase que recibe de argumentos
		Procesadora p = new Procesadora();
		int numjamon =Integer.parseInt(args[0]);
		int numpollo =Integer.parseInt(args[1]);
		int numbacalao =Integer.parseInt(args[2]);
		int numqueso =Integer.parseInt(args[3]);
		int numtotal =Integer.parseInt(args[4]);
		//Llamada a procesar y muestra mensaje de empezar
		p.Procesar(numjamon, numpollo, numbacalao, numqueso, numtotal);
		JOptionPane.showMessageDialog(null,"Ha Cocinar!! ");
	}
	
	/**

     * Funcion que crea hilos y los lanza de tipo croqueta

     * @param numerojamon El parámetro numerojamon define el número de elementos que se van a crear del tipo jamon
     * @param numeropollo El parámetro numeropollo define el número de elementos que se van a crear del tipo pollo
     * @param numerobacalao El parámetro numerobacalao define el número de elementos que se van a crear del tipo bacalao
     * @param numeroqueso El parámetro numeroqueso define el número de elementos que se van a crear del tipo queso

     */
		public void Procesar(int numjamon,int numpollo,int numbacalao,int numqueso,int numtotal) {
			
			
			Pedido pedido = new Pedido(numtotal);
			Croqueta[] Freidora= new Croqueta[numtotal];
			Thread t1 = null;
			Thread t2 = null;
			Thread t3 = null;
			Thread t4 = null;

				

				int x=0;
				for(int i =0;i<numjamon;i++) {
					Croqueta j = new Croqueta(pedido,"jamon",numjamon);
					Freidora[x] = j;
					t1 = new Thread(j);
					x++;
					numjamon=numjamon -1;
					numtotal=numtotal -1;
					t1.start();
				}
				for(int i= 0;i<numpollo;i++) {
					Croqueta p = new Croqueta(pedido,"pollo",numpollo);
					Freidora[x] = p;
					t2 = new Thread(p);
					t2.start();
					x++;
					numpollo=numpollo -1;
					numtotal=numtotal -1;
	
					}
				for(int i= 0;i<numbacalao;i++) {
					Croqueta b = new Croqueta(pedido,"bacalao",numbacalao);
					Freidora[x] = b;
					t3 = new Thread(b);
					t3.start();
					x++;	
					numbacalao = numbacalao-1;
					numtotal=numtotal -1;
					}
				for(int i= 0;i<numqueso;i++) {
					Croqueta q = new Croqueta(pedido,"queso",numqueso);
					Freidora[x] = q;
					t4 = new Thread(q);
					t4.start();
					x++;
					numqueso =numqueso-1;
					numtotal=numtotal -1;
								
				}
			
				
		}	
}

	
	