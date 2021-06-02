package edu.ieu.hilosjava;

public class CajeraThread extends Thread{
	private String nombre;
	private Cliente cliente;
	private long initialTime;
	
	public CajeraThread(String nombre, Cliente cliente, long initialTime) {
		super();
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}
		
	@Override
	public void run() {
		System.out.println("La cajera " + this.nombre + 
				" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() +
				" EN EL TIEMPO " + (System.currentTimeMillis() - initialTime ) / 1000 + 
				"segs"
				);
		for(int i=0; i < cliente.getCarroCompra().length; i++) {
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			System.out.println("Procesando el producto " + (i + 1) +
					" ->Tiempo: " + (System.currentTimeMillis() - initialTime ) / 1000 +
					"seg" );
		}
		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " +
		cliente.getNombre() + " EN EL TIEMPO: " + 
		(System.currentTimeMillis() - initialTime ) / 1000 + "segs");
	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000); 
		}catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}
	
	
	
}
