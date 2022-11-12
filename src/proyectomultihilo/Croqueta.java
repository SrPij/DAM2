package proyectomultihilo;

/**

 * Esta clase define objetos croqueta que contienen tantos enteros como croquetas de su tipo , string definiendo su tipo y un objeto pedido que es el recurso compartido 

 * @author: Miguel Puig Hernandez

 * @version: 12/11/2022

 */
public class Croqueta implements Runnable {
    //Campos de la clase
	private Pedido pedido1;
	private String tipo;
	int num;
	
    //Constructor
	Croqueta(Pedido pedido1,String tipo,int num){
		this.pedido1=pedido1;
		this.tipo = tipo;
		this.num =num;
	}
	/**

	 * Esta funcion que es llamada desde run identifica que tipo de croqueta es y la pone a esperar los segundos de cocinado puestos para cada tipo

	 */
	public void cocinar() {
		while(pedido1.getTotal()>0) {
			synchronized(pedido1) {
				switch(this.tipo) {
				
				case "jamon":
					if(pedido1.getTotal()>0 && num >0) {
						try {
							System.out.println("Empieza hacer una croqueta de jamon");
							Thread.sleep(5000);
							System.out.println("Acaba de hacerse una croqueta de jamon");
							pedido1.setTotal(pedido1.getTotal() - 1);
							num= num -1;
							
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					break;
					
					
					
				case "pollo":
					if(pedido1.getTotal()>0 && num >0) {
						try {
							System.out.println("Empieza hacer una croqueta de pollo");
							Thread.sleep(6000);
							System.out.println("Acaba de hacerse una croqueta de pollo");
							pedido1.setTotal(pedido1.getTotal() - 1);
							
							num= num -1;
							
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					break;
					
					
					
					
				case "bacalao":
					if(pedido1.getTotal()>0 && num >0) {
						try {
							System.out.println("Empieza hacer una croqueta de bacalao");
							Thread.sleep(7000);
							System.out.println("Acaba de hacerse una croqueta de bacalao");
							pedido1.setTotal(pedido1.getTotal() - 1);
							num= num -1;
							
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					break;
					
				case "queso":
					if(pedido1.getTotal()>0 && num >0) {
						try {
							System.out.println("Empieza hacer una croqueta de queso");
							Thread.sleep(8000);
							System.out.println("Acaba de hacerse una croqueta de queso");
							pedido1.setTotal(pedido1.getTotal() - 1);
							num= num -1;
							
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					break;
					
					
				}
				
			}
			
		}
		
		
	}

	public Pedido getPedido1() {
		return pedido1;
	}
	public void setPedido1(Pedido pedido1) {
		this.pedido1 = pedido1;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		cocinar();
	}
}