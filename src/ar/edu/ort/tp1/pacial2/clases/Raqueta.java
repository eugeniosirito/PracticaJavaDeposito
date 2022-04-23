package ar.edu.ort.tp1.pacial2.clases;

public class Raqueta extends Producto {
	
	private static final int TAMANIO_MAXIMO_RAQUETA = 120;
	private static final int TAMANIO_MINIMO_RAQUETA = 93;
	
	private static final String MSG_TAMANIO_ARO_INVALIDO = "Tamaño de aro inválido.";
	private static final String MSG_RAQUETA = 
			"La raqueta tiene un tamaño de aro %d es de la marca %s y tiene un id %d\n";
	
	private int tamanio;
	

	public Raqueta(int id, String marca, int tamanio) throws DataIncorrectoException {
		super(id, marca);
		setTamanio(tamanio);
	}

	
	@Override
	public void mostrar() {
		 System.out.printf(MSG_RAQUETA, tamanio, super.getMarca(), super.getId());
	}

	public int getTamanio() {
		return tamanio;
	}


	public void setTamanio(int tamanio) throws DataIncorrectoException {
		if(tamanio < TAMANIO_MINIMO_RAQUETA || tamanio > TAMANIO_MAXIMO_RAQUETA ) {
			throw new DataIncorrectoException(MSG_TAMANIO_ARO_INVALIDO);
		}
		
		this.tamanio = tamanio;
	}
	


	
}
