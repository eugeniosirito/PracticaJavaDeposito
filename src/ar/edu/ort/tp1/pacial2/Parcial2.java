package ar.edu.ort.tp1.pacial2;

import ar.edu.ort.tp1.pacial2.clases.Bolso;
import ar.edu.ort.tp1.pacial2.clases.DataIncorrectoException;
import ar.edu.ort.tp1.pacial2.clases.Deposito;
import ar.edu.ort.tp1.pacial2.clases.NoDepositadoException;
import ar.edu.ort.tp1.pacial2.clases.Pelota;
import ar.edu.ort.tp1.pacial2.clases.Producto;
import ar.edu.ort.tp1.pacial2.clases.Raqueta;
import ar.edu.ort.tp1.pacial2.clases.Superficie;

public class Parcial2 {

	private static final int ONCE = 11;
	private static int id = 10;

	public static void main(String[] args) throws DataIncorrectoException {

		Deposito d = new Deposito(3);

		depositar(d);

		int unId = 55;
		System.out.println(d.productoDepositado(unId) ? "El producto id " + unId + " está depositado"
				: "El producto id " + unId + " NO está depositado");
		unId = 23;
		System.out.println(d.productoDepositado(unId) ? "El producto id " + unId + " está depositado"
				: "El producto id " + unId + " NO está depositado");

		retiros(d);
	}

	private static void retiros(Deposito d) {
		System.out.println("Se comienza a retirar elementos");
		System.out.println();
		retirar(d, 12);
		System.out.println();
		retirar(d, 13);
		System.out.println();
		retirar(d, 28);
		System.out.println();
		System.out.println("Fin del retiro de elementos");
	}

	private static void retirar(Deposito d, int id) {
		Producto p = d.retirarPorId(id);
		if (p != null) {
			System.out.println("Se retiró el producto id: " + id);
			p.mostrar();
		} else {
			System.out.println("No se pudo retirar producto id: " + id);
		}

	}

	private static void depositar(Deposito d) {

		System.out.println("Depositando productos");
		System.out.println();

		depositarBolso(d, id++, "Wilson", "Us Open");
		System.out.println();
		depositarRaqueta(d, id++, "Wilson", 100);
		System.out.println();
		depositarPelota(d, id++, "Wilson", Superficie.POLVO_LADRILLO);
		System.out.println();
		depositarBolso(d, id++, "", "Us Open 2");
		System.out.println();
		depositarRaqueta(d, 0, "Wilson", 105);
		System.out.println();
		depositarBolso(d, id++, "Wilson", "All Team");
		System.out.println();
		depositarRaqueta(d, id++, "Prince", 98);
		System.out.println();
		depositarPelota(d, id++, "Wilson", Superficie.RAPIDA);
		System.out.println();
		depositarBolso(d, id++, "Wilson", null);
		System.out.println();
		depositarRaqueta(d, id++, "Wilson", 544);
		System.out.println();
		depositarPelota(d, id++, "Wilson", null);
		System.out.println();
		for (int i = 0; i < ONCE; i++) {
			depositarPelota(d, id++, "Wimbledon", Superficie.CESPED);
			System.out.println();
		}
		depositarBolso(d, id++, "Wilson", "Australian Bag");
		System.out.println();
		System.out.println("Fin de los depósitos");
	}

	private static void depositarBolso(Deposito d, int id, String marca, String modelo) {
		// TODO Completar
		
		
		try {
			d.depositar(new Bolso(id, marca, modelo));
			System.out.println("Bolso depositado id: " + id);
		} catch (DataIncorrectoException e) {
			System.out.println(e.getMessage());
		} catch (NoDepositadoException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void depositarRaqueta(Deposito d, int id, String marca, int tamanioAro) {
	
		
		try {
			d.depositar(new Raqueta(id, marca, tamanioAro));
			System.out.println("Raqueta depositado id: " + id);
		} catch (DataIncorrectoException e) {
			System.out.println(e.getMessage());
		} catch (NoDepositadoException e) {
			System.out.println(e.getMessage());
		}
		

		
	}

	private static void depositarPelota(Deposito d, int id, String marca, Superficie superficie) {

		
		try {
			d.depositar(new Pelota(id, marca, superficie));
			System.out.println("Pelota depositado id: " + id);
		} catch (DataIncorrectoException e) {
			System.out.println(e.getMessage());
		} catch (NoDepositadoException e) {
			System.out.println(e.getMessage());
		}
	
	}

}
