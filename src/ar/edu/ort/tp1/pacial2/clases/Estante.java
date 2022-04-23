package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Pila;

public class Estante implements Depositante<Producto, Integer> {

	private Pila<Producto> productos;
	private int cantElementos;
	private int profundidadEstanteria;

	public Estante(int profundidadEstanteria) {
		productos = new PilaNodos<Producto>(profundidadEstanteria);
		this.profundidadEstanteria = profundidadEstanteria;
		cantElementos = 0;
	}

	/**
	 * Agrega un elemento al estante siempre y cuando haya lugar, sino, deberá
	 * emitir la excepción que corresponda..
	 */

	@Override
	public void depositar(Producto elemento) {
		if (cantElementos < profundidadEstanteria) {
			productos.push(elemento);
			cantElementos++;
		} else {
			throw new RuntimeException("No se pudo depositar el producto");
		}

	}

	/**
	 * Retira el producto de la estantería por su id
	 */
	@Override
	public Producto retirarPorId(Integer id) {
		// TODO Auto-generated method stub

		Producto buscado = null;
		Producto productoAuxiliar = null;

		PilaNodos<Producto> pilaAuxiliar = new PilaNodos<Producto>();

		while (!productos.isEmpty() && buscado == null) {

			productoAuxiliar = productos.pop();

			if (productoAuxiliar.getId() == id) {
				// estoy sacando el elemento(No se vuelve a poner si encontro)
				buscado = productoAuxiliar;
				cantElementos--;
			} else {
				pilaAuxiliar.push(productoAuxiliar);
			}
		}
		//reordena la pila
		while (!pilaAuxiliar.isEmpty()) {
			productos.push(pilaAuxiliar.pop());
		}

		return buscado;
	}

}
