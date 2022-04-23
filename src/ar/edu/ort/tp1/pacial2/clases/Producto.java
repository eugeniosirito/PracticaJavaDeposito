package ar.edu.ort.tp1.pacial2.clases;

public abstract class Producto implements Mostrable {
	private static final String MSG_MARCA_INVALIDA = "La marca no puede ser nula ni vacía";
	private static final String MSG_ID_INVALIDO = "El id no puede ser menor a 1";

	private int id;
	private String marca;
	
	/**
	 * Constructor
	 * 
	 * @param id    debe ser mayor o igual a 1
	 * @param marca no ser nulo ni vacío.
	 * @throws IdIncorrectoException 
	 */
	public Producto(int id, String marca) throws DataIncorrectoException {
		setId(id);
		setMarca(marca);
	}
	
	
//	Pelota depositada id: 20

	@Override
	public void mostrar() {
		
		String mensaje = "";

		//opcion 1
		
		if (this instanceof Pelota) {
			mensaje = "Pelota";			
		}else if (this instanceof Raqueta) {
			mensaje = "Raqueta";			
		}else if (this instanceof Bolso) {
			mensaje = "Bolso";			
		}
		
		//opcion 2 
		// mensaje = this.getClass().getSimpleName();
		
		mensaje += " depositada id :" + this.id;

		System.out.println(mensaje);		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) throws DataIncorrectoException {
		
		if(id < 1) {
			throw new DataIncorrectoException(MSG_ID_INVALIDO);
		}
		
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) throws DataIncorrectoException {

		if(marca == null || marca.isEmpty() ) {
			throw new DataIncorrectoException(MSG_MARCA_INVALIDA);
		}
		
		this.marca = marca;
	}

	
		
//	Implementar las clases Producto, Raqueta, Pelota y Bolso aplicando las validaciones indicadas

	
}
