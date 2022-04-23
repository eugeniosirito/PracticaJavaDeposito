package ar.edu.ort.tp1.pacial2.clases;

public class Pelota extends Producto {

	private static final String LA_SUPERFICIE_NO_PUEDE_SER_NULA = "La superficie no puede ser nula";
	private static final String MSG_PELOTA = "La pelota para superficie %s es de la marca %s y tiene un id %d\n";
	
	private Superficie superficie;
	
	public Pelota(int id, String marca, Superficie superficie) throws DataIncorrectoException {
		super(id, marca);
		setSuperficie(superficie);
	}
	
	
	@Override
	public void mostrar() {
		 System.out.printf(MSG_PELOTA, superficie.getDescripcion(), super.getMarca(), super.getId());
	}
	
	public Superficie getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Superficie superficie) throws DataIncorrectoException {
		
		if(superficie == null) {
			throw new DataIncorrectoException(LA_SUPERFICIE_NO_PUEDE_SER_NULA);
		}
		
		this.superficie = superficie;
	}
	
	//TODO Completar
	
	
	


	
	
}
