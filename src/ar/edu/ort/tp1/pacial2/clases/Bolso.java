package ar.edu.ort.tp1.pacial2.clases;

public class Bolso extends Producto {
	private static final String MODELO_DE_BOLSO_INVÁLIDO = "Modelo de bolso inválido.";
	private static final String MSG_MODELO = 
			"El bolso es de modelo %s es de la marca %s y tiene un id %d\n";

	private String modelo;
	
	public Bolso(int id, String marca, String modelo) throws DataIncorrectoException {
		super(id, marca);
		setModelo(modelo);
	}

	@Override
	public void mostrar() {
		 System.out.printf(MSG_MODELO, this.modelo, super.getMarca(), super.getId());
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) throws DataIncorrectoException {
		
		if(modelo == null || modelo.isEmpty()) {
			throw new DataIncorrectoException(MODELO_DE_BOLSO_INVÁLIDO);
		}
		
		this.modelo = modelo;
	}
	

		
}
